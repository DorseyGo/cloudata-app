/*
 * File name: RespView
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import java.io.Serializable;

/**
 * An interface, which declares that its subclasses are responded views.
 * <p>
 * Author: DORSEy
 */
public interface RespView extends Serializable {

    /**
     * Returns the status code, which indicates whether the server is working properly.
     *
     * @return the status code.
     */
    int getStatus();

    /**
     * Returns the code, which indicates why the request is proceed failed.
     *
     * @return the code.
     */
    int getCode();

    /**
     * Returns the error message, which indicates why it failed.
     *
     * @return the error message.
     */
    String getErrorMessage();
}
