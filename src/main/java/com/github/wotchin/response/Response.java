package com.github.wotchin.response;

import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;

public class Response {

    //todo:
    //应该加入防止内存泄露的机制

    private OutputStream out = null;
    private ResponseHeader header = new ResponseHeader();

    public Response(OutputStream out){
        this.out = out;
    }

    public boolean end(){
        //todo:
        //output streaming is end.

        //重载:
        //既可以返回文件(字节数组) 也可以返回文本  也可以返回JSON
        //吸取Node的API形式,使用end方法显性地返回结果
        boolean ret = true;
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    public boolean end(String string) {

        try{
            if(header.toString().trim().equals(""))
                header = ResponseHeaderFactory.standardHead();
            out.write(header.toString().getBytes());
            out.write(string.getBytes());
            out.flush();
            out.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean end(JSONObject json) {

        try{
            if(header.toString().trim().equals(""))
                header = ResponseHeaderFactory.standardHead();
            //header.set("contentType","application/json");
            out.write(header.toString().getBytes());
            out.write(json.toString().getBytes());
            out.flush();
            out.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }


    public ResponseHeader getHeader(){
        return this.header;//返回一个引用
    }

    public OutputStream getStream(){
        return out;
    }
}
