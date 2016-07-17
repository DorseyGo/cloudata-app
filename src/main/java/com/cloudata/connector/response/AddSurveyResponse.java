/*
 * File name: AddSurveyResponse
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command {@link ConConstants#CMD_ADD_SURVEY} is executed on server side.
 * <p>
 * Author: DORSEy
 */
public class AddSurveyResponse implements Resp {

    /**
     * The survey ID created.
     */
    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private int surveyId;

    /**
     * Empty constructor of {@link AddSurveyResponse}.
     */
    public AddSurveyResponse() {
        // empty constructor
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(final int surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public String toString() {
        return "surveyID: " + getSurveyId();
    }
}
