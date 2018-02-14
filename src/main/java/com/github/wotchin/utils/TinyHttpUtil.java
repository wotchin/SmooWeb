package com.github.wotchin.utils;

import java.util.HashMap;
import java.util.Map;

public  class  TinyHttpUtil {

    private static String TruncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;

        strURL = strURL.trim();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                if (arrSplit[1] != null) {
                    strAllParam = arrSplit[1];
                }
            }else{
                strAllParam = strURL;
            }
        }
        return strAllParam;
    }

    public static Map<String,String> parseRequestParameter(String string){
        Map<String,String> map = new HashMap<>();
        String[] arrSplit=null;
        String strUrlParam=TruncateUrlPage(string);
        if(strUrlParam==null)
        {
            return map;
        }
        arrSplit=strUrlParam.split("[&]");
        for(String strSplit:arrSplit)
        {
            String[] arrSplitEqual=null;
            arrSplitEqual= strSplit.split("[=]");

            //解析出键值
            if(arrSplitEqual.length>1)
            {
                //正确解析
                map.put(arrSplitEqual[0], arrSplitEqual[1]);

            }
            else
            {
                if(arrSplitEqual[0].equals(""))
                {
                    //只有参数没有值，不加入
                    map.put(arrSplitEqual[0], "");
                }
            }
        }
        return map;
    }

}
