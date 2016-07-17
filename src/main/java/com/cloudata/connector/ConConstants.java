/*
 * File name: ConConstants
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public interface ConConstants extends Serializable {

    /**
     * The result field in serialized JSON string.
     */
    String SERIALIZED_RESULT = "result";

    /**
     * The error field in serialized JSON string.
     */
    String SERIALIZED_ERROR = "error";

    String SERIALIZED_METHOD = "method";
    String SERIALIZED_PARAMS = "params";
    String CMD_GET_SESSION_KEY = "get_session_key";
    String SERIALIZED_PASSWORD = "password";
    String SERIALIZED_USERNAME = "username";
    String SERIALIZED_ID = "id";
    String SERIALIZED_SESSION_KEY = "sSessionKey";
    String CMD_RELEASE_SESSION_KEY = "release_session_key";

    String OK_RESPONSE = "OK";
    String SERIALIZED_ISURVEY_ID = "iSurveyID";
    String SERIALIZED_SURVEY_TITLE = "sSurveyTitle";
    String SERIALIZED_SURVEY_LANGUAGE = "sSurveyLanguage";
    String SERIALIZED_FORMAT = "sformat";
    String CMD_ADD_SURVEY = "add_survey";
    String CMD_DELETE_SURVEY = "delete_survey";
    String SERIALIZED_STATUS = "status";
    String CMD_SET_SURVEY_PROPERTIES = "set_survey_properties";
    String SERIALIZED_SURVEY_DATA = "aSurveyData";
    String CMD_ACTIVATE_SURVEY = "activate_survey";
}
