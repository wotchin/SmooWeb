package com.github.wotchin;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface Router {
    String  value();
//    boolean websocket();
}
