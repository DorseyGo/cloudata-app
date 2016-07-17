/*
 * File name: GetSessionKeyResponse
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command <tt>get_session_key</tt> is executed on server side.
 * <p>
 * Author: DORSEy
 */
public class GetSessionKeyResponse implements Resp {

    /**
     * The session key.
     */
    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private String sessionKey;

    /**
     * Empty constructor of {@link GetSessionKeyResponse}.
     */
    public GetSessionKeyResponse() {
        // empty constructor
        setSessionKey(null);
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey();
    }
}
