/*
 * File name: MatrixYesUncertainNoQuestionGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/27/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

/**
 * The generator which is used to generate matrix for yes, uncertain, no kind question.
 * <p>
 * Author: DORSEy
 */
public class MatrixYesUncertainNoQuestionGenerator extends AbstractQuestionGenerator {
    private static final String DEFAULT_TEMPLATE_PATH = "/templates";
    private static final String DEFAULT_TEMPLATE_NAME = "matrix_yes_uncertain_no_question.ftl";

    /**
     * Empty constructor of {@link MatrixYesUncertainNoQuestionGenerator}.
     */
    public MatrixYesUncertainNoQuestionGenerator() {
        this(DEFAULT_TEMPLATE_PATH, DEFAULT_TEMPLATE_NAME);
    }

    /**
     * Constructor of {@link MatrixYesUncertainNoQuestionGenerator}, with template path and name specified.
     *
     * @param templatePath the template path.
     * @param templateName the template name.
     */
    public MatrixYesUncertainNoQuestionGenerator(final String templatePath, final String templateName) {
        super();
        setTemplatePath(templatePath);
        setTemplateName(templateName);
    }
}
