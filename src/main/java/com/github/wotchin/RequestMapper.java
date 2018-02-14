package com.github.wotchin;


import com.github.wotchin.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class RequestMapper {

    Map getAnnotation(Class<?> clazz) {
        Map<String, Method> map = new HashMap<>();
        Method[] method = clazz.getDeclaredMethods();
        for (Method m  : method) {
            System.out.println(m.getName());
            if (m.isAnnotationPresent(RequestMapping.class)) {
                String value = m.getAnnotation(RequestMapping.class).value();
                    map.put(value,m); //创建映射关联
            }
            if (m.getName().equals("index")){
                map.put("/",m);
            }
        }
        //TODO：正则解析形式
        //留坑，静态文件传输映射表还没有创建
        return map;
    }
}
