/*
 * File name: ImportQuestionResponse
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command {@link ConConstants#CMD_IMPORT_QUESTION} is executed on server side.
 * <p>
 * Author: DORSEy
 */
public class ImportQuestionResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private int questionId;

    /**
     * Empty constructor of {@link ImportQuestionResponse}.
     */
    public ImportQuestionResponse() {
        // empty constructor
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "questionId: " + getQuestionId();
    }
}
