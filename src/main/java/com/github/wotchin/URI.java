package com.github.wotchin;

import com.github.wotchin.utils.UrlUtils;

import java.util.Map;

public class URI {

    private String raw = null;
    private String path = null;
    private String query = null;


    public URI(String uri){
        if(uri != null){
            this.raw = uri.trim().toLowerCase();
            if(!this.raw.startsWith("/")){
                this.raw = "/" + this.raw;
            }
        }
    }

    public String getPath(){
        if(this.raw != null){
            int index = this.raw.lastIndexOf("/");
            return raw.substring(0,index);
        }else {
            return null;
        }
    }


    public Map<String,String> getQuery(){
        return UrlUtils.parseQuery(raw);
    }


    @Override
    public String toString() {
        if(this.raw != null){
            int index = this.raw.lastIndexOf("?");
            String uri = null;
            if(index < 0){
                uri = this.raw;
            }else {
                uri = raw.substring(0, index);
            }
            return uri.replaceAll("/<(.*?)>","/<parameter>");
            //将正则的形式统一化
        }else {
            return "";
        }
    }

    public String getFullString() {
        return raw;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj instanceof URI){
            URI another = (URI)obj;
            return another.toString().equals(this.toString());
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
