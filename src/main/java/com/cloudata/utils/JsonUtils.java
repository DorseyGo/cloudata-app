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

/**
 * Author: DORSEy
 */
public final class JsonUtils {

    public static String toJson(final Object src) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
        String json = gson.toJson(src);

        return json;
    }
}
