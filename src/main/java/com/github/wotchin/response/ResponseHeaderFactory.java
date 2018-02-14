package com.github.wotchin.response;

import java.util.Date;

public class ResponseHeaderFactory {
    public static ResponseHeader standardHead(){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.addLine("HTTP/1.1 200 OK");
        responseHeader.set("Content-Type","text/html; charset=utf-8");
        responseHeader.set("Date", new Date().toString());
        responseHeader.set("Server","TinyHttp/1.0");
        return responseHeader;
    }

    public static ResponseHeader serverErrorHead(){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.addLine("HTTP/1.1 500 Internal Server Error");
        responseHeader.set("Content-Type","text/html; charset=utf-8");
        responseHeader.set("Date", new Date().toString());
        responseHeader.set("Server","TinyHttp/1.0");
        return responseHeader;
    }

    public static ResponseHeader downloadFileHead(){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.addLine("HTTP/1.1 200 OK");
        responseHeader.set("Content-Type","application/octet-stream");
        responseHeader.set("Date", new Date().toString());
        responseHeader.set("Server","TinyHttp/1.0");
        return responseHeader;
    }

    public static ResponseHeader notfoundHead(){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.addLine("HTTP/1.1 404 Not Found");
        responseHeader.set("Date", new Date().toString());
        responseHeader.set("Server","TinyHttp/1.0");
        return responseHeader;
    }

    /**
     * @param location location is the redirect URL.
     * */
    public static ResponseHeader redirectHead(String location){
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.addLine("HTTP/1.1 302 Found");
        responseHeader.set("Date", new Date().toString());
        responseHeader.set("location",location);
        responseHeader.set("Server","TinyHttp/1.0");
        return responseHeader;
    }
}
