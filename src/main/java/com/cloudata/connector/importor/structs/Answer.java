/*
 * File name: Answer
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor.structs;

import java.io.Serializable;

/**
 * An interface, which declares that all its subclasses is an answer to some question.
 * <p>
 * Author: DORSEy
 */
public interface Answer extends Serializable {

    /**
     * Returns the question ID, this answer belongs to.
     *
     * @return the question id.
     */
    int getQuestionId();

    /**
     * Returns <tt>true</tt> if this answer is chosen by default, otherwise <tt>false</tt>.
     *
     * @return true if this answer is chosen by default, otherwise false.
     */
    boolean isDefault();

    /**
     * Returns the answer body.
     *
     * @return the answer.
     */
    String getAnswer();
}
