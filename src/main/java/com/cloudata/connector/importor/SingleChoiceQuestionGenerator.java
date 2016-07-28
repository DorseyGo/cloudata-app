/*
 * File name: SingleChoiceQuestionGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

/**
 * An implementation to generate data of single choice question.
 * <p>
 * Author: DORSEy
 */
public class SingleChoiceQuestionGenerator extends AbstractQuestionGenerator {
    private static final String DEFAULT_TEMPLATE_PATH = "/templates";
    private static final String DEFAULT_TEMPLATE_NAME = "single_choice_question.ftl";

    /**
     * Empty constructor of {@link SingleChoiceQuestionGenerator}.
     */
    public SingleChoiceQuestionGenerator() {
        this(DEFAULT_TEMPLATE_PATH, DEFAULT_TEMPLATE_NAME);
    }

    /**
     * Constructor of {@link SingleChoiceQuestionGenerator}, with template path and name specified.
     *
     * @param templatePath the template path.
     * @param templateName the template name.
     */
    public SingleChoiceQuestionGenerator(final String templatePath, final String templateName) {
        super();
        setTemplatePath(templatePath);
        setTemplateName(templateName);
    }
}
