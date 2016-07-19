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
     * Empty constructor of {@link SingleChoiceQuestionGenerator}, with template path and name being set as default.
     */
    public SingleChoiceQuestionGenerator() {
        setTemplatePath(DEFAULT_TEMPLATE_PATH);
        setTemplateName(DEFAULT_TEMPLATE_NAME);
    }

    public void setTemplatePath(final String newTemplatePath) {
        this.templatePath = newTemplatePath;
    }

    public void setTemplateName(final String newTemplateName) {
        this.templateName = newTemplateName;
    }
}
