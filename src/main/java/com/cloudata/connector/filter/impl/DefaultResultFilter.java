/*
 * File name: DefaultResultFilter
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.filter.impl;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.exception.ResultProcessingException;
import com.cloudata.connector.filter.ResultFilter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * A default implementation of {@link ResultFilter}, which is just check the field <tt>error</tt> in specific JSON
 * string is null or not.
 * <p>
 *
 * Author: DORSEy
 */
public class DefaultResultFilter implements ResultFilter {

    @Override
    public boolean accept(final String json) throws ResultProcessingException {
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonObject root = jsonElement.getAsJsonObject();

        jsonElement = root.get(ConConstants.SERIALIZED_ERROR);
        boolean isNull = jsonElement.isJsonNull();

        // if the error is null then it succeed.
        if (!isNull)
            throw new ResultProcessingException(jsonElement.getAsString());

        return true;
    }
}
