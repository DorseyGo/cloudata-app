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
}
