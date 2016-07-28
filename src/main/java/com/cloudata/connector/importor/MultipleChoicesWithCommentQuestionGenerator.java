/*
 * File name: MultipleChoicesWithCommentQuestionGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/28/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

/**
 * The generator which is used to generate the multiple choices question with comments.
 * <p>
 * Author: DORSEy
 */
public class MultipleChoicesWithCommentQuestionGenerator extends AbstractQuestionGenerator {
    private static final String DEFAULT_TEMPLATE_PATH = "/templates";
    private static final String DEFAULT_TEMPLATE_NAME = "multiple_choices_with_comment_question.ftl";

    /**
     * Empty constructor of {@link MultipleChoicesWithCommentQuestionGenerator}.
     */
    public MultipleChoicesWithCommentQuestionGenerator() {
        this(DEFAULT_TEMPLATE_PATH, DEFAULT_TEMPLATE_NAME);
    }

    /**
     * Constructor of {@link MultipleChoicesWithCommentQuestionGenerator}, with template path and name specified.
     *
     * @param templatePath the template path.
     * @param templateName the template name.
     */
    public MultipleChoicesWithCommentQuestionGenerator(final String templatePath, final String templateName) {
        super();
        setTemplatePath(templatePath);
        setTemplateName(templateName);
    }
}
