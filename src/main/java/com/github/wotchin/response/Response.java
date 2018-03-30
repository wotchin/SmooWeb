package com.github.wotchin.response;

import org.json.JSONObject;

import java.io.*;

public class Response {


    private OutputStream out = null;
    private ResponseHeader header = null;

    public Response(OutputStream out){
        this.out = out;
        this.header = new ResponseHeader();
        this.header.setStateCode(200);
        this.header.setContentType(ContentType.TEXT_HTML);
    }

    public boolean end(){
        boolean ret = true;
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            ret = false;
        }
        return ret;
    }

    public boolean end(String body) {

        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            header.set("Content-Length",body.length());
            bw.write(header.toString());
            bw.flush();
            bw.write(body);
            bw.flush();
            bw.close();//close the connection.
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }

    }



    //todo:
    public boolean end(ResponseBody body){

        //Send file or some others.
        return true;
    }

    public boolean end(JSONObject json) {
        header.setContentType(ContentType.APPLICATION_JSON);
        return end(json.toString());
    }


    public ResponseHeader getHeader(){
        return this.header;//返回一个引用
    }

    public void setHeader(ResponseHeader header){
        this.header = header;
    }

}
