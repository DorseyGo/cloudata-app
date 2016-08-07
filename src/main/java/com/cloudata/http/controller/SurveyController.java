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
import com.cloudata.http.callback.impl.*;
import com.cloudata.http.core.SurveyTemplate;
import com.cloudata.http.exception.RequestParamNotFoundException;
import com.cloudata.http.exception.ServiceException;
import com.cloudata.http.utils.ServletUtils;
import com.cloudata.http.view.*;
import com.cloudata.utils.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${DEFAULT_LANGUAGE}")
    private String language;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/survey", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String addSurvey(final HttpServletRequest request) {
        final String METHOD = "addSurvey(HttpServletRequest)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - request = " + request);
        }

        AddSurveyRespView view = null;
        try {
            String surveyName = ServletUtils.getStringParam(request, CloudataConstants.REQ_ATTR_SURVEY_TITLE);
            view = surveyTemplate.execute(new AddSurveyCallback(surveyName, language));
        } catch (RequestParamNotFoundException | ServiceException e) {
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + e.getMessage());
            }

            view = new AddSurveyRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String getSurvey(@PathVariable("surveyId") final int surveyId) {
        final String METHOD = "getSurvey(int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId);
        }

        GetSurveyRespView view = null;
        try {
            view = surveyTemplate.execute(new GetSurveyCallback(surveyId));
        } catch (ServiceException e) {
            view = new GetSurveyRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{currentPage}/{pageSize}", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String getSurveys(@PathVariable("currentPage") final int currentPage, @PathVariable("pageSize") final int pageSize) {
        final String METHOD = "getSurveys()";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY");
        }

        GetSurveysRespView view = null;
        try {
            view = surveyTemplate.execute(new GetSurveysCallback(currentPage, pageSize));
        } catch (ServiceException e) {
            view = new GetSurveysRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
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
            view = new BooleanRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
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
    public String getQuestions(@PathVariable("surveyId") final int surveyId) {
        final String METHOD = "getQuestions(int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId);
        }

        GetQuestionsRespView view = null;
        try {
            view = surveyTemplate.execute(new GetQuestionsCallback(surveyId));
        } catch (ServiceException e) {
            view = new GetQuestionsRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void updateQuestion(@PathVariable("surveyId") final int surveyId, @PathVariable("questionId") final int questionId, final HttpServletRequest request) {

    }
}
