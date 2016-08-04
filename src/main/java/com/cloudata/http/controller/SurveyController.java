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
import com.cloudata.http.callback.impl.DeleteSurveyCallback;
import com.cloudata.http.core.SurveyTemplate;
import com.cloudata.http.exception.ServiceException;
import com.cloudata.http.view.BooleanRespView;
import com.cloudata.utils.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private SurveyTemplate surveyTemplate;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/survey", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void addSurvey(final HttpServletRequest request) {
        final String METHOD = "addSurvey(HttpServletRequest)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - request = " + request);
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
    public String deleteSurvey(@PathVariable("surveyId") final int surveyId, final HttpServletRequest request) {
        final String METHOD = "deleteSurvey(int, HttpServletRequest)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId + ", request = " + request);
        }

        //request.getUserPrincipal();
        BooleanRespView view = null;
        try {
            view = surveyTemplate.execute(new DeleteSurveyCallback(surveyId));
        } catch (ServiceException e) {
            final String message = e.getMessage();
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new BooleanRespView(org.apache.http.HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
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
