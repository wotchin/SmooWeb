package com.github.wotchin;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

class HttpServer {

    HttpServer(HttpServerBuilder builder){
        String address = builder.address;
        int port = builder.port;
        int backlog = builder.backlog;
        int threadConcurrentNumber = builder.threadConcurrentNumber;
        int threadQueueLength = builder.threadQueueLength; //手写线程池 留坑
        Class event = builder.event;

        //initial
        try {
            ServerSocket server = new ServerSocket(port, backlog, Inet4Address.getByName(address));
            ThreadPool thread = ThreadPool.getInstance();
            Map router = new RequestMapper().parseAnnotation(event);
            WebController webControllerTemplate = (WebController) event.newInstance();//反射加载
            //TODO:
            //此处应该该为使用静态文件加载
            while (true){
                Socket socket = server.accept();
                thread.submit(()->{
                    System.out.println(socket.getLocalAddress().toString() +":"+ socket.getPort()); //Filter 留坑
                    new HttpHandler(socket,router, webControllerTemplate);
                    //TODO:
                    //此处有坑，内存消耗太大了，等待后续优化
                });
            }

        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
