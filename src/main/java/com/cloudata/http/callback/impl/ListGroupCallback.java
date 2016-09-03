/*
 * File name: ListGroupCallback
 * Author: Dorsey Q F TANG
 * Date: 9/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.ListGroupsRespView;

/**
 * Author: DORSEy
 */
public class ListGroupCallback extends AbstractSessionCallback<ListGroupsRespView> {

    /**
     * the survey ID.
     */
    private final int surveyId;

    /**
     * current page.
     */
    private final int currentPage;

    /**
     * page size.
     */
    private final int pageSize;

    /**
     * Default constructor of {@link ListGroupsRespView}, with survey ID, current page and page size specified.
     *
     * @param surveyId    the survey ID.
     * @param currentPage the current page.
     * @param pageSize    the page size.
     */
    public ListGroupCallback(int surveyId, int currentPage, int pageSize) {
        this.surveyId = surveyId;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    @Override
    public ListGroupsRespView doInSession(final String sessionKey) {
        return surveyManager.getGroups(sessionKey, currentPage, pageSize);
    }
}
