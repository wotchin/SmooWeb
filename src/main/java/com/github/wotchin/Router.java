package com.github.wotchin;

import com.github.wotchin.request.RequestMethod;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Router {
    private static Router ourInstance = new Router();
    private UnusualEvent unusualEvent = null;

    /**
     * 分桶存储:
     * GET POST DELETE PUT
     * 分别存储，常规路径和正则路径一起存储，数据结构是HashMap
     * HashMap中的Key使用URI对象,URI中要处理包括正则的部分
     *
     * */

    private Map<URI,Object[]> methodGet = null;
    private Map<URI,Object[]> methodPost = null;
    private Map<URI,Object[]> methodDelete = null;
    private Map<URI,Object[]> methodPut = null;

    private Router() {
    }

    public static Router getInstance() {
        return ourInstance;
    }

    private List<Object> instances = new LinkedList<>();

    public Object putInstance(Object object){
        instances.add(object);
        return object;
    }

    public Object[] getMethod(URI uri,RequestMethod requestMethod){
        switch (requestMethod){
            case GET:{
                if(methodGet == null){
                    return null;
                }else {
                    Object[] objects = methodGet.get(uri);
                    if(objects == null){
                        methodGet.get(uri);
                    }
                    return objects;
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

    //todo:
    //Need instance
    public void putMethod(URI uri,RequestMethod requestMethod ,Object[] objects){
        switch (requestMethod){
            case GET:{
                if(methodGet == null){
                    methodGet = new HashMap<>();
                }
                methodGet.put(uri,objects);
                break;
            }
            case POST:{
                if(methodPost == null){
                    methodPost = new HashMap<>();
                }
                methodPost.put(uri,objects);
                break;
            }
            case PUT:{
                if(methodPut == null){
                    methodPut = new HashMap<>();
                }
                methodPut.put(uri,objects);
                break;
            }
            case DELETE:{
                if(methodDelete == null){
                    methodDelete = new HashMap<>();
                }
                methodDelete.put(uri,objects);
                break;
            }
        }
    }

    public UnusualEvent getUnusualEvent(){
        return unusualEvent;
    }

    public void setUnusualEvent(UnusualEvent event){
        this.unusualEvent = event;
    }
}
