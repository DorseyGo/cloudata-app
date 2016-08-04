/*
 * File name: SurveyManager
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.service;

import com.cloudata.http.view.AddSurveyRespView;
import com.cloudata.http.view.BooleanRespView;
import com.cloudata.http.view.GetSurveyRespView;

/**
 * Author: DORSEy
 */
public interface SurveyManager {
    AddSurveyRespView addSurvey(final String sessionKey, final String surveyName);

    BooleanRespView deleteSurvey(final String sessionKey, final int surveyId);

    GetSurveyRespView getSurvey(final String sessionKey, final int surveyId);
}
