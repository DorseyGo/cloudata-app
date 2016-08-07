/*
 * File name: DeleteSurveyCallback
 * Author: Dorsey Q F TANG
 * Date: 8/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.BooleanRespView;

/**
 * Author: DORSEy
 */
public class DeleteSurveyCallback extends AbstractSessionCallback<BooleanRespView> {

    /**
     * The survey ID to be deleted.
     */
    private final int surveyId;

    /**
     * Constructor of {@link DeleteSurveyCallback}, with survey ID specified.
     *
     * @param surveyId the survey ID.
     */
    public DeleteSurveyCallback(final int surveyId) {
        super();
        this.surveyId = surveyId;
    }

    @Override
    public BooleanRespView doInSession(final String sessionKey) {
        return surveyManager.deleteSurvey(sessionKey, surveyId);
    }
}
