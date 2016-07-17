/*
 * File name: CommandExecutionException
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.exception;

/**
 * A catchable exception that will be thrown when errors detected during execution of Http API calls.
 *
 * Author: DORSEy
 */
public class CommandExecutionException extends Exception {
    public CommandExecutionException() {
        super();
    }

    public CommandExecutionException(final String message) {
        super(message);
    }

    public CommandExecutionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CommandExecutionException(final Throwable cause) {
        super(cause);
    }
}
