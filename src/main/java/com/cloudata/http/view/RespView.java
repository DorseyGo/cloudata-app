/*
 * File name: RespView
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.cloudata.connector.annotations.Serialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Author: DORSEy
 */
public class RespView implements View {

    /**
     * The status code. 1 for success, 0 for failure.
     */
    @Expose
    @SerializedName(CloudataConstants.REQ_SERIALIZED_STATUS_CODE)
    private final int statusCode;

    /**
     * The reason phase which indicates of why it failed.
     */
    @Expose
    @SerializedName(CloudataConstants.REQ_SERIALIZED_REASON_PHASE)
    private String reasonPhase;

    /**
     * The body.
     */
    @Expose
    @SerializedName(CloudataConstants.REQ_SERIALIZED_BODY)
    private RespBodyView bodyView;

    /**
     * Constructor of {@link RespView}, with status code specified.
     *
     * @param statusCode the status code.
     */
    public RespView(final int statusCode) {
        this(statusCode, null);
    }

    /**
     * Constructor of {@link RespView}, with status code and reason phase specified.
     *
     * @param statusCode  the status code.
     * @param reasonPhase the reason phase.
     */
    public RespView(final int statusCode, final String reasonPhase) {
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

    public RespBodyView getBodyView() {
        return bodyView;
    }

    public void setBodyView(final RespBodyView bodyView) {
        this.bodyView = bodyView;
    }
}
