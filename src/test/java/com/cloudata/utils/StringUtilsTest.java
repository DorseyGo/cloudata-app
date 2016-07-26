/*
 * File name: StringUtilsTest
 * Author: Dorsey Q F TANG
 * Date: 7/26/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * A test for {@link StringUtils}.
 *
 * Author: DORSEy
 */
public class StringUtilsTest {
    @Test
    public void testRandomized() {
        final int LENGTH = 3;
        String result = StringUtils.randomized(LENGTH);

        Assert.assertNotNull(result);
        Assert.assertTrue((result.length() == LENGTH));
        System.out.println(result);
    }
}
