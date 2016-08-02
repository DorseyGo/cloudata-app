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
 * <p>
 * Author: DORSEy
 */
abstract class RespView implements Serializable {

    /**
     * The status code. 1 for success, 0 for failure.
     */
    protected final int statusCode;

    /**
     * The reason phase which indicates of why it failed.
     */
    protected String reasonPhase;

    /**
     * Constructor of {@link RespView}, with status code specified.
     *
     * @param statusCode the status code.
     */
    protected RespView(final int statusCode) {
        this(statusCode, null);
    }

    /**
     * Constructor of {@link RespView}, with status code and reason phase specified.
     *
     * @param statusCode  the status code.
     * @param reasonPhase the reason phase.
     */
    protected RespView(final int statusCode, final String reasonPhase) {
        this.statusCode = statusCode;
        setReasonPhase(reasonPhase);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhase() {
        return reasonPhase;
    }

    public void setReasonPhase(final String reasonPhase) {
        this.reasonPhase = reasonPhase;
    }

}
