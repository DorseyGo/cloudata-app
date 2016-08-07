/*
 * File name: GetQuestionsCallback
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.GetQuestionsRespView;

/**
 * Author: DORSEy
 */
public class GetQuestionsCallback extends AbstractSessionCallback<GetQuestionsRespView> {

    /**
     * The survey ID.
     */
    private int surveyId;

    /**
     * Constructor of {@link GetQuestionsCallback}, with survey ID specified.
     *
     * @param surveyId the survey ID.
     */
    public GetQuestionsCallback(final int surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public GetQuestionsRespView doInSession(String sessionKey) {
        return surveyManager.getQuestions(sessionKey, surveyId);
    }
}
