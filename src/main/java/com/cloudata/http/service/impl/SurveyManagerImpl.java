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
import com.cloudata.connector.exception.InsufficientReqParamException;
import com.cloudata.connector.request.AddGroupReqParams;
import com.cloudata.connector.request.AddSurveyReqParams;
import com.cloudata.connector.request.GetSessionKeyReqParams;
import com.cloudata.connector.response.AddGroupResponse;
import com.cloudata.connector.response.AddSurveyResponse;
import com.cloudata.connector.response.GetSessionKeyResponse;
import com.cloudata.connector.service.ConnectManager;
import com.cloudata.http.service.SurveyManager;
import com.cloudata.http.structs.TimedSession;
import com.cloudata.http.view.AddSurveyRespView;
import com.cloudata.http.view.RespView;
import com.cloudata.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * An implementation of {@link SurveyManager}.
 * <p>
 * Author: DORSEy
 */
@Service("surveyManager")
public class SurveyManagerImpl implements SurveyManager {

    @Autowired
    private ConnectManager connectManager;

    /**
     * A cache to buffer username/sessionkey pair.
     */
    private static Map<String, TimedSession> sessionKeyCache = new ConcurrentHashMap<>();

    /**
     * The class name.
     */
    private static final String CNAME = SurveyManagerImpl.class.getName();

    /**
     * The log tracker to log down the DEBUG level message.
     */
    private static final Log DEBUGGER = LogFactory.getLog("DEBUGGER." + CNAME);

    @Value("")
    private String username;

    @Value("")
    private String password;

    @Value("")
    private String language;

    @Override
    public RespView addSurvey(final String accountName, final String surveyName) throws CommandExecutionException, InsufficientReqParamException {
        final String METHOD = "addSurvey(String, String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - accountName = " + accountName + ", surveyName = " + surveyName);
        }

        String sessionKey = checkAndReturn(accountName);
        AddSurveyReqParams reqParams = new AddSurveyReqParams(sessionKey, surveyName, language);
        AddSurveyResponse addSurveyResponse = connectManager.addSurvey(reqParams);
        int surveyId = addSurveyResponse.getSurveyId();

        String groupName = "G" + StringUtils.randomized(3);
        AddGroupReqParams addGroupReqParams = new AddGroupReqParams(sessionKey, surveyId, groupName);
        AddGroupResponse addGroupResponse = connectManager.addGroup(addGroupReqParams);
        int groupId = addGroupResponse.getGroupId();

        RespView addSurveyRespView = new RespView(CloudataConstants.REQ_OK);
        AddSurveyRespView body = new AddSurveyRespView(surveyId, groupId);
        addSurveyRespView.setBodyView(body);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - addSurveyRespView = " + addSurveyRespView);
        }

        return addSurveyRespView;
    }

    private String checkAndReturn(final String accountName) throws CommandExecutionException {
        final String METHOD = "checkAndReturn(String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - accountName = " + accountName);
        }

        String sessionKey = null;
        TimedSession timedSession = sessionKeyCache.get(accountName);
        if (timedSession != null && !(isExpired(timedSession.getCreatedTime()))) {
            return timedSession.getSessionKey();
        }

        // TODO retrieve it from database.
        GetSessionKeyResponse response = connectManager.getSessionKey(new GetSessionKeyReqParams(username, password));
        sessionKey = response.getSessionKey();

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - sessionKey = " + sessionKey);
        }

        return sessionKey;
    }

    private boolean isExpired(final Date createdTime) {
        Calendar createdCalendar = Calendar.getInstance();
        createdCalendar.setTime(createdTime);
        createdCalendar.add(Calendar.HOUR, 2);

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        boolean isExpired = now.after(createdCalendar);

        return isExpired;
    }
}
