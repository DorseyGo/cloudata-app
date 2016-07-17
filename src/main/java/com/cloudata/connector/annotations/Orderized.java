/*
 * File name: Orderized
 * Author: Dorsey Q F TANG
 * Date: 7/15/16
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
 * An annotation, which declares the order of the fields to be serialized into.
 *
 * Author: DORSEy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Orderized {
    /**
     * Returned the ordered serialized names.
     *
     * @return
     */
    String[] order() default {};
}
