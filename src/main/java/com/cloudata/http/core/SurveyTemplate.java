/*
 * File name: SurveyTemplate
 * Author: Dorsey Q F TANG
 * Date: 8/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.core;

import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.request.GetSessionKeyReqParams;
import com.cloudata.connector.request.ReleaseSessionKeyReqParams;
import com.cloudata.connector.response.GetSessionKeyResponse;
import com.cloudata.connector.service.ConnectManager;
import com.cloudata.http.callback.SessionCallback;
import com.cloudata.http.exception.ServiceException;
import com.cloudata.http.view.RespView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: DORSEy
 */
@Service("surveyTemplate")
public final class SurveyTemplate {

    /**
     * The class name.
     */
    private static final String CNAME = SurveyTemplate.class.getName();

    /**
     * The error recorder to log down error level message.
     */
    private static final Log ERROR = LogFactory.getLog("ERROR." + CNAME);

    /**
     * The username.
     */
    @Value("${ADMIN_NAME}")
    private String username;

    /**
     * The password.
     */
    @Value("${ADMIN_PASSWD}")
    private String password;

    @Autowired
    private ConnectManager connectManager;

    public <T extends RespView> T execute(final SessionCallback<T> callback) throws ServiceException {
        final String METHOD = "execute(SessionCallback)";

        String sessionKey = null;
        GetSessionKeyReqParams reqParams = new GetSessionKeyReqParams(username, password);
        try {
            GetSessionKeyResponse getSessionKeyResponse = connectManager.getSessionKey(reqParams);
            sessionKey = getSessionKeyResponse.getSessionKey();
        } catch (CommandExecutionException e) {
            final String message = "Failed to authenticate '" + username + "\'";
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - " + message);
            }

            throw new ServiceException(message, e);
        }

        T view = callback.doInSession(sessionKey);

        ReleaseSessionKeyReqParams releaseSessionKeyReqParams = new ReleaseSessionKeyReqParams(sessionKey);
        try {
            connectManager.releaseSessionKey(releaseSessionKeyReqParams);
        } catch (CommandExecutionException e) {
            if (ERROR.isErrorEnabled()) {
                ERROR.error(CNAME + "#" + METHOD + ": ERROR - Failed to release session \'" + sessionKey + "\'");
            }

            // ignore
        }

        return view;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
