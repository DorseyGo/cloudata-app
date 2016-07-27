/*
 * File name: SingleChoiceWithCommentQuestionGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/27/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

/**
 * The generator which is used to generate single choice question with comments.
 * <p>
 * Author: DORSEy
 */
public class SingleChoiceWithCommentQuestionGenerator extends AbstractQuestionGenerator {
    private static final String DEFAULT_TEMPLATE_PATH = "/templates";
    private static final String DEFAULT_TEMPLATE_NAME = "single_choice_with_comment_question.ftl";

    /**
     * Empty constructor of {@link SingleChoiceWithCommentQuestionGenerator}.
     */
    public SingleChoiceWithCommentQuestionGenerator() {
        this(DEFAULT_TEMPLATE_PATH, DEFAULT_TEMPLATE_NAME);
    }

    /**
     * Constructor of {@link SingleChoiceWithCommentQuestionGenerator}, with template path and name specified.
     *
     * @param templatePath the template path.
     * @param templateName the template name.
     */
    public SingleChoiceWithCommentQuestionGenerator(final String templatePath, final String templateName) {
        super();
        setTemplatePath(templatePath);
        setTemplateName(templateName);
    }
}
