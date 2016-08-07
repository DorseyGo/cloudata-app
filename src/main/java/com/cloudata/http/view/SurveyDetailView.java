/*
 * File name: SurveyDetailView
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public class SurveyDetailView implements Serializable {

    /**
     * The survey ID.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_SURVEY_ID)
    private int surveyId;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_SURVEY_TITLE)
    private String surveyTitle;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_START_DATE)
    private String startDate;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_EXPIRES)
    private String expired;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_ACTIVE)
    private String active;

    /**
     * Empty constructor of {@link SurveyDetailView}.
     */
    public SurveyDetailView() {
        // empty constructor
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(final int surveyId) {
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

    public String getExpired() {
        return expired;
    }

    public void setExpired(final String expired) {
        this.expired = expired;
    }

    public String getActive() {
        return active;
    }

    public void setActive(final String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "surveyId: " + getSurveyId() + ", surveyTitle: " + getSurveyTitle() + ", startDate: " + getStartDate()
                + ", expired: " + getExpired() + ", active: " + getActive();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof SurveyDetailView))
            return false;

        SurveyDetailView that = (SurveyDetailView) obj;
        boolean isEqualed = (surveyId == that.surveyId);
        isEqualed = isEqualed && (surveyTitle == null ? that.surveyTitle == null : surveyTitle.equals(that.surveyTitle));
        isEqualed = isEqualed && (startDate == null ? that.startDate == null : startDate.equals(that.startDate));
        isEqualed = isEqualed && (expired == null ? that.expired == null : expired.equals(that.expired));
        isEqualed = isEqualed && (active == null ? that.active == null : active.equals(that.active));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (surveyId);
        hashcode += PRIME + (surveyTitle == null || surveyTitle.isEmpty() ? 0 : surveyTitle.hashCode());
        hashcode += PRIME + (startDate == null || startDate.isEmpty() ? 0 : startDate.hashCode());
        hashcode += PRIME + (expired == null || expired.isEmpty() ? 0 : expired.hashCode());
        hashcode += PRIME + (active == null || active.isEmpty() ? 0 : active.hashCode());

        return hashcode;
    }
}
