/*
 * File name: GetSurveysRespView
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.cloudata.http.structs.Pagination;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Author: DORSEy
 */
public class GetSurveysRespView extends AbstractRespView {

    /**
     * The surveys.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_SURVEYS)
    private com.cloudata.http.structs.Pagination<SurveyDetailView> surveys;

    /**
     * Empty constructor of {@link GetSurveysRespView}.
     */
    public GetSurveysRespView() {
        // empty constructor.
        super();
    }

    public GetSurveysRespView(final int status, final int code) {
        this(status, code, null);
    }

    /**
     * Constructor of {@link GetSurveysRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    public GetSurveysRespView(final int status, final int code, final String errorMessage) {
        super(status, code, errorMessage);
    }

    public Pagination<SurveyDetailView> getSurveys() {
        return surveys;
    }

    public void setSurveys(final Pagination<SurveyDetailView> surveys) {
        this.surveys = surveys;
    }

    @Override
    public String toString() {
        return super.toString() + ", surveys: " + getSurveys();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof GetSurveysRespView))
            return false;

        GetSurveysRespView that = (GetSurveysRespView) obj;
        boolean isEqualed = (status == that.status);
        isEqualed = isEqualed && (code == that.code);
        isEqualed = isEqualed && (errorMessage == null ? that.errorMessage == null : errorMessage.equals(that.errorMessage));
        isEqualed = isEqualed && (surveys == null ? that.surveys == null : surveys.equals(that.surveys));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (surveys == null ? 0 : surveys.hashCode());

        return (super.hashCode() + hashcode);
    }
}
