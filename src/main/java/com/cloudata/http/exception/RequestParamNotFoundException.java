/*
 * File name: RequestParamNotFoundException
 * Author: Dorsey Q F TANG
 * Date: 8/7/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.exception;

/**
 * Author: DORSEy
 */
public class RequestParamNotFoundException extends Exception {
    public RequestParamNotFoundException() {
        super();
    }

    public RequestParamNotFoundException(final String message) {
        super(message);
    }
}
