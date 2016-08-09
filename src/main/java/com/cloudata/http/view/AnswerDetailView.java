/*
 * File name: AnswerDetailView
 * Author: Dorsey Q F TANG
 * Date: 8/8/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.cloudata.connector.annotations.Serialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public class AnswerDetailView implements Serializable {

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_ANSWER)
    private String answer;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_QUESTION_ID)
    private int questionId;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_ORDER)
    private int answerOrder;

    /**
     * Empty constructor of {@link AnswerDetailView}.
     */
    public AnswerDetailView() {
        this(null);
    }

    /**
     * Constructor of {@link AnswerDetailView}, with answer specified.
     *
     * @param answer the answer.
     */
    public AnswerDetailView(final String answer) {
        setAnswer(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerOrder() {
        return answerOrder;
    }

    public void setAnswerOrder(final int answerOrder) {
        this.answerOrder = answerOrder;
    }
}
