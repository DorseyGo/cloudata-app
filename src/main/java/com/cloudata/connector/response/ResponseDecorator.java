/*
 * File name: ResponseDecorator
 * Author: Dorsey Q F TANG
 * Date: 7/20/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author: DORSEy
 */
public class ResponseDecorator<T extends Resp> implements Resp {

    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private List<T> retResponse;

    /**
     * Empty constructor of {@link ResponseDecorator}.
     */
    public ResponseDecorator() {
        // empty constructor.
    }

    public List<T> getRetResponse() {
        return retResponse;
    }

    public void setRetResponse(final List<T> retResponse) {
        this.retResponse = retResponse;
    }

    @Override
    public String toString() {
        return "retResponse: " + getRetResponse();
    }
}
