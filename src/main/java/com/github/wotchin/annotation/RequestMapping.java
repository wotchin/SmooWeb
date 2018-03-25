package com.github.wotchin.annotation;
import com.github.wotchin.request.RequestMethod;
import com.sun.istack.internal.Nullable;

import java.lang.annotation.*;

/**
 * RequestMapping Annotation.
 * @author wotchin
 * as the same name as Spring framework.
 * can be used for Request router.
 * */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented


public @interface RequestMapping {
    String value();
    @Nullable RequestMethod method() default RequestMethod.GET;
}

