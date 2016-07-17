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
public class ResultStrippedCallback<T extends Resp> implements ResultCallback<T> {
    /**
     * The type of bean to be serialized.
     */
    private Class<T> typeOfBean;

    /**
     * Constructor of {@link ResultStrippedCallback}, with type of bean specified.
     *
     * @param typeOfBean the type of bean.
     */
    public ResultStrippedCallback(final Class<T> typeOfBean) {
        this.typeOfBean = typeOfBean;
    }

    @Override
    public T doWith(final String json) throws ResultProcessingException {
        JsonElement jsonElement = (new JsonParser()).parse(json);
        JsonObject rootJsonObj = jsonElement.getAsJsonObject();
        jsonElement = rootJsonObj.get(ConConstants.SERIALIZED_RESULT);

        Gson gson = new Gson();
        T bean = gson.fromJson(jsonElement, typeOfBean);

        return bean;
    }
}
