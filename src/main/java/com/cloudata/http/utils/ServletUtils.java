/*
 * File name: ServletUtils
 * Author: Dorsey Q F TANG
 * Date: 8/7/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.utils;

import com.cloudata.http.exception.RequestParamNotFoundException;

import javax.servlet.ServletRequest;

/**
 * Author: DORSEy
 */
public final class ServletUtils {
    public static String getStringParam(final ServletRequest request, final String paramName) throws RequestParamNotFoundException {
        String retVal = getStringParam(request, paramName, null);
        if (retVal == null) {
            throw new RequestParamNotFoundException("Parameter '" + paramName + "' not found");
        }

        return retVal;
    }

    public static String getStringParam(final ServletRequest request, final String paramName, final String defaultVal) {
        String retVal = request.getParameter(paramName);
        if (retVal == null) {
            retVal = defaultVal;
        }

        return retVal;
    }
}
