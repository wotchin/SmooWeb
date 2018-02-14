package com.github.wotchin;

import com.github.wotchin.request.HttpRequest;
import com.github.wotchin.response.HttpResponse;

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
//            new HttpRouter(new HttpRequest(sb.toString()),RouterTemplate,socket_info);  //是否应该是单例的？或者是 静态的呢？

            //先在此处写好处理代码，然后再决定是否进行类的拆分
            HttpRequest head = new HttpRequest(sb.toString(),socket.getInetAddress().toString()+":"+socket.getPort());
            byte []data = null;
            String methodName = head.getUri().trim().split("[?]")[0];
            if (router.get(methodName)!=null)
            {
                Method method = router.get(methodName);
                try {
                    HttpResponse hr = (HttpResponse)method.invoke(template,head);
                    data = hr.getData();
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        data = template.serverError(head,e.toString()).getData();
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            }
            else
            {
                try {
                    data = template.notFound(head).getData();
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
