package com.github.wotchin;

import java.util.Collection;
import java.util.HashMap;

public class Cookie extends HashMap<String,String> {

   public Cookie(String s){
       if (s != null){
           String []cookies = s.trim().split("[;]");
           for(String it : cookies){
               String []keyAndValue = it.split("[=]");
               if(keyAndValue.length == 2){
                   put(keyAndValue[0],keyAndValue[1]);
               }
           }
       }
   }

   public Cookie() {}


   public void put(String key,Number value){
       put(key, value.toString());
   }

   public static Cookie parse(String s){
       return new Cookie(s);
   }


    @Override
    public String toString(){
       Collection<String> keys = keySet();
       StringBuilder sb = new StringBuilder();
        for (String key :
                keys) {
            sb.append(key)
                    .append("=")
                    .append(get(key))
                    .append(";");
        }
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1); // delete the last ';'
        }
        return sb.toString();
    }
}
