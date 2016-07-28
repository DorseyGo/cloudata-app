/*
 * File name: QuestionGeneratorFactory
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

import com.cloudata.connector.structs.QuestionType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory class, which is used to produce sort of required question generator.
 * <p>
 * Author: DORSEy
 */
public class QuestionGeneratorFactory {
    /**
     * The class name.
     */
    private static final String CNAME = QuestionGeneratorFactory.class.getName();

    /**
     * The logger to log down DEBUG level log message.
     */
    private static final Log DEBUGGER = LogFactory.getLog(CNAME + ".DEBUGGER");

    /**
     * The singleton instance.
     */
    private static QuestionGeneratorFactory factory = null;

    /**
     * The generators being associated.
     */
    private static Map<String, QuestionGenerator> generators = new HashMap<>();

    static {
        generators.put(QuestionType.SINGLE_CHOICE.getValue(), new SingleChoiceQuestionGenerator());
        generators.put(QuestionType.MULTIPLE_CHOICES.getValue(), new MultipleChoiceQuestionGenerator());
        generators.put(QuestionType.FIVE_POINTS.getValue(), new FivePointsQuestionGenerator());
        generators.put(QuestionType.SINGLE_CHOICE_WITH_COMMENT.getValue(), new SingleChoiceWithCommentQuestionGenerator());
        generators.put(QuestionType.MATRIX_YES_UNCERTAIN_NO.getValue(), new MatrixYesUncertainNoQuestionGenerator());
        generators.put(QuestionType.MULTIPLE_CHOICES_WITH_COMMENT.getValue(), new MultipleChoicesWithCommentQuestionGenerator());
    }

    private QuestionGeneratorFactory() {
        // sole constructor.
    }

    /**
     * The sole entry point to return an instance of {@link QuestionGeneratorFactory}.
     *
     * @return an instance.
     */
    public static QuestionGeneratorFactory getFactory() {
        if (factory == null) {
            factory = new QuestionGeneratorFactory();
        }

        return factory;
    }

    public QuestionGenerator get(final String questionType) {
        final String METHOD = "get(String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - questionType = " + questionType);
        }

        QuestionGenerator generator = generators.get(questionType);
        if (generator == null)
            throw new IllegalArgumentException("No associated generator found according to the question type \'" + questionType + "\'");

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - generator = " + generator);
        }

        return generator;
    }
}
