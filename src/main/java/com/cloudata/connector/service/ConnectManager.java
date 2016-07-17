/*
 * File name: ConnectManager
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.service;

import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.request.*;
import com.cloudata.connector.response.AddSurveyResponse;
import com.cloudata.connector.response.GetSessionKeyResponse;

/**
 * A service interface, which defines lots of manipulations on specific server.
 * <p>
 * Author: DORSEy
 */
public interface ConnectManager {

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_GET_SESSION_KEY}</tt> on server side, and return the
     * response generated. It throws command execution exception if errors detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return the response generated.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    GetSessionKeyResponse getSessionKey(final GetSessionKeyReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_RELEASE_SESSION_KEY}</tt> on server side, and
     * returns true if the command executed successfully. It throws command execution exception if errors detected
     * during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the session key is released successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    boolean releaseSessionKey(final ReleaseSessionKeyReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_ADD_SURVEY}</tt> on server side, and returns the
     * response if the command executed successfully. It throws command execution exception if errors detected during
     * procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the session key is released successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    AddSurveyResponse addSurvey(final AddSurveyReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_DELETE_SURVEY}</tt> on server side, and
     * returns true if the command executed successfully. It throws command execution exception if errors detected
     * during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the session key is released successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    boolean deleteSurvey(final DeleteSurveyReqParams reqParams) throws CommandExecutionException;

    boolean setSurveyProperties(final SetSurveyPropertiesReqParams reqParams) throws CommandExecutionException;

    boolean activateSurvey(final ActivateSurveyReqParams reqParams) throws CommandExecutionException;
}
