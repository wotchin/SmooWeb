package com.github.wotchin;


import com.github.wotchin.annotation.RequestMapping;
import com.github.wotchin.request.RequestMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class RequestMapper {

    //todo:
    //加入解析文件路径的方法

    Map parseAnnotation(Class<?> clazz) {
        Map<String, Method> map = new HashMap<>();
        Method[] method = clazz.getDeclaredMethods();
        for (Method m  : method) {
            if (m.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping requestMapping =  m.getAnnotation(RequestMapping.class);
                String path = requestMapping.value();
                RequestMethod requestMethod = requestMapping.method();
                map.put(path,m); //创建映射关联
                System.out.println(m.getName() + " " + path + " " + requestMethod.toString() );
                /*todo:
                * 映射结构:
                *
                *
                * */
            }
        }
        //TODO：正则解析形式
        //留坑，静态文件传输映射表还没有创建
        //静态文件使用Nginx完成传输
        return map;
    }
}
