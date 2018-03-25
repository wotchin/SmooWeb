package com.github.wotchin;

public class HttpServerBuilder{
    String address = "0.0.0.0";
    int port = 8888;
    int threadQueueLength = 100;
    int threadConcurrentNumber = 8;
    int backlog = 5;
    boolean isStdout = false;
    Class event = null;

    public HttpServerBuilder address(String address){
        this.address = address;
        return this;
    }

    public HttpServerBuilder setControllers(Class<?> event){
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

    public HttpServer builder() throws IllegalArgumentException{
        if (event == null){
            throw new IllegalArgumentException("Need parameter");
        }
        else{
            return new HttpServer(this);
        }
    }


    //todo:
    public static HttpServer parseJSON(){
        return null;
    }
}

