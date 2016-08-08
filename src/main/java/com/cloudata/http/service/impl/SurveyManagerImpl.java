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
import com.cloudata.connector.request.AddGroupReqParams;
import com.cloudata.connector.request.AddSurveyReqParams;
import com.cloudata.connector.request.DeleteSurveyReqParams;
import com.cloudata.connector.request.ListQuestionsReqParams;
import com.cloudata.connector.response.AddSurveyResponse;
import com.cloudata.connector.response.ListQuestionsResponse;
import com.cloudata.connector.service.ConnectManager;
import com.cloudata.http.converter.ViewUtils;
import com.cloudata.http.service.SurveyManager;
import com.cloudata.http.view.*;
import com.cloudata.persistent.bean.SurveyModel;
import com.cloudata.persistent.service.SurveyPersistentService;
import com.cloudata.persistent.structs.Pagination;
import com.cloudata.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

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
            connectManager.addGroup(addGroupReqParams);
        } catch (CommandExecutionException e) {
            final String message = "Failed to create survey '" + surveyTitle + "'";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            view = new AddSurveyRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        } finally {
            if (surveyId == -1) {
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
        }

        view = new AddSurveyRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK);
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

        Pagination<SurveyModel> pagination = persistentService.paginate(currentPage, pageSize, owner);
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

        SurveyModel surveyModel = persistentService.queryForSurvey(surveyId);
        SurveyDetailView survey = ViewUtils.copyOf(surveyModel);
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

        List<ListQuestionsResponse> responses = null;
        ListQuestionsReqParams reqParams = new ListQuestionsReqParams(sessionKey, surveyId);
        try {
            responses = connectManager.listQuestions(reqParams);
        } catch (CommandExecutionException e) {
            final String message = "Failed to list questions of survey[" + surveyId + "]";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            return new GetQuestionsRespView(HttpStatus.SC_OK, CloudataConstants.REQ_FAILED, message);
        }

        GetQuestionsRespView view = new GetQuestionsRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK);
        view.setQuestions(ViewUtils.copyOf(responses.toArray(new ListQuestionsResponse[responses.size()])));

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - view = " + view);
        }

        return view;
    }

    public void setConnectManager(final ConnectManager connectManager) {
        this.connectManager = connectManager;
    }

    public void setPersistentService(final SurveyPersistentService persistentService) {
        this.persistentService = persistentService;
    }
}
