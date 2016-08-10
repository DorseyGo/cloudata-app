/*
 * File name: JsonUtils
 * Author: Dorsey Q F TANG
 * Date: 8/4/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public final class JsonUtils {

    public static String toJson(final Object src) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
        String json = gson.toJson(src);

        return json;
    }

    public static <T extends Serializable> T fromJson(final String json, final Class<T> type) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        T obj = gson.fromJson(json, type);

        return obj;
    }
}
