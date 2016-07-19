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
     * Empty constructor of {@link MultipleChoiceQuestionGenerator}, with default template path and name being set.
     */
    public MultipleChoiceQuestionGenerator() {
        setTemplatePath(DEFAULT_TEMPLATE_PATH);
        setTemplateName(DEFAULT_TEMPLATE_NAME);
    }

    @Override
    public void setTemplatePath(String newTemplatePath) {
        this.templatePath = newTemplatePath;
    }

    @Override
    public void setTemplateName(String newTemplateName) {
        this.templateName = newTemplateName;
    }
}
