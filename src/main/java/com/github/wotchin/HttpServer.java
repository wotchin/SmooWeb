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
        Class event = builder.event; //todo

        ThreadPool thread = ThreadPool.getInstance();
        Map router = new RequestMapper().parseAnnotation(event);
        WebController controllers = null;
        try {
            controllers = (WebController) event.newInstance();//反射加载
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if(controllers == null){
            throw new IllegalArgumentException("No WebControllers!");
        }
        //initial
        try {
            ServerSocket server = new ServerSocket(port, backlog, Inet4Address.getByName(address));
            //TODO:
            while (true){
                Socket socket = server.accept();
                WebController finalControllers = controllers;
                thread.submit(()->{
                    System.out.println(socket.getLocalAddress().toString() +" -> "+ socket.getPort());
                    new HttpHandler(socket,router, finalControllers);
                    System.out.println("done");
                    //TODO:
                    //此处有坑，内存消耗太大了，等待后续优化
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
