/*
 * File name: DeleteSurveyRespView
 * Author: Dorsey Q F TANG
 * Date: 8/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.connector.request.DeleteSurveyReqParams;

/**
 * Author: DORSEy
 */
public class BooleanRespView extends AbstractRespView {
    /**
     * Empty constructor of {@link BooleanRespView}.
     */
    public BooleanRespView() {
        super();
    }

    /**
     * Constructor of {@link BooleanRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    public BooleanRespView(final int status, final int code, final String errorMessage) {
        super(status, code, errorMessage);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof DeleteSurveyReqParams))
            return false;

        BooleanRespView that = (BooleanRespView) obj;
        boolean isEqualed = (status == that.status);
        isEqualed = isEqualed && (code == that.code);
        isEqualed = isEqualed && (errorMessage == null ? that.errorMessage == null : errorMessage.equals(that.errorMessage));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
