package com.github.wotchin;

import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestHeader;
import com.github.wotchin.response.Response;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

class HttpHandler {
    HttpHandler(Socket socket, Map<String,Method> router , WebController template) {
        //customer
        //消费来自HttpServer的socket，进行HTTP协议的解析

        try {
//            BIO
            //此处有坑，留坑待补充完善，阻塞问题。
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String buff;
            StringBuilder sb = new StringBuilder();
            while ((buff = reader.readLine()).length() != 0){
                sb.append(buff);
                sb.append("\n");
            }

            //先在此处写好处理代码，然后再决定是否进行类的拆分

            Request req = new Request(sb.toString(),socket.getInputStream());
            Response res = new Response(socket.getOutputStream());
            RequestHeader header = req.getHeader();
            String requestUrl = header.getUri().trim().split("[?]")[0]; //get url path
            if (router.get(requestUrl)!=null)
            {
                Method method = router.get(requestUrl);
                try {
                    //此处应该改一下
                    method.invoke(template,req,res);
                    //todo:
                    //此处之后应该改为单例模式，懒加载形式，缓存
                    //data = hr.getData();
                } catch (Exception e) {
                    e.printStackTrace();

                    template.serverError(req,res);
                }
            }
            else
            {
                try {
                    template.notFound(req,res);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                socket.close();
            }catch (IOException e){
                //防止内存泄露
            }
        }
    }
}
