/*
 * File name: GetSurveysCallback
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.view.GetSurveysRespView;

/**
 * Author: DORSEy
 */
public class GetSurveysCallback extends AbstractSessionCallback<GetSurveysRespView> {

    /**
     * The owner.
     */
    private String owner;

    /**
     * The current page.
     */
    private int curPage;

    /**
     * Page size, indicates how much records should be displayed in one page.
     */
    private int pageSize;

    /**
     * Constructor of {@link GetSurveysCallback}, with current page and page size specified.
     *
     * @param currentPage the current page.
     * @param pageSize    the page size.
     */
    public GetSurveysCallback(final int currentPage, final int pageSize) {
        this(currentPage, pageSize, null);
    }

    /**
     * Constructor of {@link GetSurveysCallback}, with current page, page size ands owner specified.
     *
     * @param owner       the owner.
     * @param currentPage the current page.
     * @param pageSize    the page size.
     */
    public GetSurveysCallback(final int currentPage, final int pageSize, final String owner) {
        this.owner = owner;
        this.curPage = currentPage;
        this.pageSize = pageSize;
    }

    @Override
    public GetSurveysRespView doInSession(String sessionKey) {
        return surveyManager.getSurveys(sessionKey, curPage, pageSize, owner);
    }
}
