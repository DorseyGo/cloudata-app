/*
 * File name: CloudataConstants
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata;

/**
 * An interface, which declares a list of constants.
 * <p>
 * Author: DORSEy
 */
public interface CloudataConstants {
    String HTTP_JSON_CONTENT_TYPE = "application/json";
    String REQ_ATTR_SURVEY_NAME = "surveyName";
    String RESP_VIEW_SURVEY_ID = "surveyId";
    String RESP_VIEW_GROUP_ID = "groupId";
    int REQ_OK = 1;

    String RESP_VIEW_STATUS = "status";
    String RESP_VIEW_CODE = "code";
    String RESP_VIEW_ERROR_MESSAGE = "errorMessage";
    int REQ_FAILED = 0;

    String RESP_VIEW_SURVEY = "survey";

    String RESP_VIEW_SURVEY_TITLE = "surveyTitle";
    String RESP_VIEW_START_DATE = "startDate";
    String RESP_VIEW_EXPIRES = "expires";
    String RESP_VIEW_ACTIVE = "active";
    String RESP_VIEW_SURVEYS = "surveys";
    String RESP_VIEW_QUESTION_ID = "questionId";
    String RESP_VIEW_TYPE = "type";
    String RESP_VIEW_QUESTION = "question";
    String RESP_VIEW_MANDATORY = "mandatory";
    String RESP_VIEW_QUESTION_ORDER = "questionOrder";
    String RESP_VIEW_QUESTIONS = "questions";

    String RESP_VIEW_CURRENT_PAGE = "curPage";
    String RESP_VEW_NUM_RECORDS = "numRecords";
    String RESP_VIEW_RECORDS = "records";
}
