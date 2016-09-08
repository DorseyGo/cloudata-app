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
import com.cloudata.http.structs.Question;
import com.cloudata.http.view.*;
import com.cloudata.utils.JsonUtils;
import com.cloudata.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @ReqURL("curl -X GET http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys?currentPage=1&pageSize=20")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String getSurveys(@RequestParam("currentPage") final int currentPage, @RequestParam("pageSize") final int pageSize) {
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
    @RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSurvey(@PathVariable("surveyId") final int surveyId, final HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    // ------------------------------------
    // group blocks
    // ------------------------------------
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/group", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addGroup(@PathVariable("surveyId") final int surveyId, @RequestParam("groupTitle") final String groupTitle) {
        final String METHOD = "addGroup(int, String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId + ", groupTitle = " + groupTitle);
        }

        String result = null;
        AddGroupRespView respView = null;
        if (surveyId <= 0 || groupTitle == null || groupTitle.trim().isEmpty()) {
            final String message = "surveyId [" + surveyId + "] should be greater than zero and groupTitle [" + groupTitle + "] should not be null or empty";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            respView = new AddGroupRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {

            try {
                respView = surveyTemplate.execute(new AddGroupCallback(surveyId, groupTitle));
            } catch (ServiceException e) {
                respView = new AddGroupRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        result = JsonUtils.toJson(respView);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - result = " + result);
        }

        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "surveys/{surveyId}/groups/{groupId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteGroup(@PathVariable("surveyId") final int surveyId, @PathVariable("groupId") final int groupId) {
        final String METHOD = "deleteGroup(int, int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId + ", groupId = " + groupId);
        }

        BooleanRespView respView = null;
        if (surveyId <= 0 || groupId <= 0) {
            final String message = "surveyId [" + surveyId + "] and groupId [" + groupId + "] should greater than zero";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            respView = new BooleanRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else  {
            try {
                respView = surveyTemplate.execute(new DeleteGroupCallback(surveyId, groupId));
            } catch (ServiceException e) {
                respView = new BooleanRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String result = JsonUtils.toJson(respView);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - result = " + result);
        }

        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/groups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGroups(@PathVariable("surveyId") final int surveyId, @RequestParam("currentPage") final int currentPage, @RequestParam("pageSize") final int pageSize) {
        final String METHOD = "getGroups(int, int, int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId + ", currentPage = " + currentPage + ", pageSize = " + pageSize);
        }

        ListGroupsRespView respView = null;
        if (surveyId <= 0 || currentPage <= 0 || pageSize <= 0) {
            final String message = "surveyId [" + surveyId + "], currentPage [" + currentPage + "] and pageSize [" + pageSize + "] should greater than zero";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            respView = new ListGroupsRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            // restrict that every page can show how many records.
            int localPageSize = (pageSize > CloudataConstants.PAGE_SIZE_THRESHOLD) ? CloudataConstants.PAGE_SIZE_THRESHOLD : pageSize;

            try {
                respView = surveyTemplate.execute(new ListGroupCallback(surveyId, currentPage, localPageSize));
            } catch (ServiceException e) {
                respView = new ListGroupsRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String result = JsonUtils.toJson(respView);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - result = " + result);
        }

        return result;
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

    /**
     * <strong>
     *     <ul>
     *         <li>
     *             The parameter question should be like this:
     *             {
     *                 "surveyId": 123,
     *                 "groupId": 123,
     *                 "question": "are u single?",
     *                 "type": "L/M/5/...",
     *                 "answers": [
     *                      {
     *                          "answer": "yes"
     *                      },
     *                      {
     *                          "answer": "no"
     *                      }
     *                 ]
     *             }
     *         </li>
     *     </ul>
     * </strong>
     *
     */
    @ReqURL("curl -X POST -d 'question={$JSON_STR}' http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys/12/question")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/groups/{groupId}/question", method = RequestMethod.POST, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String addQuestion(@PathVariable("surveyId") final int surveyId, @PathVariable("groupId") final int groupId , @RequestParam("question") final String question, final HttpServletRequest request) {
        final String METHOD = "addQuestion(int, HttpServletRequest)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId + ", request = " + request);
        }

        AddQuestionRespView respView = null;
        if (surveyId <= 0 || groupId <= 0 || !StringUtils.isNotBlank(question)) {
            final String message = "Survey ID '" + surveyId + "' and group ID '"+ groupId +"' should be greater than 0 or question '" + question + "' should not be null or empty";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            respView = new AddQuestionRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            Question newQuestion = JsonUtils.fromJson(question, Question.class);
            newQuestion.setLanguage(language);
            try {
                respView = surveyTemplate.execute(new AddQuestionCallback(surveyId, newQuestion));
            } catch (ServiceException e) {
                respView = new AddQuestionRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, e.getMessage());
            }
        }

        String json = JsonUtils.toJson(respView);
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - json = " + json);
        }

        return json;
    }

    @ReqURL("curl -X GET http://$SERVER_ADDR:$PORT/cloudata-app/api/surveys/12/groups/12/questions")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/surveys/{surveyId}/groups/{groupId}/questions", method = RequestMethod.GET, produces = CloudataConstants.HTTP_JSON_CONTENT_TYPE)
    public String getQuestions(@PathVariable("surveyId") final int surveyId, @PathVariable("groupId") final int groupId) {
        final String METHOD = "getQuestions(int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - surveyId = " + surveyId);
        }

        GetQuestionsRespView view = null;
        if (surveyId <= 0 || groupId <= 0) {
            final String message = "Survey ID '" + surveyId + "' and group ID '"+ groupId +"' should be greater than 0";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new GetQuestionsRespView(HttpStatus.OK.value(), CloudataConstants.REQ_FAILED, message);
        } else {
            try {
                view = surveyTemplate.execute(new GetQuestionsCallback(surveyId, groupId));
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
        throw new UnsupportedOperationException();
    }
}
