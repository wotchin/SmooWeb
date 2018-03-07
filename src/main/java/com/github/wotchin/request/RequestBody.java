package com.github.wotchin.request;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RequestBody {

    private InputStream in = null;
    RequestBody(InputStream in){
        this.in = in;
    }

    public InputStream getStream(){
        return this.in;
    }

    public byte[] getBytes() throws IOException{
        ByteArrayOutputStream bulk = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int len = 0;
        while ((len = in.read(buff,0,100))>0){
            bulk.write(buff,0,len);
        }
        return bulk.toByteArray();
    }


}
