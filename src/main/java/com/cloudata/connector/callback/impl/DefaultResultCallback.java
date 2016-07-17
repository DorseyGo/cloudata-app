/*
 * File name: DefaultResultCallback
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.callback.impl;

import com.cloudata.connector.callback.ResultCallback;
import com.cloudata.connector.exception.ResultProcessingException;
import com.cloudata.connector.response.Resp;
import com.google.gson.Gson;

/**
 * Author: DORSEy
 */
public class DefaultResultCallback<T extends Resp> implements ResultCallback<T> {

    private Class<T> typeOfBean;

    public DefaultResultCallback(final Class<T> typeOfBean) {
        this.typeOfBean = typeOfBean;
    }

    @Override
    public T doWith(final String json) throws ResultProcessingException {
        Gson gson = new Gson();
        T bean = gson.fromJson(json, typeOfBean);

        return bean;
    }

}
