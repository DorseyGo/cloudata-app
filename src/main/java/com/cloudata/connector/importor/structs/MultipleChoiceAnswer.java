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

    /**
     * Empty constructor of {@link MultipleChoiceAnswer}.
     */
    public MultipleChoiceAnswer() {
        // empty constructor
    }

    public String getAnswerType() {
        return answerType;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + getAnswerType();
    }
}
