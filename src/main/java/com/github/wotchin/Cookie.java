package com.github.wotchin;

import java.util.Map;

public class Cookie {
   private Map<String,String> cookie = null;

   public Cookie(String s){
      //TODO:COOKIE
       if (s != null){
           String []cookies = s.split("; ");
           for(String it : cookies){
               String []keyAndValue = it.split("=");
               if(keyAndValue.length == 2){
                   cookie.put(keyAndValue[0],keyAndValue[1]);
               }
           }
       }
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
