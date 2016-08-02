/*
 * File name: View
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import java.io.Serializable;

/**
 * An interface, which declares that its subclasses are views.
 * <p>
 * Author: DORSEy
 */
public interface View extends Serializable {

    /**
     * Returns the status code, which indicates whether the request is proceed successfully. </p> Returns
     * <strong>1</strong> if it succeed, otherwise <strong>0</strong> if failed.
     *
     * @return the status code.
     */
    int getStatusCode();

    /**
     * Returns the reason phase, which indicates why the request is proceed failed.</p> Returns <tt>null</tt> if {@link
     * View#getStatusCode()} returns 1, otherwise a string representation.
     *
     * @return the reason phase.
     */
    String getReasonPhase();
}
