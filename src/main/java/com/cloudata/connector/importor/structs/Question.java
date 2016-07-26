/*
 * File name: Question
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor.structs;

import com.cloudata.connector.structs.QuestionType;
import com.cloudata.utils.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * A class which declares that the instance of such is a question.
 * <p>
 * Author: DORSEy
 */
public class Question implements Serializable {

    private static int count = 0;

    /**
     * The wished question ID.
     */
    private int questionId;

    /**
     * The parent of current question, 0 means no parents.
     */
    private int parentQuestionId = 0;

    /**
     * The survey ID.
     */
    private int surveyId;

    /**
     * The group ID.
     */
    private int groupId;

    /**
     * The type. Concrete question types, please refer to {@link com.cloudata.connector.structs.QuestionType}.
     */
    private String type;

    /**
     * The title of question.
     */
    private String questionTitle;

    /**
     * The question.
     */
    private String question;

    /**
     * indicates whether it is mandatory or not. "Y" for yes, "N" for no.
     */
    private String mandatory;

    /**
     * The language, determined when survey is created.
     */
    private String language;

    /**
     * The order of current question.
     */
    private int questionOrder = count++;

    /**
     * The answers belong to this question.
     */
    private List<Answer> answers;

    /**
     * Empty constructor of {@link Question}.
     */
    public Question() {
        // empty constructor.
    }

    /**
     * Constructor of {@link Question}, with survey Id, group Id, question and type specified.
     *
     * @param surveyId the survey ID.
     * @param groupId  the group Id.
     * @param question the question.
     * @param type     the type.
     */
    public Question(final int surveyId, final int groupId, final String question, final QuestionType type) {
        this(surveyId, groupId, question, type, null);
    }

    /**
     * Constructor of {@link Question}, with survey Id, group Id, question, type and answers specified.
     *
     * @param surveyId the survey ID.
     * @param groupId  the group Id.
     * @param question the question.
     * @param type     the type.
     * @param answers  the answers.
     */
    public Question(final int surveyId, final int groupId, final String question, final QuestionType type, final List<Answer> answers) {
        setSurveyId(surveyId);
        setGroupId(groupId);
        setQuestion(question);
        setType(type.getValue());
        setAnswers(answers);
        setMandatory("N");
        setQuestionTitle("Q" + StringUtils.randomized(3));
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }

    public int getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(final int parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
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

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(final String questionTitle) {
        this.questionTitle = questionTitle;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(final int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(final List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "surveyId: " + getSurveyId() + ", groupId: " + getGroupId() + ", question: " + getQuestion() + ", type: " + getType();
    }
}
