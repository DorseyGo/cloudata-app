/*
 * File name: InsufficientReqParamException
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.exception;

/**
 * Author: DORSEy
 */
public class InsufficientReqParamException extends Exception {
    public InsufficientReqParamException() {
        // empty constructor
    }

    public InsufficientReqParamException(final String message) {
        super(message);
    }

    public InsufficientReqParamException(final Throwable cause) {
        super(cause);
    }

    public InsufficientReqParamException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
