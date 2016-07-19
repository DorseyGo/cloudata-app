/*
 * File name: Question
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor.structs;

import java.io.Serializable;

/**
 * An interface which declares all its subclasses represent a question.
 * <p>
 * Author: DORSEy
 */
public interface Question extends Serializable {

    /**
     * Returns the survey ID this question created to.
     *
     * @return the survey ID.
     */
    int getSurveyId();

    /**
     * Returns the group ID this question created to.
     *
     * @return the group ID.
     */
    int groupId();

    /**
     * Returns the question type of this question.
     *
     * @return the question type.
     */
    String getQuestionType();
}
