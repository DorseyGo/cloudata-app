/*
 * File name: DeleteGroupCallback
 * Author: Dorsey Q F TANG
 * Date: 9/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.callback.SessionCallback;
import com.cloudata.http.view.BooleanRespView;

/**
 * Author: DORSEy
 */
public class DeleteGroupCallback extends AbstractSessionCallback<BooleanRespView> {
    private final int surveyId;

    private final int groupId;

    /**
     * Default constructor of {@link DeleteGroupCallback}, with survey ID and group ID specified.
     *
     * @param surveyId the survey ID.
     * @param groupId  the group ID.
     */
    public DeleteGroupCallback(final int surveyId, final int groupId) {
        this.surveyId = surveyId;
        this.groupId = groupId;
    }

    @Override
    public BooleanRespView doInSession(String sessionKey) {
        return surveyManager.deleteGroup(sessionKey, surveyId, groupId);
    }
}
