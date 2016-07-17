/*
 * File name: Serialized
 * Author: Dorsey Q F TANG
 * Date: 7/14/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation, which declares the name of field to be serialized into JSON string.
 *
 * Author: DORSEy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Serialize {

    /**
     * Return the name.
     *
     * @return the name.
     */
    String name() default "";
}
