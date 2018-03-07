package com.github.wotchin;


import com.github.wotchin.utils.TinyHttpUtil;

import java.util.Map;

public class Cookie {
   private Map<String,String> cookie = null;

   public Cookie(String s){
      //TODO:COOKIE
   }

   public String put(String key , String value){
      return cookie.put(key,value);
   }

   public String get(String key){
      return cookie.get(key);
   }

    @Override
    public String toString() {
        return cookie.toString();
    }
}
