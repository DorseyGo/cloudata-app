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
    String CMD_GET_SURVEY_PROPERTIES = "get_survey_properties";
    String SERIALIZED_SURVEY_SETTINGS = "aSurveySettings";
    String CMD_ADD_GROUP = "add_group";
    String SERIALIZED_GROUP_TITLE = "sGroupTitle";
    String SERIALIZED_GROUP_DESCRIPTION = "sGroupDescription";
    String CMD_DELETE_GROUP = "delete_group";
    String SERIALIZED_IGROUP_ID = "iGroupID";
    String CMD_GET_GROUP_PROPERTIES = "get_group_properties";
    String SERIALIZED_GROUP_SETTINGS = "aGroupSettings";
    String CMD_SET_GROUP_PROPERTIES = "set_group_properties";
    String SERIALIZED_GROUP_DATA = "aGroupData";

    String CMD_DELETE_QUESTION = "delete_question";
    String SERIALIZED_IQUESTION_ID = "iQuestionID";
    String CMD_IMPORT_QUESTION = "import_question";
    String SERIALIZED_IMPORT_DATA = "sImportData";
    String SERIALIZED_IMPORT_DATA_TYPE = "sImportDataType";

    String CMD_LIST_SURVEYS = "list_surveys";
    String SERIALIZED_SUSERNAME = "sUsername";
    String SERIALIZED_SURVEY_ID = "sid";
    String SERIALIZED_SURVEY_LIST_TITLE = "surveyls_title";
    String SERIALIZED_START_DATE = "startDate";
    String SERIALIZED_EXPIRES = "expires";
    String SERIALIZED_ACTIVE = "active";
}
