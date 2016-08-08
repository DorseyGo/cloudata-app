/*
 * File name: DeleteQuestionCallback
 * Author: Dorsey Q F TANG
 * Date: 8/8/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.BooleanRespView;

/**
 * Author: DORSEy
 */
public class DeleteQuestionCallback extends AbstractSessionCallback<BooleanRespView> {

    /**
     * The survey ID.
     */
    private int surveyId;

    /**
     * The question ID.
     */
    private int questionId;

    /**
     * Constructor of {@link DeleteQuestionCallback}, with survey and question ID specified.
     *
     * @param surveyId   the survey ID.
     * @param questionId the question ID.
     */
    public DeleteQuestionCallback(final int surveyId, final int questionId) {
        super();
        this.surveyId = surveyId;
        this.questionId = questionId;
    }

    @Override
    public BooleanRespView doInSession(final String sessionKey) {
        return surveyManager.deleteQuestion(sessionKey, questionId);
    }
}
