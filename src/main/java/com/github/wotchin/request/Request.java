package com.github.wotchin.request;

import com.github.wotchin.Cookie;

import java.io.InputStream;

public class Request {
    private RequestHeader header = null;
    private RequestBody body = null;

    public Request(String header, InputStream in){
        this.header = new RequestHeader(header);
        this.body = new RequestBody(in);
    }

    public RequestHeader getHeader(){
        return this.header;
    }

    public RequestBody getBody(){
        return this.body;
    }

}
