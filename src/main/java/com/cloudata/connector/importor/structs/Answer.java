/*
 * File name: Answer
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor.structs;

import com.cloudata.utils.StringUtils;

import java.io.Serializable;

/**
 * An interface, which declares that all its subclasses is an answer to some question.
 * <p>
 * Author: DORSEy
 */
public class Answer implements Serializable {

    private static int count = 0;

    /**
     * The question ID.
     */
    private int questionId;

    /**
     * The answer.
     */
    private String answer;

    /**
     * The code/title.
     */
    private String code;

    /**
     * indicates whether it should be chosen by default.
     */
    private boolean isDefault;

    /**
     * The relevance.
     */
    private int relevance;

    /**
     * The ordering.
     */
    private int order = count++;

    /**
     * Empty constructor of {@link Answer}.
     */
    public Answer() {
        // empty constructor.
        this(null);
    }

    /**
     * Constructor of {@link Answer}, with answer specified and code being generated automatically.
     *
     * @param answer the answer.
     */
    public Answer(final String answer) {
        this(answer, null);
        setCode("A" + StringUtils.randomized(2));
    }

    /**
     * Constructor of {@link Answer}, with code/title and answer specified.
     *
     * @param answer the answer.
     * @param code   the code/title.
     */
    public Answer(final String answer, final String code) {
        setAnswer(answer);
        setCode(code);
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(final int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "code/title: " + getCode() + ", answer: " + getAnswer() + ", default: " + isDefault();
    }
}
