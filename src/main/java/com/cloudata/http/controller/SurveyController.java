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
import com.cloudata.http.annotation.ReqURL;
import com.cloudata.http.callback.impl.*;
import com.cloudata.http.core.SurveyTemplate;
import com.cloudata.http.exception.ServiceException;
import com.cloudata.http.view.*;
import com.cloudata.utils.JsonUtils;
import com.cloudata.utils.StringUtils;
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

    @ReqURL("curl -X POST -d 'surveyTitle=hello' http://$SERVER_ADDR:$PORT/cloudata-app/api/survey")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/survey", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String addSurvey(final String surveyTitle) {
        final String METHOD = "addSurvey(HttpServletRequest)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyTitle = " + surveyTitle);
        }

        AddSurveyRespView view = null;
        if (!StringUtils.isNotBlank(surveyTitle)) {
            final String message = "No survey title '" + surveyTitle + "' found";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new AddSurveyRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            try {
                view = surveyTemplate.execute(new AddSurveyCallback(surveyTitle, language));
            } catch (ServiceException e) {
                if (ERROR.isErrorEnabled()) {
                    ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + e.getMessage());
                }

                view = new AddSurveyRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ReqURL("curl -X GET http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys/12")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String getSurvey(@PathVariable("surveyId") final int surveyId) {
        final String METHOD = "getSurvey(int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId);
        }

        GetSurveyRespView view = null;
        if (surveyId <= 0) {
            final String message = "Survey ID '" + surveyId + "' should be greater than 0";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new GetSurveyRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            try {
                view = surveyTemplate.execute(new GetSurveyCallback(surveyId));
            } catch (ServiceException e) {
                view = new GetSurveyRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ReqURL("curl -X GET http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys/1/20")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{currentPage}/{pageSize}", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String getSurveys(@PathVariable("currentPage") final int currentPage, @PathVariable("pageSize") final int pageSize) {
        final String METHOD = "getSurveys()";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY");
        }

        GetSurveysRespView view = null;
        if (currentPage <= 0 || pageSize <= 0) {
            final String message = "Current page '" + currentPage + "' or page size '" + pageSize + "' should be greater than 0";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new GetSurveysRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            try {
                view = surveyTemplate.execute(new GetSurveysCallback(currentPage, pageSize));
            } catch (ServiceException e) {
                view = new GetSurveysRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ReqURL("curl -X DELETE http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys/12")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.DELETE, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String deleteSurvey(@PathVariable("surveyId") final int surveyId) {
        final String METHOD = "deleteSurvey(int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId);
        }

        BooleanRespView view = null;
        if (surveyId <= 0) {
            String message = "Survey Id '" + surveyId + "' should be greater than 0";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new BooleanRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            try {
                view = surveyTemplate.execute(new DeleteSurveyCallback(surveyId));
            } catch (ServiceException e) {
                view = new BooleanRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
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

    @ReqURL("curl -X DELETE http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys/12/questions/12")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String deleteQuestion(@PathVariable("surveyId") final int surveyId, @PathVariable("questionId") final int questionId) {
        final String METHOD = "deleteQuestion(int, int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId + ", questionId = " + questionId);
        }

        BooleanRespView respView = null;
        if (surveyId <= 0 || questionId <= 0) {
            final String message = "Survey ID '" + surveyId + "' or question ID '" + questionId + "' should be greater than 0";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            respView = new BooleanRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            try {
                respView = surveyTemplate.execute(new DeleteQuestionCallback(surveyId, questionId));
            } catch (ServiceException e) {
                respView = new BooleanRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String json = JsonUtils.toJson(respView);
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/question", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void addQuestion(@PathVariable("surveyId") final int surveyId, final HttpServletRequest request) {
        final String METHOD = "addQuestion(int, HttpServletRequest)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId + ", request = " + request);
        }


    }

    @ReqURL("curl -X GET http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys/12/questions")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String getQuestions(@PathVariable("surveyId") final int surveyId) {
        final String METHOD = "getQuestions(int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId);
        }

        GetQuestionsRespView view = null;
        if (surveyId <= 0) {
            final String message = "Survey ID '" + surveyId + "' should be greater than 0";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new GetQuestionsRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            try {
                view = surveyTemplate.execute(new GetQuestionsCallback(surveyId));
            } catch (ServiceException e) {
                view = new GetQuestionsRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String json = JsonUtils.toJson(view);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public void updateQuestion(@PathVariable("surveyId") final int surveyId, @PathVariable("questionId") final int questionId) {

    }
}
