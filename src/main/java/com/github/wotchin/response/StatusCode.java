package com.github.wotchin.response;

import java.util.HashMap;

public class StatusCode {

    private final static HashMap<Integer,String> MAP = new HashMap<>(64);
    static {
        MAP.put(100,"Continue");
        MAP.put(101,"Switching Protocols");
        MAP.put(200,"OK");
        MAP.put(201,"Created");
        MAP.put(202,"Accepted");
        MAP.put(203,"Non-Authoritative Information");
        MAP.put(204,"No Content");
        MAP.put(205,"Reset Content");
        MAP.put(206,"Partial Content");
        MAP.put(300,"Multiple Choices");
        MAP.put(301,"Moved Permanently");
        MAP.put(302,"Found");
        MAP.put(303,"See Other");
        MAP.put(304,"Not Modified");
        MAP.put(305,"Use Proxy");
        MAP.put(306,"Unused");
        MAP.put(307,"Temporary Redirect");
        MAP.put(400,"Bad Request");
        MAP.put(401,"Unauthorized");
        MAP.put(402,"Payment Required");
        MAP.put(403,"Forbidden");
        MAP.put(404,"Not Found");
        MAP.put(405,"Method Not Allowed");
        MAP.put(406,"Not Acceptable");
        MAP.put(407,"Proxy Authentication Required");
        MAP.put(408,"Request Time-out");
        MAP.put(409,"Conflict");
        MAP.put(410,"Gone");
        MAP.put(411,"Length Required");
        MAP.put(412,"Precondition Failed");
        MAP.put(413,"Request Entity Too Large");
        MAP.put(414,"Request-URI Too Large");
        MAP.put(415,"Unsupported Media Type");
        MAP.put(416,"Requested range not satisfiable");
        MAP.put(417,"Expectation Failed");
        MAP.put(500,"Internal Server Error");
        MAP.put(501,"Not Implemented");
        MAP.put(502,"Bad Gateway");
        MAP.put(503,"Service Unavailable");
        MAP.put(504,"Gateway Time-out");
        MAP.put(505,"HTTP Version not supported");
    }


    static class KeyAndValuePair{
        int key;
        String value;
    }

    private KeyAndValuePair status = new KeyAndValuePair();

    public StatusCode(int stateCode){
        status.key = stateCode;
        status.value = MAP.get(stateCode);
    }

    public StatusCode(int stateCode, String content){
        status.key = stateCode;
        status.value = content;
    }

    public static KeyAndValuePair search(int stateCode){
        KeyAndValuePair pair = new KeyAndValuePair();
        pair.value = MAP.get(stateCode);
        pair.key = stateCode;
        return pair;
    }

    KeyAndValuePair getStateCode() {
        return status;
    }
}

