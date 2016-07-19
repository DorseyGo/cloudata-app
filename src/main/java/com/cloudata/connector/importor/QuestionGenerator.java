/*
 * File name: QuestionImportedDataGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

import com.cloudata.connector.importor.structs.Question;

import java.io.IOException;

/**
 * An interface which declares all its subclasses are generator of questions.
 * <p>
 *
 * Author: DORSEy
 */
public interface QuestionGenerator {

    /**
     * Generate a 64-based encoded data according to the question specified.
     *
     * @param question the question.
     * @return a string representation of the question to be generated.
     * @throws IOException when I/O error detected during processing.
     */
    String generate(final Question question) throws IOException;
}
