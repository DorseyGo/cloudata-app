/*
 * File name: GetSurveyCallback
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.GetSurveyRespView;

/**
 * Author: DORSEy
 */
public class GetSurveyCallback extends AbstractSessionCallback<GetSurveyRespView> {

    /**
     * The survey ID with which the survey is retrieved.
     */
    private int surveyId;

    /**
     * Constructor of {@link GetSurveyCallback}, with survey ID specified.
     *
     * @param surveyId the survey ID.
     */
    public GetSurveyCallback(final int surveyId) {
        super();
        this.surveyId = surveyId;
    }

    @Override
    public GetSurveyRespView doInSession(final String sessionKey) {
        return surveyManager.getSurvey(sessionKey, surveyId);
    }
}
