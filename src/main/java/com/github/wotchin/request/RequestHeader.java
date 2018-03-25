package com.github.wotchin.request;

import com.github.wotchin.Cookie;
import com.github.wotchin.URI;


import java.util.HashMap;

public class RequestHeader extends HashMap<String,String>{

    private String header = null;
    private String uri = null;
    private RequestMethod method = null;
    private String protocol = null;


    public RequestHeader(String header){

        this.header = header;
        String []array = header.split("\r\n");
        if(array.length  <= 2){
            array = header.split("\n");
        }
        for(String line : array){
            String []keyAndValue = line.split("[:]");
            if(keyAndValue.length == 2){
                put(keyAndValue[0],keyAndValue[1].trim());
            }else if(keyAndValue.length > 2){
                String key = keyAndValue[0];
                put(key,line.substring(key.length() + 1));
            }else{
                if(line.startsWith("GET ")){
                    method = RequestMethod.GET;
                    int index = line.indexOf("HTTP");
                    uri = line.substring(4,index - 1);//4 means the length of "GET "
                    protocol = line.substring(index);
                }else if(line.startsWith("POST ")){
                    method = RequestMethod.POST;
                    int index = line.indexOf("HTTP");
                    uri = line.substring(5,index - 1);
                    protocol = line.substring(index);
                }else if(line.startsWith("PUT ")){
                    method = RequestMethod.PUT;
                    int index = line.indexOf("HTTP");
                    uri = line.substring(4,index - 1);
                    protocol = line.substring(index);
                }else if(line.startsWith("DELETE ")){
                    method = RequestMethod.GET;
                    int index = line.indexOf("HTTP");
                    uri = line.substring(7,index - 1);
                    protocol = line.substring(index);
                }
            }
        }
    }

    public Cookie getCookie(){

        String cookie = get("Cookie");
        if(cookie == null){
            return null;
        }else {
            return new Cookie(cookie);
        }
    }

    public URI getUri() {
        return new URI(this.uri);
    }

    public String getProtocol() {
        return protocol;
    }

    public RequestMethod getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return this.header;
    }

}
