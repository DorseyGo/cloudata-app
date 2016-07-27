/*
 * File name: AbstractQuestionGenerator
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.importor;

import com.cloudata.connector.importor.structs.Question;
import com.cloudata.utils.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * An abstract implementation of {@link QuestionGenerator}, which provides common implementations.
 * <p>
 * Author: DORSEy
 */
abstract class AbstractQuestionGenerator implements QuestionGenerator {

    /**
     * The class name.
     */
    private static final String CNAME = AbstractQuestionGenerator.class.getName();

    /**
     * The logger to log down DEBUG level log message.
     */
    private static final Log DEBUGGER = LogFactory.getLog(CNAME + ".DEBUGGER");

    /**
     * The logger to log down ERROR level log message.
     */
    private static final Log ERROR = LogFactory.getLog(CNAME + ".ERROR");

    /**
     * The path where to find the template.
     */
    protected String templatePath;

    /**
     * The template name.
     */
    protected String templateName;

    /**
     * The root for iterate over the data.
     */
    private static final String DOC_ROOT = "question";

    @Override
    public String generate(final Question question) throws IOException {
        final String METHOD = "generate(Question)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - question = " + question);
        }

        Configuration config = new Configuration(Configuration.VERSION_2_3_24);
        config.setClassForTemplateLoading(this.getClass(), templatePath);

        String out = null;
        StringWriter writer = null;
        Map<String, Question> dataModel = new HashMap<>(1);
        try {
            dataModel.put(DOC_ROOT, question);
            Template template = config.getTemplate(templateName);

            writer = new StringWriter();
            template.process(dataModel, writer);
            out = writer.toString();
        } catch (TemplateException e) {
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - errors detected during processing the template using template: " + templateName);
            }

            throw new IOException(e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - out = " + out);
        }

        return StringUtils.base64Encode(out);
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(final String newTemplatePath) {
        this.templatePath = newTemplatePath;
    }

    public void setTemplateName(final String newTemplateName) {
        this.templateName = newTemplateName;
    }
}
