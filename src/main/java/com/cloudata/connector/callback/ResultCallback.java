/*
 * File name: ResultCallback
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.callback;

import com.cloudata.connector.exception.ResultProcessingException;

/**
 * A callback interface, which is invoked when processing the result generated.
 * <p>
 * Author: DORSEy
 */
public interface ResultCallback<T> {

    T doWith(final String result) throws ResultProcessingException;
}
