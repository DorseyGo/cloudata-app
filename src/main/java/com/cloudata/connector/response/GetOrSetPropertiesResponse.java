/*
 * File name: GetOrSetPropertiesResponse
 * Author: Dorsey Q F TANG
 * Date: 7/18/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * The response generated when Get/Set-kind properties commands executed on server side.
 *
 * @see com.cloudata.connector.request.SetSurveyPropertiesReqParams
 *
 * Author: DORSEy
 */
public class GetOrSetPropertiesResponse implements Resp {

    /**
     * The properties with key/value pair.
     */
    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private Map<String, Object> props;

    /**
     * Empty constructor of {@link GetOrSetPropertiesResponse}.
     */
    public GetOrSetPropertiesResponse() {
        // empty constructor
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(final Map<String, Object> props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "properties: " + getProps();
    }
}
