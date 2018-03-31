package com.github.wotchin;


import com.github.wotchin.annotation.RequestMapping;
import com.github.wotchin.request.RequestMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class RequestMapper {

    //todo:
    //加入解析文件路径的方法

    void parseAnnotation(Class<?> clazz) {
        Method[] method = clazz.getDeclaredMethods();
        Router router = Router.getInstance();
        /*
        Object object = null;
        try {
            object = router.putInstance(clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        */
        Object object = router.putInstance(clazz);
        if(object != null){
            for (Method m  : method) {
                if (m.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping =  m.getAnnotation(RequestMapping.class);
                    URI uri = new URI(requestMapping.value());
                    RequestMethod requestMethod = requestMapping.method();
                    router.putMethod(uri,requestMethod,new Object[]{object,m});
                    System.out.println(m.getName() + " " + uri.getFullString() + " " + requestMethod.toString() );
                    /*todo:
                     * 映射结构:
                     *
                     *
                     * */
                }
            }
        }
        //TODO：正则解析形式
    }
}
