/*
 * File name: AnswerVO
 * Author: Dorsey Q F TANG
 * Date: 8/8/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.bean;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public class AnswerVO implements Serializable {
    /**
     * The question ID.
     */
    private int questionId;

    /**
     * The answer.
     */
    private String answer;

    /**
     * The order.
     */
    private int order;

    /**
     * Empty constructor of {@link AnswerVO}.
     */
    public AnswerVO() {
        this(-1, null, 0);
    }

    /**
     * Constructor of {@link AnswerVO}, with question ID and answer specified.
     *
     * @param questionId the question ID.
     * @param answer     the answer.
     */
    public AnswerVO(final int questionId, final String answer, final int order) {
        setQuestionId(questionId);
        setAnswer(answer);
        setOrder(order);
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(final int order) {
        this.order = order;
    }
}
