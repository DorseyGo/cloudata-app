/*
 * File name: QuestionVO
 * Author: Dorsey Q F TANG
 * Date: 8/8/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author: DORSEy
 */
public class QuestionVO implements Serializable {
    /**
     * The question ID.
     */
    private int questionId;

    private String question;

    /**
     * The question type.
     */
    private String type;

    private int questionOrder;

    /**
     * Whether its mandatory or not, Y for yes, N for no.
     */
    private String mandatory;

    /**
     * The answers.
     */
    private List<AnswerVO> answerVOs;

    /**
     * Empty constructor of {@link QuestionVO}.
     */
    public QuestionVO() {
        // empty constructor.
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
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

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(final int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public List<AnswerVO> getAnswerVOs() {
        return answerVOs;
    }

    public void setAnswerVOs(final List<AnswerVO> answerVOs) {
        this.answerVOs = answerVOs;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(final String mandatory) {
        this.mandatory = mandatory;
    }
}
