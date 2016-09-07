/*
 * File name: GetSurveyRespView
 * Author: Dorsey Q F TANG
 * Date: 8/4/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The responded view of getting survey.
 * <p>
 * Author: DORSEy
 */
public class GetSurveyRespView extends AbstractRespView {
    /**
     * The survey properties.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_SURVEY)
    private SurveyDetailView survey;

    /**
     * Empty constructor of {@link GetSurveyRespView}.
     */
    public GetSurveyRespView() {
        super();
    }

    /**
     * Constructor of {@link GetSurveyRespView}, with status and code specified.
     *
     * @param status the status.
     * @param code   the code.
     */
    public GetSurveyRespView(final int status, final int code) {
        this(status, code, null);
    }

    /**
     * Constructor of {@link GetSurveyRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    public GetSurveyRespView(final int status, final int code, final String errorMessage) {
        super(status, code, errorMessage);
    }

    public SurveyDetailView getSurvey() {
        return survey;
    }

    public void setSurvey(final SurveyDetailView survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return super.toString() + ", survey: " + getSurvey();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof GetSurveyRespView))
            return false;

        GetSurveyRespView that = (GetSurveyRespView) obj;
        boolean isEqualed = (status == that.status);
        isEqualed = isEqualed && (code == that.code);
        isEqualed = isEqualed && (errorMessage == null ? that.errorMessage == null : errorMessage.equals(that.errorMessage));
        isEqualed = isEqualed && (survey == null ? that.survey == null : survey.equals(that.survey));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (survey == null ? 0 : survey.hashCode());

        return (super.hashCode() + hashcode);
    }

}
