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

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_SURVEY_ID)
    private int surveyId;

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
     * Constructor of {@link AddSurveyRespView}, with status, code, survey ID and group ID specified.
     *
     * @param status   the status.
     * @param code     the code.
     * @param surveyId the survey ID.
     * @param groupId  the group ID.
     */
    public AddSurveyRespView(final int status, final int code, final int surveyId, final int groupId) {
        this(status, code);
        setSurveyId(surveyId);
        setGroupId(groupId);
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
        int hashcode = PRIME + (surveyId);
        hashcode += PRIME + (groupId);

        return (hashcode + super.hashCode());
    }
}
