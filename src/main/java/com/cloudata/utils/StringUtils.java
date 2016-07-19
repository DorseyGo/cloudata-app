/*
 * File name: StringUtils
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.utils;

import sun.misc.BASE64Encoder;

/**
 * Author: DORSEy
 */
public final class StringUtils {
    public static final String base64Encode(final String src) {
        if (src == null)
            throw new IllegalArgumentException("Source string \'" + src + "\' should not be null");

        return (new BASE64Encoder()).encode(src.getBytes());
    }
}
