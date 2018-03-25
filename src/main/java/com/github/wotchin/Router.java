package com.github.wotchin;

import com.github.wotchin.request.RequestMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private static Router ourInstance = new Router();
    public static Router getInstance() {
        return ourInstance;
    }

    /**
     * 分桶存储:
     * GET POST DELETE PUT
     * 分别存储，常规路径和正则路径一起存储，数据结构是HashMap
     * HashMap中的Key使用URI对象,URI中要处理包括正则的部分
     *
     * */

    private Map<URI,Method> methodGet = null;
    private Map<URI,Method> methodPost = null;
    private Map<URI,Method> methodDelete = null;
    private Map<URI,Method> methodPut = null;

    private Router() {
    }


    public Method getMethod(URI uri,RequestMethod requestMethod){
        switch (requestMethod){
            case GET:{
                if(methodGet == null){
                    return null;
                }else {
                    Method method = methodGet.get(uri);
                    if(method == null){
                        methodGet.get()
                    }
                    return method;
                }

            }
            case POST:{
                if(methodPost == null){
                    return null;
                }else {
                    return methodPost.get(uri);
                }
            }
            case PUT:{
                if(methodPut == null){
                    return null;
                }else {
                    return methodPut.get(uri);
                }
            }
            case DELETE:{
                if(methodDelete == null){
                    return null;
                }else {
                    return methodDelete.get(uri);
                }
            }
            default:{
                return null;
            }
        }
    }

    //todo:
    //正则怎么处理?是用树还是怎么办?

    public void putMethod(URI uri,RequestMethod requestMethod ,Method method){
        switch (requestMethod){
            case GET:{
                if(methodGet == null){
                    methodGet = new HashMap<>();
                }
                methodGet.put(uri,method);
                break;
            }
            case POST:{
                if(methodPost == null){
                    methodPost = new HashMap<>();
                }
                methodPost.put(uri,method);
                break;
            }
            case PUT:{
                if(methodPut == null){
                    methodPut = new HashMap<>();
                }
                methodPut.put(uri,method);
                break;
            }
            case DELETE:{
                if(methodDelete == null){
                    methodDelete = new HashMap<>();
                }
                methodDelete.put(uri,method);
                break;
            }
        }
    }
}
