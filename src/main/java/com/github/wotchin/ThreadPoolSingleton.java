package com.github.wotchin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSingleton {

    private static volatile ThreadPoolSingleton thread = null;
    private ExecutorService service = null;
    private ThreadPoolSingleton() {}

    public static ThreadPoolSingleton getInstance(int threadNumber){
        if (thread == null){
            synchronized (ThreadPoolSingleton.class){
                if (thread == null){
                    thread = new ThreadPoolSingleton();
                    if (threadNumber == 1)
                        thread.service = Executors.newSingleThreadExecutor(); //异步
                    else
                        thread.service = Executors.newFixedThreadPool(threadNumber); //手写一个线程池，留坑
                }
            }
        }
        return thread;

    }

    public void submit(Runnable task){
        thread.service.submit(task);
    }

    private long test(){
        //有坑，标记
        if (service != null)
            return service.hashCode();
        else return 0;
    }
}
