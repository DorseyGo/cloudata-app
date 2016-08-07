/*
 * File name: SurveyManager
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.service;

import com.cloudata.http.view.*;

/**
 * Author: DORSEy
 */
public interface SurveyManager {
    AddSurveyRespView addSurvey(final String sessionKey, final String surveyTitle, final String language);

    BooleanRespView deleteSurvey(final String sessionKey, final int surveyId);

    GetSurveyRespView getSurvey(final String sessionKey, final int surveyId);

    GetSurveysRespView getSurveys(final String sessionKey, final int currentPage, final int pageSize, final String owner);

    GetQuestionsRespView getQuestions(final String sessionKey, final int surveyId);
}
