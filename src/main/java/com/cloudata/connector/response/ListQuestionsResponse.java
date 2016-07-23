/*
 * File name: ListQuestionsResponse
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command {@link ConConstants#CMD_LIST_QUESTIONS} is executed on server side.
 * <p>
 * Author: DORSEy
 */
public class ListQuestionsResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_QUESTION_ID)
    private int questionId;

    @SerializedName(ConConstants.SERIALIZED_SURVEY_ID)
    private int surveyId;

    @SerializedName(ConConstants.SERIALIZED_GROUP_ID)
    private int groupId;

    @SerializedName(ConConstants.SERIALIZED_TYPE)
    private String type;

    @SerializedName(ConConstants.SERIALIZED_TITLE)
    private String title;

    @SerializedName(ConConstants.SERIALIZED_QUESTION)
    private String question;

    @SerializedName(ConConstants.SERIALIZED_MANDATORY)
    private String mandatory;

    @SerializedName(ConConstants.SERIALIZED_QUESTION_ORDER)
    private int questionOrder;

    /**
     * Empty constructor of {@link ListQuestionsResponse}.
     */
    public ListQuestionsResponse() {
        // empty constructor
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

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "questionId: " + getQuestionId() + ", surveyId: " + getSurveyId() + ", groupId: " + getGroupId() +
                ", title: " + getTitle() + ", question: " + getQuestion() + ", mandatory: " + getMandatory()
                + ", questionOrder: " + getQuestionOrder();
    }
}
