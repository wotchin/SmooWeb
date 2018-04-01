package com.github.wotchin.request;


import com.github.wotchin.utils.RequestUtils;

import java.io.*;
import java.util.Map;

public class RequestBody {

    private BufferedReader reader = null;
    private int contentLength = 0;
    RequestBody(BufferedReader reader, String length){
        this.reader = reader;
        this.contentLength = length == null?0:Integer.valueOf(length);
    }

    public Map<String,String> getValue() {

        System.out.println(contentLength);
        if(contentLength > 0){
            StringBuilder sb = new StringBuilder(contentLength);
            String line = null;
            try {
                while ((line = reader.readLine()) != null){
                    System.out.println("line: " + line);
                }

                return RequestUtils.parseQuery(sb.toString());
            }catch (IOException e){
                return null;
            }

        }else {
            return null;
        }
    }

    public byte[] getFile(){
        //NIO
        return null;
    }

}
