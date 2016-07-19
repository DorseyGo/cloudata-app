/*
 * File name: QuestionGeneratorFactory
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

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
        generators.put("l", new SingleChoiceQuestionGenerator());
        generators.put("L", new SingleChoiceQuestionGenerator());
        generators.put("m", new MultipleChoiceQuestionGenerator());
        generators.put("M", new MultipleChoiceQuestionGenerator());
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

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - generator = " + generator);
        }

        return generator;
    }
}
