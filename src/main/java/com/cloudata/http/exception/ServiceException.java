/*
 * File name: ServiceException
 * Author: Dorsey Q F TANG
 * Date: 8/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.exception;

/**
 * Author: DORSEy
 */
public class ServiceException extends Exception {
    /**
     * Empty constructor of {@link ServiceException}.
     */
    public ServiceException() {
        super();
    }

    /**
     * Constructor of {@link ServiceException}, with message specified.
     *
     * @param message the message.
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Constructor of {@link ServiceException}, with message and cause specified.
     *
     * @param message the message.
     * @param cause   the cause.
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
