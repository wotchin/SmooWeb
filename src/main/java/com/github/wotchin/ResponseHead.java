package com.github.wotchin;

/**
 * @author wotchin
 * This class is a abstract of http response head
 * */
class ResponseHead {
    private StringBuilder sb = new StringBuilder();
    ResponseHead(){};
    void set(String name,String value){
        sb.append(name);
        sb.append(":");
        sb.append(value);
        sb.append("\r\n");
    }

    void addLine(String line){
        sb.append(line);
        sb.append("\r\n");
    }

    String getAll(){
        sb.append("\r\n");
        return sb.toString();
    }
}
