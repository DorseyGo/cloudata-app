/*
 * File name: ResultCallbackWrapper
 * Author: Dorsey Q F TANG
 * Date: 7/21/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.callback.impl;

import com.cloudata.connector.callback.ResultCallback;
import com.cloudata.connector.response.Resp;

/**
 * Author: DORSEy
 */
public abstract class ResultCallbackWrapper<T extends Resp> implements ResultCallback<T> {
    protected ResultCallback<T> wrappedCallback;

    protected ResultCallbackWrapper(final ResultCallback<T> wrapped) {
        this.wrappedCallback = wrapped;
    }
}
