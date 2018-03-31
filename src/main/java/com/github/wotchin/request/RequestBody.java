package com.github.wotchin.request;


import java.io.*;
import java.util.Map;

public class RequestBody {

    private InputStream in = null;
    RequestBody(InputStream in){
        this.in = in;
    }

    public Map<String,String> getValue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null){
           sb.append(line);
        }

    }

    public byte[] getFile(){
        //NIO
    }

}
