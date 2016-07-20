/*
 * File name: ListSurveysResponse
 * Author: Dorsey Q F TANG
 * Date: 7/20/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command {@link ConConstants#CMD_LIST_SURVEYS} is executed on the server side.
 * <p>
 * Author: DORSEy
 */
public class ListSurveysResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_SURVEY_ID)
    private int surveyId;

    @SerializedName(ConConstants.SERIALIZED_SURVEY_LIST_TITLE)
    private String surveyTitle;

    @SerializedName(ConConstants.SERIALIZED_START_DATE)
    private String startDate;

    @SerializedName(ConConstants.SERIALIZED_EXPIRES)
    private String expires;

    @SerializedName(ConConstants.SERIALIZED_ACTIVE)
    private String active;

    /**
     * Empty constructor of {@link ListSurveysResponse}.
     */
    public ListSurveysResponse() {
        // empty constructor
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(final String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(final String expires) {
        this.expires = expires;
    }

    public String getActive() {
        return active;
    }

    public void setActive(final String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "surveyId: " + getSurveyId() + ", surveyTitle: " + getSurveyTitle() + ", startDate: " + getStartDate() +
                ", expires: " + getExpires() + ", active: " + getActive();
    }
}
