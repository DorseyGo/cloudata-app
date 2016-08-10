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

import java.util.Random;

/**
 * Author: DORSEy
 */
public final class StringUtils {
    public static final String base64Encode(final String src) {
        if (src == null)
            throw new IllegalArgumentException("Source string \'" + src + "\' should not be null");

        return (new BASE64Encoder()).encode(src.getBytes());
    }

    /**
     * A helper method to generate a randomized string with length specified.
     *
     * @param length the length of string to be generated.
     * @return a string with length specified.
     */
    public static final String randomized(final int length) {
        if (length <= 0)
            throw new IllegalArgumentException("Length \'" + length + "\' should be greater than zero");

        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        int pos = 0;
        while (pos < length) {
            switch ((pos++ % 3)) {
                case 0:
                    builder.append(random.nextInt(9));
                    break;
                case 1:
                    builder.append(String.valueOf((char) ('a' + random.nextInt(26))));
                    break;
                case 2:
                    builder.append(String.valueOf((char) ('A' + random.nextInt(26))));
                    break;
                default:
                    break;
            }
        }

        return builder.toString();
    }

    /**
     * Returns true if and only if the source string <code>src</code> is not blank, otherwise false. <strong> Note that,
     * the string is not blank means neither it's null nor empty. </strong>
     *
     * @param src the string to be tested.
     * @return true if and only if it's not null and not an empty string, otherwise false.
     */
    public static boolean isNotBlank(final String src) {
        if (src == null || "".equals(src.trim()))
            return false;

        return true;
    }
}
