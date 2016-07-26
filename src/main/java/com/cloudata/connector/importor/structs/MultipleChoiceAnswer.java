/*
 * File name: MultipleChoiceAnswer
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor.structs;

/**
 * Author: DORSEy
 */
public class MultipleChoiceAnswer extends Answer {
    private final String answerType = "T";

    private static int count = 0;

    /**
     * Empty constructor of {@link MultipleChoiceAnswer}.
     */
    public MultipleChoiceAnswer() {
        // empty constructor
        this(null, null);
    }

    public MultipleChoiceAnswer(final String answer, final String code) {
        super(answer, code);
        setQuestionId((++count));
    }

    public String getAnswerType() {
        return answerType;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + getAnswerType();
    }
}
