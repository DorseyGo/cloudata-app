/**
 * File name: ServletUtils Author: Dorsey Q F TANG Date: 7/3/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.app.utils;

import javax.servlet.ServletRequest;

/**
 * A utility class for manipulating {@link javax.servlet.ServletRequest}.
 *
 * Author: DORSEy
 */
public class ServletUtils {
    public static String getParam(final ServletRequest request, final String paramName) {
        return getParam(request, paramName, null);
    }

    public static String getParam(final ServletRequest request, final String paramName, final String defaultVal) {
        String paramVal = request.getParameter(paramName);
        if (paramVal == null) {
            return defaultVal;
        }

        return paramVal;
    }
}
