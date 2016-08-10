/*
 * File name: Question
 * Author: Dorsey Q F TANG
 * Date: 8/10/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.structs;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: DORSEy
 */
public class Question implements Serializable {

    @Expose
    @SerializedName(CloudataConstants.REQ_ATTR_SURVEY_ID)
    private int surveyId;

    @Expose
    @SerializedName(CloudataConstants.REQ_ATTR_GROUP_ID)
    private int groupId;

    @Expose
    @SerializedName(CloudataConstants.REQ_ATTR_QUESTION)
    private String question;

    @Expose
    @SerializedName(CloudataConstants.REQ_ATTR_QUESTION_TYPE)
    private String type;

    @SerializedName(CloudataConstants.REQ_ATTR_MANDATORY)
    private String mandatory;

    @Expose
    @SerializedName(CloudataConstants.REQ_ATTR_ANSWERS)
    private List<Answer> answers;

    @Expose
    @SerializedName(CloudataConstants.REQ_ATTR_LANGUAGE)
    private String language;

    /**
     * Empty constructor of {@link Question}.
     */
    public Question() {
        // empty constructor
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(final String mandatory) {
        this.mandatory = mandatory;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(final List<Answer> answers) {
        this.answers = answers;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }
}
