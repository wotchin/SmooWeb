package com.github.wotchin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface ResponseBody {
    public enum BodyType{TEXT,JSON}
    public BodyType value() default BodyType.TEXT;
}
