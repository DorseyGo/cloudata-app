/*
 * File name: MultipleChoiceQuestionGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

/**
 * An implementation of generating data of multiple-choices question.
 * <p>
 * Author: DORSEy
 */
public class MultipleChoiceQuestionGenerator extends AbstractQuestionGenerator {

    private static final String DEFAULT_TEMPLATE_PATH = "/templates";
    private static final String DEFAULT_TEMPLATE_NAME = "multiple_choices_question.ftl";

    /**
     * Empty constructor of {@link MultipleChoiceQuestionGenerator}.
     */
    public MultipleChoiceQuestionGenerator() {
        this(DEFAULT_TEMPLATE_PATH, DEFAULT_TEMPLATE_NAME);
    }

    /**
     * Constructor of {@link MultipleChoiceQuestionGenerator}, with template path and name specified.
     *
     * @param templatePath the template path.
     * @param templateName the template name.
     */
    public MultipleChoiceQuestionGenerator(final String templatePath, final String templateName) {
        super();
        setTemplatePath(templatePath);
        setTemplateName(templateName);
    }

}
