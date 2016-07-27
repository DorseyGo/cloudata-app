/*
 * File name: FivePointsQuestionGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/27/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

/**
 * The generator used to generate 5 points question.
 * <p>
 * Author: DORSEy
 */
public class FivePointsQuestionGenerator extends AbstractQuestionGenerator {
    private static final String DEFAULT_TEMPLATE_NAME = "five_points_question.ftl";
    private static final String DEFAULT_TEMPLATE_PATH = "/templates";

    /**
     * Empty constructor of {@link FivePointsQuestionGenerator}.
     */
    public FivePointsQuestionGenerator() {
        this(DEFAULT_TEMPLATE_PATH, DEFAULT_TEMPLATE_NAME);
    }

    /**
     * Constructor of {@link FivePointsQuestionGenerator}, with template path and name specified.
     *
     * @param templatePath the template path.
     * @param templateName the template name.
     */
    public FivePointsQuestionGenerator(final String templatePath, final String templateName) {
        super();
        setTemplatePath(templatePath);
        setTemplateName(templateName);
    }
}
