package com.github.wotchin.response;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

/**
 * @author wotchin
 * This class is a abstract of http response head
 * */
public class ResponseHeader extends HashMap<String,String>{

    private StatusCode.KeyAndValuePair status = null;

    ResponseHeader(){
        super(8);
        put("Server","SmooWeb/1.0");
        //todo: Keep-Alive
        put("Connection","close");
        Date date = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime();
        //todo:format?
        put("Date",date.toString());
    };

    public void set(String name,Number value){
        set(name,value.toString());
    }

    public void set(String name,String value){
        put(name,value);
    }

    public void setContentType(ContentType type){
        put("Content-Type",type.toString());
    }

    public void setStateCode(StatusCode statecode){
        status = statecode.getStateCode();
    }

    public void setStateCode(int stateCode){
        status = StatusCode.search(stateCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 ").append(status.key).append(" ").append(status.value).append("\r\n");

        for(String key : keySet()){
            sb.append(key)
              .append(": ")
              .append(get(key))
              .append("\r\n");
        }
        sb.append("\r\n");

        return sb.toString();
    }

}
