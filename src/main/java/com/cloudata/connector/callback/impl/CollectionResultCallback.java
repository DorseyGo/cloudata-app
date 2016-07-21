/*
 * File name: CollectionResultCallback
 * Author: Dorsey Q F TANG
 * Date: 7/21/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.callback.impl;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.callback.ResultCallback;
import com.cloudata.connector.exception.ResultProcessingException;
import com.cloudata.connector.response.Resp;
import com.cloudata.connector.response.ResponseDecorator;
import com.google.gson.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: DORSEy
 */
public class CollectionResultCallback<T extends Resp> implements ResultCallback<ResponseDecorator<T>> {

    private Class<T> typeOfBean;

    public CollectionResultCallback(final Class<T> typeOfBean) {
        this.typeOfBean = typeOfBean;
    }

    @Override
    public ResponseDecorator<T> doWith(final String json) throws ResultProcessingException {
        JsonElement element = (new JsonParser()).parse(json);
        JsonObject jsonObj = element.getAsJsonObject();
        element = jsonObj.get(ConConstants.SERIALIZED_RESULT);

        T result = null;
        Gson gson = new Gson();
        List<T> rets = new LinkedList<>();
        JsonArray arr = element.getAsJsonArray();
        int size = arr.size();
        for (int index = 0; index < size; index++) {
            element = arr.get(index);
            jsonObj = element.getAsJsonObject();
            jsonObj.remove(ConConstants.SERIALIZED_ID);

            result = gson.fromJson(jsonObj, typeOfBean);
            rets.add(result);
        }

        ResponseDecorator<T> decorator = new ResponseDecorator<>();
        decorator.setRetResponse(rets);

        return decorator;
    }
}
