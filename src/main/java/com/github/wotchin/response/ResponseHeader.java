package com.github.wotchin.response;


import com.sun.istack.internal.Nullable;

/**
 * @author wotchin
 * This class is a abstract of http response head
 * */
class ResponseHeader {
    private StringBuilder sb = new StringBuilder();
    //todo:
    //应该改成Map替代sb.
    ResponseHeader(){

    };
    public void set(String name,String value){
        sb.append(name);
        sb.append(":");
        sb.append(value);
        sb.append("\r\n");
    }

    public void addLine(String line){
        sb.append(line);
        sb.append("\r\n");
    }

    public void setStatecode(int statecode, @Nullable String name){
        if(name == null)
            name = "OK";
        sb.append("HTTP/1.1 ")
                .append(statecode)
                .append(" ")
                .append(name)
                .append("\r\n");
    }

    @Override
    public String toString() {
        return sb.toString() + "\r\n";
    }

}
