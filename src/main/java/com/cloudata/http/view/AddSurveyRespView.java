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
public class AddSurveyRespView extends AbstractRespView {

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
        super();
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
        return super.toString() + ", surveyId: " + getSurveyId() + ", groupId: " + getGroupId();
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
        isEqualed = isEqualed && (surveyId == that.surveyId);
        isEqualed = isEqualed && (groupId == that.groupId);

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + surveyId;
        hashcode += PRIME + groupId;

        return (super.hashCode() + hashcode);
    }
}
