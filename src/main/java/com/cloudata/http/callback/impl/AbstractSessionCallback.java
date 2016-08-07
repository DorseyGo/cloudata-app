/*
 * File name: AbstractSessionCallback
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.http.callback.SessionCallback;
import com.cloudata.http.service.SurveyManager;
import com.cloudata.http.service.impl.SurveyManagerImpl;
import com.cloudata.http.view.RespView;
import com.cloudata.utils.SpringUtils;

/**
 * An abstract implementation of {@link SessionCallback}.
 * <p>
 * Author: DORSEy
 */
abstract class AbstractSessionCallback<T extends RespView> implements SessionCallback<T> {

    /**
     * An instance of {@link SurveyManager}.
     */
    protected SurveyManager surveyManager;

    /**
     * Empty constructor of {@link AbstractSessionCallback}.
     */
    protected AbstractSessionCallback() {
        this.surveyManager = SpringUtils.getBean(SurveyManagerImpl.class);
    }
}
