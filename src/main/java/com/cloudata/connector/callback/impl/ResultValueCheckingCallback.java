/*
 * File name: ResultValueCheckingCallback
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
import com.cloudata.connector.response.BooleanStatusResponse;
import com.cloudata.connector.response.Resp;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * The callback to be used when the properties should be checked for its updat-succeed operation.
 *
 * Author: DORSEy
 */
public class ResultValueCheckingCallback implements ResultCallback<BooleanStatusResponse> {

    private static final String CNAME = ResultValueCheckingCallback.class.getName();

    /**
     * The logger to log DEBUG level message.
     */
    private static final Log DEBUGGER = LogFactory.getLog(CNAME + ".DEBUGGER");

    /**
     * The properties to be checked.
     */
    private final Collection<String> props2Check;

    public ResultValueCheckingCallback(final Collection<String> props2Check) {
        this.props2Check = props2Check;
    }

    @Override
    public BooleanStatusResponse doWith(final String json) throws ResultProcessingException {
        final String METHOD = "doWith(String)";
        final boolean isDebugEnabled = DEBUGGER.isDebugEnabled();
        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": ENTRY - json = " + json);
        }

        JsonElement jsonElement = (new JsonParser()).parse(json);
        JsonObject root = jsonElement.getAsJsonObject();
        jsonElement = root.get(ConConstants.SERIALIZED_RESULT);
        JsonObject result = jsonElement.getAsJsonObject();

        String status = "OK";
        String boolRet = String.valueOf(Boolean.TRUE);
        BooleanStatusResponse response = new BooleanStatusResponse();
        for (String property : props2Check) {
            jsonElement = result.get(property);
            boolRet = jsonElement.getAsString();

            if (!Boolean.valueOf(boolRet).booleanValue()) {
                status = "FAILED";
                break;
            }
        }

        response.setStatus(status);

        if (isDebugEnabled) {
            DEBUGGER.debug(CNAME + "#" + METHOD + ": EXIT - response = " + response);
        }

        return response;
    }
}
