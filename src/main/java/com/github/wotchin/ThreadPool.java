package com.github.wotchin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    private static volatile ThreadPool thread = null;
    private ExecutorService service = null;
    private static int threadNumber = Runtime.getRuntime().availableProcessors();
    private ThreadPool() {}

    public static ThreadPool getInstance(){
        if (thread == null){
            synchronized (ThreadPool.class){
                if (thread == null){
                    thread = new ThreadPool();
                    if (threadNumber == 1)
                        thread.service = Executors.newSingleThreadExecutor(); //单一实例,适合CPU消耗型场景
                    else
                        thread.service = Executors.newFixedThreadPool(threadNumber); //手写一个线程池，留坑
                }
            }
        }
        return thread;
    }

    protected static ThreadPool getInstance(int threadNumber){
       return getInstance(threadNumber);
    };

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
