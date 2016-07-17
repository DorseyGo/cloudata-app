/*
 * File name: DeleteSurveyResponse
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
 * The response generated when command {@link ConConstants#CMD_DELETE_SURVEY} is executed on the server side.
 * <p>
 *
 * @see com.cloudata.connector.request.DeleteSurveyReqParams
 * @see com.cloudata.connector.request.ActivateSurveyReqParams
 *
 * Author: DORSEy
 */
public class BooleanStatusResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_STATUS)
    private String status;

    /**
     * Empty constructor of {@link BooleanStatusResponse}.
     */
    public BooleanStatusResponse() {
        // empty constructor
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "status: " + status;
    }
}
