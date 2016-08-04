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

import java.util.Map;

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
    private Map<String, Object> survey;

    /**
     * Empty constructor of {@link GetSurveyRespView}.
     */
    public GetSurveyRespView() {
        super();
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

    public Map<String, Object> getSurvey() {
        return survey;
    }

    public void setSurvey(final Map<String, Object> survey) {
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
        int hashcode = PRIME + (survey == null || survey.isEmpty() ? 0 : survey.hashCode());

        return (super.hashCode() + hashcode);
    }
}
