/*
 * File name: AbstractRespView
 * Author: Dorsey Q F TANG
 * Date: 8/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * An abstracted implementation of {@link RespView}.
 * <p>
 * Author: DORSEy
 */
abstract class AbstractRespView implements RespView {

    /**
     * The status.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_STATUS)
    protected int status;

    /**
     * The code.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_CODE)
    protected int code;

    /**
     * The error message.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_ERROR_MESSAGE)
    protected String errorMessage;

    /**
     * Empty constructor of {@link AbstractRespView}.
     */
    protected AbstractRespView() {
        this(-1, -1, null);
    }

    /**
     * Constructor of {@link AbstractRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    protected AbstractRespView(final int status, final int code, final String errorMessage) {
        setStatus(status);
        setCode(code);
        setErrorMessage(errorMessage);
    }

    @Override
    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "status: " + getStatus() + ", code: " + getCode() + ", errorMessage: " + getErrorMessage();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (status);
        hashcode += PRIME + (code);
        hashcode += PRIME + (errorMessage == null || errorMessage.isEmpty() ? 0 : errorMessage.hashCode());

        return hashcode;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof AbstractRespView))
            return false;

        AbstractRespView that = (AbstractRespView) obj;
        boolean isEqualed = (status == that.status);
        isEqualed = isEqualed && (code == that.code);
        isEqualed = isEqualed && (errorMessage == null ? that.errorMessage == null : errorMessage.equals(that.errorMessage));

        return isEqualed;
    }
}
