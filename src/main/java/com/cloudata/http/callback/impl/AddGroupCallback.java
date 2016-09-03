/*
 * File name: AddGroupCallback
 * Author: Dorsey Q F TANG
 * Date: 9/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.AddGroupRespView;

/**
 * Author: DORSEy
 */
public class AddGroupCallback extends AbstractSessionCallback<AddGroupRespView> {

    /**
     * The survey ID.
     */
    private final int surveyId;

    /**
     * The group title.
     */
    private final String groupTitle;

    /**
     * Default constructor of {@link AddGroupCallback}, with survey ID and group title specified.
     *
     * @param surveyId   the survey ID.
     * @param groupTitle the group title.
     */
    public AddGroupCallback(final int surveyId, final String groupTitle) {
        this.surveyId = surveyId;
        this.groupTitle = groupTitle;
    }


    @Override
    public AddGroupRespView doInSession(final String sessionKey) {
        return surveyManager.addGroup(sessionKey, surveyId, groupTitle);
    }
}
