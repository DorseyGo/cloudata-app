/*
 * File name: DeleteSurveyCallback
 * Author: Dorsey Q F TANG
 * Date: 8/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.callback.SessionCallback;
import com.cloudata.http.service.SurveyManager;
import com.cloudata.http.service.impl.SurveyManagerImpl;
import com.cloudata.http.view.BooleanRespView;
import com.cloudata.utils.SpringUtils;

/**
 * Author: DORSEy
 */
public class DeleteSurveyCallback implements SessionCallback<BooleanRespView> {

    /**
     * The survey ID to be deleted.
     */
    private final int surveyId;

    /**
     * The survey manager.
     */
    private SurveyManager surveyManager;

    /**
     * Constructor of {@link DeleteSurveyCallback}, with survey ID specified.
     *
     * @param surveyId the survey ID.
     */
    public DeleteSurveyCallback(final int surveyId) {
        this.surveyId = surveyId;
        this.surveyManager = SpringUtils.getBean(SurveyManagerImpl.class);
    }

    @Override
    public BooleanRespView doInSession(final String sessionKey) {
        return surveyManager.deleteSurvey(sessionKey, surveyId);
    }
}
