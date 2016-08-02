/*
 * File name: SurveyManager
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.service;

import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.exception.InsufficientReqParamException;
import com.cloudata.http.view.RespView;

/**
 * Author: DORSEy
 */
public interface SurveyManager {
    RespView addSurvey(final String accountName, final String surveyName) throws CommandExecutionException, InsufficientReqParamException;
}
