package com.github.wotchin;

public class Session {
    private static Session ourInstance = new Session();

    public static Session getOrCreate() {
        return ourInstance;
    }

    private Session() {
    }
}
