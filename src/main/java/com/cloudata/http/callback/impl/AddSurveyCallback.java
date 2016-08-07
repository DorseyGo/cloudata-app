/*
 * File name: AddSurveyCallback
 * Author: Dorsey Q F TANG
 * Date: 8/7/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.AddSurveyRespView;

/**
 * Author: DORSEy
 */
public class AddSurveyCallback extends AbstractSessionCallback<AddSurveyRespView> {

    /**
     * The survey to be added.
     */
    private String surveyTitle;

    /**
     * The language.
     */
    private String language;

    /**
     * Constructor of {@link AddSurveyCallback}, with survey title specified.
     *
     * @param surveyTitle the survey title.
     */
    public AddSurveyCallback(final String surveyTitle, final String languange) {
        this.surveyTitle = surveyTitle;
        this.language = languange;
    }

    @Override
    public AddSurveyRespView doInSession(final String sessionKey) {
        return surveyManager.addSurvey(sessionKey, surveyTitle, language);
    }
}
