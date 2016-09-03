/*
 * File name: SurveyManagerImpl
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.service.impl;

import com.cloudata.CloudataConstants;
import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.importor.QuestionGenerator;
import com.cloudata.connector.importor.QuestionGeneratorFactory;
import com.cloudata.connector.importor.structs.Question;
import com.cloudata.connector.request.*;
import com.cloudata.connector.response.AddGroupResponse;
import com.cloudata.connector.response.AddSurveyResponse;
import com.cloudata.connector.response.ImportQuestionResponse;
import com.cloudata.connector.response.ListQuestionsResponse;
import com.cloudata.connector.service.ConnectManager;
import com.cloudata.http.converter.ViewUtils;
import com.cloudata.http.service.SurveyManager;
import com.cloudata.http.view.*;
import com.cloudata.persistent.bean.QuestionVO;
import com.cloudata.persistent.bean.SurveyVO;
import com.cloudata.persistent.service.SurveyPersistentService;
import com.cloudata.persistent.structs.Pagination;
import com.cloudata.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of {@link SurveyManager}.
 * <p>
 * Author: DORSEy
 */
@Service("surveyManager")
public class SurveyManagerImpl implements SurveyManager {

    /**
     * The class name.
     */
    private static final String CNAME = SurveyManagerImpl.class.getName();

    /**
     * The debugger to log down debug level message.
     */
    private static final Log DEBUGGER = LogFactory.getLog("DEBUGGER." + CNAME);

    /**
     * The error recorder to log down error level message.
     */
    private static final Log ERROR = LogFactory.getLog("ERROR." + CNAME);

    private ConnectManager connectManager;

    private SurveyPersistentService persistentService;

    @Override
    public AddSurveyRespView addSurvey(final String sessionKey, final String surveyTitle, final String language) {
        final String METHOD = "addSurvey(String, String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", surveyTitle = " + surveyTitle + ", language = " + language);
        }

        AddSurveyRespView view = null;
        int surveyId = -1;
        AddSurveyReqParams addSurveyReqParams = new AddSurveyReqParams(sessionKey, surveyTitle, language);
        try {
            AddSurveyResponse addSurveyResponse = connectManager.addSurvey(addSurveyReqParams);
            surveyId = addSurveyResponse.getSurveyId();
            AddGroupReqParams addGroupReqParams = new AddGroupReqParams(sessionKey, surveyId, "G" + StringUtils.randomized(2));
            AddGroupResponse addGroupResponse = connectManager.addGroup(addGroupReqParams);
            view = new AddSurveyRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK, surveyId, addGroupResponse.getGroupId());
        } catch (CommandExecutionException e) {
            final String message = "Failed to create survey '" + surveyTitle + "'";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            if (surveyId != -1) {
                if (isDebugEnabled) {
                    DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - rollback the survey '" + surveyId + "' created");
                }

                DeleteSurveyReqParams deleteSurveyReqParams = new DeleteSurveyReqParams(sessionKey, surveyId);
                try {
                    connectManager.deleteSurvey(deleteSurveyReqParams);
                } catch (CommandExecutionException ignore) {
                    if (ERROR.isWarnEnabled()) {
                        ERROR.warn(CNAME + "#" + METHOD + ": WARN - Failed to rollback the survey '" + surveyId + "'");
                    }
                }
            }

            view = new AddSurveyRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        }

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - view = " + view);
        }

        return view;
    }

    @Override
    public BooleanRespView deleteSurvey(final String sessionKey, final int surveyId) {
        final String METHOD = "deleteSurvey(String, int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", surveyId = " + surveyId);
        }

        boolean succeed = false;
        String message = null;
        DeleteSurveyReqParams reqParams = new DeleteSurveyReqParams(sessionKey, surveyId);
        try {
            succeed = connectManager.deleteSurvey(reqParams);
        } catch (CommandExecutionException e) {
            message = "Failed to delete survey '" + surveyId + "'";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            succeed = false;
        }

        int code = (succeed) ? CloudataConstants.REQ_OK : CloudataConstants.REQ_FAILED;
        BooleanRespView view = new BooleanRespView(HttpStatus.SC_OK, code, message);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - view = " + view);
        }

        return view;
    }

    @Override
    public GetSurveysRespView getSurveys(final String sessionKey, final int currentPage, final int pageSize, final String owner) {
        final String METHOD = "getSurveys(String, String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", owner = " + owner);
        }

        Pagination<SurveyVO> pagination = persistentService.paginate(currentPage, pageSize, owner);
        com.cloudata.http.structs.Pagination<SurveyDetailView> viewPagination = ViewUtils.copyOf(pagination);
        GetSurveysRespView resp = new GetSurveysRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK);
        resp.setSurveys(viewPagination);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - resp = " + resp);
        }

        return resp;
    }

    @Override
    public GetSurveyRespView getSurvey(final String sessionKey, final int surveyId) {
        final String METHOD = "getSurvey(String, int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", surveyId = " + surveyId);
        }

        if (surveyId <= 0) {
            final String message = "Invalid argument surveyId '" + surveyId + "' detected";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            return new GetSurveyRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        }

        SurveyVO surveyVO = persistentService.queryForSurvey(surveyId);
        SurveyDetailView survey = ViewUtils.copyOf(surveyVO);
        GetSurveyRespView view = new GetSurveyRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK, null);
        view.setSurvey(survey);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - " + view);
        }

        return view;
    }

    @Override
    public GetQuestionsRespView getQuestions(final String sessionKey, final int surveyId) {
        final String METHOD = "getQuestions(String, int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", surveyId = " + surveyId);
        }

        List<QuestionVO> questionVOs = null;
        GetQuestionsRespView view = null;
        List<QuestionDetailView> questions = null;
        try {
            questionVOs = persistentService.queryForQuestions(surveyId);
            if (questionVOs != null && !questionVOs.isEmpty()) {
                questions = ViewUtils.copyOf(questionVOs.toArray(new QuestionVO[questionVOs.size()]));
            }

            view = new GetQuestionsRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK);
            view.setQuestions(questions);
        } catch (Exception e) {
            final String message = "Failed to query questions by surveyId '" + surveyId + "'";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message + ", " + e);
            }

            view = new GetQuestionsRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        }

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - view = " + view);
        }

        return view;
    }

    @Override
    public BooleanRespView deleteQuestion(final String sessionKey, final int questionId) {
        final String METHOD = "deleteQuestion(String, int)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", questionId = " + questionId);
        }

        boolean succeed = false;
        final String message = "Failed to delete question '" + questionId + "'";
        DeleteQuestionReqParams reqParams = new DeleteQuestionReqParams(sessionKey, questionId);
        try {
            succeed = connectManager.deleteQuestion(reqParams);
        } catch (CommandExecutionException e) {
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message + ", cause " + e);
            }

            succeed = false;
        }

        BooleanRespView respView = (succeed) ? new BooleanRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK) :
                new BooleanRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - respView = " + respView);
        }

        return respView;
    }

    @Override
    public AddQuestionRespView addQuestion(final String sessionKey, final int surveyId, final int groupId, final Question question) {
        final String METHOD = "addQuestion(String, int, int, String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", surveyId = " + surveyId + ", groupId = " + groupId + ", question = " + question);
        }

        AddQuestionRespView respView = null;
        String importedData = null;
        QuestionGenerator generator = QuestionGeneratorFactory.getFactory().get(question.getType());
        try {
            importedData = generator.generate(question);

            ImportQuestionReqParams reqParams = new ImportQuestionReqParams(sessionKey, surveyId, groupId, importedData);
            ImportQuestionResponse response = connectManager.importQuestion(reqParams);
            respView = new AddQuestionRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK, response.getQuestionId());
        } catch (CommandExecutionException | IOException e) {
            final String message = "Failed to add question to survey '" + surveyId + "'";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message + ", " + e);
            }

            respView = new AddQuestionRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        }

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - respView = " + respView);
        }

        return respView;
    }

    @Override
    public AddGroupRespView addGroup(final String sessionKey, final int surveyId, final String groupTitle) {
        final String METHOD = "addGroup(String, int, String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - sessionKey = " + sessionKey + ", surveyId = " + surveyId + ", groupTitle = " + groupTitle);
        }

        AddGroupRespView respView = null;
        AddGroupReqParams reqParams = new AddGroupReqParams(sessionKey, surveyId, groupTitle);
        try {
            AddGroupResponse addGroupResponse = connectManager.addGroup(reqParams);
            respView = new AddGroupRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK, addGroupResponse.getGroupId());
        } catch (CommandExecutionException e) {
            final String message = "Failed to add group [" + groupTitle + "] to survey [" + surveyId + "]";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message + ", " + e);
            }

            respView = new AddGroupRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        }

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - respView = " + respView);
        }

        return respView;
    }

    public void setConnectManager(final ConnectManager connectManager) {
        this.connectManager = connectManager;
    }

    public void setPersistentService(final SurveyPersistentService persistentService) {
        this.persistentService = persistentService;
    }
}
