/*
 * File name: NotNull
 * Author: Dorsey Q F TANG
 * Date: 7/18/16
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
 * Identify that the field it declares should not be null.
 *
 * Author: DORSEy
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface NotNull {
}
