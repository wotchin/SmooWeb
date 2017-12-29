package com.github.wotchin;

import java.util.Date;

public class ResponseHeadFactory {
    public static ResponseHead standardHead(){
        ResponseHead responseHead = new ResponseHead();
        responseHead.addLine("HTTP/1.1 200 OK");
        responseHead.set("Content-Type","text/html; charset=utf-8");
        responseHead.set("Date", new Date().toString());
        responseHead.set("Server","TinyHttp/1.0");
        return responseHead;
    }

    public static ResponseHead serverErrorHead(){
        ResponseHead responseHead = new ResponseHead();
        responseHead.addLine("HTTP/1.1 500 Internal Server Error");
        responseHead.set("Content-Type","text/html; charset=utf-8");
        responseHead.set("Date", new Date().toString());
        responseHead.set("Server","TinyHttp/1.0");
        return responseHead;
    }

    public static ResponseHead downloadFileHead(){
        ResponseHead responseHead = new ResponseHead();
        responseHead.addLine("HTTP/1.1 200 OK");
        responseHead.set("Content-Type","application/octet-stream");
        responseHead.set("Date", new Date().toString());
        responseHead.set("Server","TinyHttp/1.0");
        return responseHead;
    }

    public static ResponseHead notfoundHead(){
        ResponseHead responseHead = new ResponseHead();
        responseHead.addLine("HTTP/1.1 404 Not Found");
        responseHead.set("Date", new Date().toString());
        responseHead.set("Server","TinyHttp/1.0");
        return responseHead;
    }

    /**
     * @param location location is the redirect URL.
     * */
    public static ResponseHead redirectHead(String location){
        ResponseHead responseHead = new ResponseHead();
        responseHead.addLine("HTTP/1.1 302 Found");
        responseHead.set("Date", new Date().toString());
        responseHead.set("location",location);
        responseHead.set("Server","TinyHttp/1.0");
        return responseHead;
    }
}
