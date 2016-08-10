/*
 * File name: AddQuestionRespView
 * Author: Dorsey Q F TANG
 * Date: 8/10/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Author: DORSEy
 */
public class AddQuestionRespView extends AbstractRespView {
    /**
     * The question ID.
     */
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_QUESTION_ID)
    private int questionId;

    /**
     * Empty constructor of {@link AddQuestionRespView}.
     */
    public AddQuestionRespView() {
        this(-1, -1);
    }

    /**
     * Constructor of {@link AddQuestionRespView}, with status and code specified.
     *
     * @param status the status.
     * @param code   the code.
     */
    public AddQuestionRespView(final int status, final int code) {
        this(status, code, null);
    }

    /**
     * Constructor of {@link AddQuestionRespView}, with status, code and question ID specified.
     *
     * @param status     the status.
     * @param code       the code.
     * @param questionId the question.
     */
    public AddQuestionRespView(final int status, final int code, final int questionId) {
        this(status, code);
        setQuestionId(questionId);
    }

    /**
     * Constructor of {@link AddQuestionRespView}, with status, code and message specified.
     *
     * @param status  the status.
     * @param code    the code.
     * @param message the message.
     */
    public AddQuestionRespView(final int status, final int code, final String message) {
        super(status, code, message);
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }
}
