package com.github.wotchin;

import com.github.wotchin.request.Request;
import com.github.wotchin.request.RequestHeader;
import com.github.wotchin.response.HttpResponse;
import com.github.wotchin.response.Response;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

class HttpHandler {
    HttpHandler(Socket socket, Map<String,Method> router , RouterTemplate template) {
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
            Response res = new Response();
            RequestHeader header = req.getHeader();
            String methodName = header.getUri().trim().split("[?]")[0];
            if (router.get(methodName)!=null)
            {
                Method method = router.get(methodName);
                try {
                    HttpResponse hr = (HttpResponse)method.invoke(template,header);
                    data = hr.getData();
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        data = template.serverError(header,e.toString()).getData();
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            }
            else
            {
                try {
                    data = template.notFound(header).getData();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            OutputStream out = socket.getOutputStream();
            if (data == null){
                data = "HTTP/1.1 500 Internal Server Error\r\n\r\n".getBytes();
            }
            out.write(data);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
