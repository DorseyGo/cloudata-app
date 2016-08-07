/*
 * File name: AddSurveyRespView
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

/**
 * The response view for adding survey request.
 * <p>
 * Author: DORSEy
 */
public class AddSurveyRespView extends AbstractRespView {

    /**
     * Empty constructor of {@link AddSurveyRespView}.
     */
    public AddSurveyRespView() {
        super();
    }

    /**
     * Constructor of {@link AddSurveyRespView}, with status and code specified.
     *
     * @param status the status.
     * @param code   the code.
     */
    public AddSurveyRespView(final int status, final int code) {
        this(status, code, null);
    }

    /**
     * Constructor of {@link AddSurveyRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    public AddSurveyRespView(final int status, final int code, final String errorMessage) {
        super(status, code, errorMessage);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof AddSurveyRespView))
            return false;

        AddSurveyRespView that = (AddSurveyRespView) obj;
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
