package com.github.wotchin.response;

import java.io.OutputStream;

public class Response {

    private OutputStream out = null;
    private ResponseHeader header = new ResponseHeader();

    public Response(OutputStream out){
        this.out = out;
    }

    public void end(){
        //todo:
        //output streaming is end.

        //重载:
        //既可以返回文件(字节数组) 也可以返回文本  也可以返回JSON
        //吸取Node的API形式,使用end方法显性地返回结果
    }


    public ResponseHeader getHeader(){
        return header;//返回一个引用
    }

    public OutputStream getStream(){
        return out;
    }
}
