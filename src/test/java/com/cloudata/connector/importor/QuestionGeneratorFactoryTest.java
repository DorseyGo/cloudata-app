/*
 * File name: QuestionGeneratorFactoryTest
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

import com.cloudata.connector.structs.QuestionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A test for {@link QuestionGeneratorFactory}.
 *
 * Author: DORSEy
 */
public class QuestionGeneratorFactoryTest {
    private QuestionGeneratorFactory factory;

    @Before
    public void setUp() {
        factory = QuestionGeneratorFactory.getFactory();
    }

    @Test
    public void testGet() {
        QuestionGenerator generator = factory.get(QuestionType.SINGLE_CHOICE.getValue());
        Assert.assertTrue((generator instanceof SingleChoiceQuestionGenerator));
    }
}
