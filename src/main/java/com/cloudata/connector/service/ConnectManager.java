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
import com.cloudata.connector.response.*;

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
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_DELETE_SURVEY}</tt> on server side, and returns true
     * if the command executed successfully. It throws command execution exception if errors detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the session key is released successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    boolean deleteSurvey(final DeleteSurveyReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_GET_SURVEY_PROPERTIES}</tt> on server side, and
     * returns the response if the command executed successfully. It throws command execution exception if errors
     * detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return the response generated.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    GetOrSetPropertiesResponse getSurveyProperties(final GetSurveyPropertiesReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_SET_SURVEY_PROPERTIES}</tt> on server side, and returns true
     * if the command executed successfully. It throws command execution exception if errors detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the session key is released successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    boolean setSurveyProperties(final SetSurveyPropertiesReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_ACTIVATE_SURVEY}</tt> on server side, and returns true
     * if the command executed successfully. It throws command execution exception if errors detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the session key is released successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    boolean activateSurvey(final ActivateSurveyReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_ADD_GROUP}</tt> on server side, and
     * returns the response if the command executed successfully. It throws command execution exception if errors
     * detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return the response generated.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    AddGroupResponse addGroup(final AddGroupReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_ACTIVATE_SURVEY}</tt> on server side, and returns true
     * if the command executed successfully. It throws command execution exception if errors detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the session key is released successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    boolean deleteGroup(final DeleteGroupReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_GET_GROUP_PROPERTIES}</tt> on server side, and
     * returns the response if the command executed successfully. It throws command execution exception if errors
     * detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return the response generated.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    GetOrSetPropertiesResponse getGroupProperties(final GetGroupPropertiesReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_SET_GROUP_PROPERTIES}</tt> on server side, and
     * returns the response if the command executed successfully. It throws command execution exception if errors
     * detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return the response generated.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    GetOrSetPropertiesResponse setGroupProperties(final SetGroupPropertiesReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_DELETE_QUESTION}</tt> on server side, and returns true
     * if the command executed successfully. It throws command execution exception if errors detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return true if and only if the question is removed successfully.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    boolean deleteQuestion(final DeleteQuestionReqParams reqParams) throws CommandExecutionException;

    /**
     * To invoke <tt>{@link com.cloudata.connector.ConConstants#CMD_IMPORT_QUESTION}</tt> on server side, and
     * returns the response if the command executed successfully. It throws command execution exception if errors
     * detected during procedure.
     *
     * @param reqParams the required request parameters to call the specific APIs.
     * @return the response generated.
     * @throws CommandExecutionException if errors detected during the procedure.
     */
    ImportQuestionResponse importQuestion(final ImportQuestionReqParams reqParams) throws CommandExecutionException;
}
