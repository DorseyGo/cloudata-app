/*
 * File name: ResultFilter
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.filter;

import com.cloudata.connector.exception.ResultProcessingException;

/**
 * Author: DORSEy
 */
public interface ResultFilter {

    /**
     * Tests whether the given <code>json</code> string is acceptable accordingly.
     * Returns <tt>true</tt> if and only if the given json is acceptable, otherwise an exception is thrown.
     *
     * @param json the json string to be tested.
     * @return true if and ony if the given json is acceptable, otherwise an exception is thrown.
     * @throws ResultProcessingException if the json string specified is not acceptable.
     */
    boolean accept(final String json) throws ResultProcessingException;
}
