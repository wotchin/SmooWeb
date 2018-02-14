package com.github.wotchin.response;

import java.util.Map;

public class HttpResponseBuilder {

    private int statusCode = 200;
//    private StringBuilder sb = new StringBuilder();
    private ResponseHeader head = new ResponseHeader();
    private byte[] data = null;

    public HttpResponseBuilder setStatusCode(int statusCode){
        this.statusCode = statusCode;
        return this;
    }

    public HttpResponseBuilder setHead(ResponseHeader head){
//        this.sb.append(head.replace("\r\n","")).append("\r\n");
        this.head = head;
        return this;
    }

    public HttpResponseBuilder setCookies(Map<String,String> cookies){
        //留坑
        return this;
    }

    public HttpResponseBuilder setContentType(String type){
        head.set("Content-Type:",type);
        return this;
    }

    public HttpResponseBuilder bodyData(byte[] data){
        this.data = data;
        return this;
    }

    public HttpResponseBuilder bodyText(String text){
        this.data = text.getBytes();
        return this;
    }

    public HttpResponse builder(){

        head.addLine("HTTP/1.1 " + statusCode +" OK");
        return new HttpResponse(head,data);
    }
}
