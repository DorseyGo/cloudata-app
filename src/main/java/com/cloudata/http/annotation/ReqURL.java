/*
 * File name: ReqURL
 * Author: Dorsey Q F TANG
 * Date: 8/10/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation which is used to declare what it's requested url being like. It's a declarative annotation.
 * <p>
 * Author: DORSEy
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface ReqURL {
    String value();
}
