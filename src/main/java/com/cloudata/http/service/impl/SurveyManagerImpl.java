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
import com.cloudata.connector.service.ConnectManager;
import com.cloudata.http.service.SurveyManager;
import com.cloudata.http.view.AddSurveyRespView;
import com.cloudata.http.view.BooleanRespView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private ConnectManager connectManager;

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
}
