package com.github.wotchin;

public class Session {
    private static Session ourInstance = new Session();

    public static Session getOrCreate() {
        return ourInstance;
    }

    private Session() {
        //Session 是一个带有超时功能的 WeakHashMap
    }
}
