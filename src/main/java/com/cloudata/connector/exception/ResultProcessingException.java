/*
 * File name: ResultProcessingException
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.exception;

/**
 * Author: DORSEy
 */
public class ResultProcessingException extends CommandExecutionException {

    /**
     * Default constructor of {@link ResultProcessingException}.
     */
    public ResultProcessingException() {
        super();
    }

    /**
     * Constructor of {@link ResultProcessingException}, with error message specified.
     *
     * @param message the error message.
     */
    public ResultProcessingException(final String message) {
        super(message);
    }
}
