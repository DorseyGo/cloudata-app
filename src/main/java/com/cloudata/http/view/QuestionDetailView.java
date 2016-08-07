/*
 * File name: QuestionDetailView
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public class QuestionDetailView implements Serializable {

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_QUESTION_ID)
    private int questionId;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_SURVEY_ID)
    private int surveyId;

    private int groupId;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_TYPE)
    private String type;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_QUESTION)
    private String question;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_MANDATORY)
    private String mandatory;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_QUESTION_ORDER)
    private int questionOrder;

    /**
     * Empty constructor of {@link QuestionDetailView}.
     */
    public QuestionDetailView() {
        // empty constructor.
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
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

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(final String mandatory) {
        this.mandatory = mandatory;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(final int questionOrder) {
        this.questionOrder = questionOrder;
    }
}
