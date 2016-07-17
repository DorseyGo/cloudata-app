/*
 * File name: BooleanResponse
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response, the kind that only string <tt>OK</tt>, is generated. Kinds of request that will this kind of response
 * will be generated.
 *
 * @see com.cloudata.connector.request.ReleaseSessionKeyReqParams
 * <p>
 * Author: DORSEy
 */
public class BooleanResultResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private String result;

    /**
     * Empty constructor of {@link BooleanResultResponse}.
     */
    public BooleanResultResponse() {
        // empty constructor.
    }

    public String getResult() {
        return result;
    }

    public void setResult(final String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "result: " + getResult();
    }
}
