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
import com.cloudata.connector.request.DeleteSurveyReqParams;
import com.cloudata.connector.request.ListQuestionsReqParams;
import com.cloudata.connector.response.ListQuestionsResponse;
import com.cloudata.connector.service.ConnectManager;
import com.cloudata.http.converter.ViewUtils;
import com.cloudata.http.service.SurveyManager;
import com.cloudata.http.view.*;
import com.cloudata.persistent.bean.SurveyModel;
import com.cloudata.persistent.service.SurveyPersistentService;
import com.cloudata.persistent.structs.Pagination;
import com.cloudata.utils.ReflectionUtils;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.LinkedList;
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
    public AddSurveyRespView addSurvey(final String sessionKey, final String surveyName) {
        return null;
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
            message = "Failed to delete survey \'" + surveyId + "\'";
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

        // FIXME, maybe need to fetch it from DB
        // don't leverage RPC calls provided by connect manager.
        GetSurveyRespView view = new GetSurveyRespView(HttpStatus.SC_OK, CloudataConstants.REQ_OK, null);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - " + view);
        }

        return view;
    }

    private List<String> propsOf(final Class<SurveyDetailView> targetClass) {
        final String METHOD = "propsOf(Class)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - targetClass = " + targetClass);
        }

        final List<String> propKeys = new LinkedList<>();
        ReflectionUtils.doWithFields(targetClass, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(final Field field) throws IllegalAccessException, IllegalArgumentException {
                SerializedName serializedName = field.getAnnotation(SerializedName.class);
                String propsKey = serializedName.value();

                propKeys.add(propsKey);
            }
        }, new ReflectionUtils.FieldFilter() {
            @Override
            public boolean matches(final Field field) {
                return field.isAnnotationPresent(SerializedName.class);
            }
        });

        return propKeys;
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
