package com.github.wotchin;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class ResponseAnnotationParsing {

    Map getAnnotation(Class<?> clazz) {
        Map<String, Method> map = new HashMap<>();
        Method[] method = clazz.getDeclaredMethods();
        for (Method m  : method) {
            System.out.println(m.getName());
            if (m.isAnnotationPresent(Router.class)) {
                String value = m.getAnnotation(Router.class).value();
                    map.put(value,m); //创建映射关联
            }
            if (m.getName().equals("homepage")){
                map.put("/",m);
            }
        }
        //留坑，静态文件传输映射表还没有创建
        return map;
    }
}
