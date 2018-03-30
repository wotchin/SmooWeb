package com.github.wotchin;

import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestHeader;
import com.github.wotchin.response.Response;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

class HttpHandler {
    HttpHandler(Socket socket) {
        //customer
        //消费来自HttpServer的socket，进行HTTP协议的解析

        try {
//            BIO
            //此处有坑，留坑待补充完善，阻塞问题。
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String buff;
            StringBuilder sb = new StringBuilder();
            while ((buff = reader.readLine()) != null){
                if(buff.length() > 0){
                    sb.append(buff);
                    sb.append("\n");
                }else{
                    break;
                }
            }


            Request req = new Request(sb.toString(),socket.getInputStream());
            Response res = new Response(socket.getOutputStream());
            RequestHeader header = req.getHeader();

            Router router = Router.getInstance();
            UnusualEvent unusualEvent = router.getUnusualEvent();
            Method method;
            URI uri = header.getUri();
            if(uri != null){
                if ((method = router.getMethod(uri,header.getMethod()))!=null)
                {
                    try {
                        method.invoke(unusualEvent,req,res);
                        //todo:
                        //此处之后应该改为单例模式，懒加载形式，缓存
                    } catch (Exception e) {
                        e.printStackTrace();

                        unusualEvent.internalServerError(req,res);
                    }
                }
                else
                {
                    unusualEvent.notFound(req,res);
                }
            }else {
                unusualEvent.badRequest(req,res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                socket.close();
            }catch (IOException e){
                //防止内存泄露
                e.printStackTrace();
            }
        }
    }
}
