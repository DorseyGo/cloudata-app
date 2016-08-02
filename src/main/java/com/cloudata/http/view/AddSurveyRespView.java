/*
 * File name: AddSurveyRespView
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The response view for adding survey request.
 * <p>
 * Author: DORSEy
 */
public class AddSurveyRespView implements RespBodyView {

    /**
     * The survey ID.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_SURVEY_ID)
    private int surveyId;

    /**
     * The group ID.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_GROUP_ID)
    private int groupId;

    /**
     * Empty constructor of {@link AddSurveyRespView}.
     */
    public AddSurveyRespView() {
        this(-1, -1);
    }

    /**
     * Constructor of {@link AddSurveyRespView}, with survey ID and group ID specified.
     *
     * @param surveyId the survey ID.
     * @param groupId  the group ID.
     */
    public AddSurveyRespView(final int surveyId, final int groupId) {
        setSurveyId(surveyId);
        setGroupId(groupId);
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(final int surveyId) {
        this.surveyId = surveyId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "surveyId: " + getSurveyId() + ", groupId: " + getGroupId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof AddSurveyRespView))
            return false;

        AddSurveyRespView that = (AddSurveyRespView) obj;
        boolean isEqualed = (surveyId == that.surveyId);
        isEqualed = isEqualed && (groupId == that.groupId);

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (surveyId);
        hashcode += PRIME + (groupId);

        return hashcode;
    }
}
