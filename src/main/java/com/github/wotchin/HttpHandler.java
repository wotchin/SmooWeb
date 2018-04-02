package com.github.wotchin;

import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestHeader;
import com.github.wotchin.response.Response;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class HttpHandler {
    HttpHandler(Socket socket) {
        //customer
        //消费来自HttpServer的socket，进行HTTP协议的解析

        try {
//            BIO
            //此处有坑，留坑待补充完善，阻塞问题。
            InputStream in = socket.getInputStream();
            List<Byte> buff = new LinkedList<>();
            int val = 0;
            while ((val = in.read()) > 0){
                buff.add((byte)val);
            }
            //todo: reader?
            //是否应该用一个类包装这个socket

            Request req = new Request(sb.toString(),reader);
            Response res = new Response(socket.getOutputStream());
            RequestHeader header = req.getHeader();

            Router router = Router.getInstance();
            UnusualEvent unusualEvent = router.getUnusualEvent();
            Object[] objects;
            URI uri = header.getUri();
            if(uri != null){
                if ((objects = router.getMethod(uri,header.getMethod()))!=null)
                {
                    try {

                        //((Method)objects[1]).invoke(objects[0],req,res);
                        ((Method)objects[1]).invoke(((Class)(objects[0])).newInstance(),req,res);
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
