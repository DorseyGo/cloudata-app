/*
 * File name: SurveyModel
 * Author: Dorsey Q F TANG
 * Date: 8/6/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.bean;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public class SurveyModel implements Serializable {

    /**
     * The survey ID.
     */
    private int surveyId;

    /**
     * The survey title.
     */
    private String surveyTitle;

    /**
     * The start date of this survey.
     */
    private String startDate;

    /**
     * The expiration date.
     */
    private String expires;

    /**
     * active status of survey.
     */
    private String active;

    /**
     * Empty constructor of {@link SurveyModel}.
     */
    public SurveyModel() {
        // empty constructor.
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

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof SurveyModel))
            return false;

        SurveyModel that = (SurveyModel) obj;
        boolean isEqualed = (surveyId == that.surveyId);
        isEqualed = isEqualed && (surveyTitle == null ? that.surveyTitle == null : surveyTitle.equals(that.surveyTitle));
        isEqualed = isEqualed && (startDate == null ? that.startDate == null : startDate.equals(that.startDate));
        isEqualed = isEqualed && (expires == null ? that.expires == null : expires.equals(that.expires));
        isEqualed = isEqualed && (active == null ? that.active == null : active.equals(that.active));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (surveyId);
        hashcode += PRIME + (surveyTitle == null || surveyTitle.isEmpty() ? 0 : surveyTitle.hashCode());
        hashcode += PRIME + (startDate == null || startDate.isEmpty() ? 0 : startDate.hashCode());
        hashcode += PRIME + (expires == null || expires.isEmpty() ? 0 : expires.hashCode());
        hashcode += PRIME + (active == null || active.isEmpty() ? 0 : active.hashCode());

        return hashcode;
    }
}
