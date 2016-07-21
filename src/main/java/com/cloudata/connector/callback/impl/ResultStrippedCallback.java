/*
 * File name: ResultStrippedCallback
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.callback.impl;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.callback.ResultCallback;
import com.cloudata.connector.exception.ResultProcessingException;
import com.cloudata.connector.response.Resp;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Author: DORSEy
 */
public class ResultStrippedCallback<T extends Resp> extends ResultCallbackWrapper<T> {

    /**
     * Constructor of {@link ResultStrippedCallback}, with type of bean specified.
     *
     * @param wrapped the wrapped callback handler.
     */
    public ResultStrippedCallback(final ResultCallback<T> wrapped) {
        super(wrapped);
    }

    @Override
    public T doWith(final String json) throws ResultProcessingException {
        JsonElement jsonElement = (new JsonParser()).parse(json);
        JsonObject rootJsonObj = jsonElement.getAsJsonObject();
        jsonElement = rootJsonObj.get(ConConstants.SERIALIZED_RESULT);

        T bean = super.wrappedCallback.doWith(jsonElement.toString());

        return bean;
    }
}
