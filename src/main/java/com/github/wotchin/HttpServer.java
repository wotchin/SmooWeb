package com.github.wotchin;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class HttpServer {

    private HttpServer(HttpServerBuilder builder){
        String address = builder.address;
        int port = builder.port;
        int backlog = builder.backlog;
        int threadConcurrentNumber = builder.threadConcurrentNumber;
        int threadQueueLength = builder.threadQueueLength; //手写线程池 留坑
        Class event = builder.event;

        //initial
        try {
            ServerSocket server = new ServerSocket(port, backlog, Inet4Address.getByName(address));
            ThreadPoolSingleton thread = ThreadPoolSingleton.getInstance(threadConcurrentNumber);
            Map router = new ResponseAnnotationParsing().getAnnotation(event);
            RouterTemplate routerTemplate = (RouterTemplate) event.newInstance();

            while (true){
                Socket socket = server.accept();
                thread.submit(()->{
                    System.out.println(socket.getLocalAddress().toString() +":"+ socket.getPort()); //Filter 留坑
                    new HttpHandler(socket,router, routerTemplate);
                });
            }

        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }





    public static class HttpServerBuilder{
        private String address = "0.0.0.0";
        private int port = 8888;
        private int threadQueueLength = 100;
        private int threadConcurrentNumber = 8;
        private int backlog = 5;
        private boolean isStdout = false;
        private Class event = null;

        public HttpServerBuilder address(String address){
            this.address = address;
            return this;
        }

        public HttpServerBuilder setResponseRouterTemplate(Class<?> event){
            this.event = event;
            return this;
        }

        public HttpServerBuilder isStdout(boolean isStdout) {
            this.isStdout = isStdout;
            return this;
        }

        public HttpServerBuilder port(int port){
            this.port = port;
            return this;
        }

        public HttpServerBuilder threadQueueLength(int length){
            this.threadQueueLength = length;
            return this;
        }

        public HttpServerBuilder threadConcurrentNumber(int number){
            this.threadConcurrentNumber = number;
            return this;
        }

        public HttpServerBuilder backlog(int backlog){
            this.backlog = backlog;
            return this;
        }

        public HttpServer builder() throws Exception{
            /*
            if (event == null)
                throw new Exception("Need RouterTemplate parameter");
            else
                return new HttpServer(this);
                */
            assert event!=null:"Need RouterTemplate!";
            return new HttpServer(this);
        }
    }
}
