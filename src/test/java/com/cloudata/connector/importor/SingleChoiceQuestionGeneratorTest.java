/*
 * File name: SingleChoiceQuestionGeneratorTest
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

import com.cloudata.connector.importor.structs.Answer;
import com.cloudata.connector.importor.structs.Question;
import com.cloudata.connector.structs.QuestionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * A test for {@link SingleChoiceQuestionGenerator}.
 *
 * Author: DORSEy
 */
public class SingleChoiceQuestionGeneratorTest {

    private SingleChoiceQuestionGenerator generator;

    @Before
    public void setUp() {
        generator = (SingleChoiceQuestionGenerator) QuestionGeneratorFactory.getFactory().get(QuestionType.SINGLE_CHOICE.getValue());
    }

    @Test
    public void testGenerate() {
        Question question = new Question(100, 100, "How are you?", QuestionType.SINGLE_CHOICE);
        question.setLanguage("en");
        question.setQuestionTitle("Hello");

        List<Answer> answers = new LinkedList<>();
        Answer answer = new Answer("good", "A01");
        answers.add(answer);

        answer = new Answer("not good", "A02");
        answers.add(answer);

        question.setAnswers(answers);

        String data = null;
        try {
            data = generator.generate(question);
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.assertFalse(true);
        }

        Assert.assertTrue(data != null);
    }
}
