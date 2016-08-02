/*
 * File name: SurveyController
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.controller;

import com.cloudata.CloudataConstants;
import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.exception.InsufficientReqParamException;
import com.cloudata.http.service.SurveyManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * The restful controller, which provides manipulation to surveys.
 * <p>
 * Author: DORSEy
 */
@RestController
@RequestMapping("/api")
public class SurveyController {

    /**
     * The class name.
     */
    private static final String CNAME = SurveyController.class.getName();

    /**
     * The log tracker to log down Debug level message.
     */
    private static final Log DEBUGGER = LogFactory.getLog("DEBUGGER." + CNAME);

    /**
     * The log tracker to log down Error level message.
     */
    private static final Log ERROR = LogFactory.getLog("ERROR." + CNAME);

    @Autowired
    private SurveyManager surveyManager;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/survey", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void addSurvey(final HttpServletRequest request) {
        final String METHOD = "addSurvey(HttpServletRequest)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - request = " + request);
        }

        String surveyName = null;
        try {
            surveyName = ServletRequestUtils.getStringParameter(request, CloudataConstants.REQ_ATTR_SURVEY_NAME);
        } catch (ServletRequestBindingException e) {
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - Failed to get parameter \'" + CloudataConstants.REQ_ATTR_SURVEY_NAME + "\' from request" + e);
            }
        }

        try {
            surveyManager.addSurvey((String) request.getSession().getAttribute("username"), surveyName);
        } catch (CommandExecutionException | InsufficientReqParamException e) {

        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/survey/{surveyId}", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void getSurvey(@PathVariable("surveyId") final int surveyId) {

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void getSurveys() {

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.DELETE, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void deleteSurvey(final int surveyId) {

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void updateSurvey(@PathVariable("surveyId") final int surveyId, final HttpServletRequest request) {

    }

    // ------------------------------------
    // question blocks
    // ------------------------------------

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void deleteQuestion(@PathVariable("surveyId") final int surveyId, @PathVariable("questionId") final int questionId) {

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/question", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void addQuestion(@PathVariable("surveyId") final int surveyId, final HttpServletRequest request) {

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void getQuestions(@PathVariable("surveyId") final int surveyId) {

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void updateQuestion(@PathVariable("surveyId") final int surveyId, @PathVariable("questionId") final int questionId, final HttpServletRequest request) {

    }
}
