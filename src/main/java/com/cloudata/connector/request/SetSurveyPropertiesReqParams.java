/*
 * File name: SetSurveyPropertiesReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;

import java.util.Map;

/**
 * The request parameters that being sent when command {@link ConConstants#CMD_SET_SURVEY_PROPERTIES} is executed on
 * server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID, ConConstants.SERIALIZED_SURVEY_DATA})
public class SetSurveyPropertiesReqParams extends AbstractReqParams {

    /**
     * The session key.
     */
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * The survey ID.
     */
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int surveyId;

    /**
     * The survey data with key/value pair.
     */
    @Serialize(name = ConConstants.SERIALIZED_SURVEY_DATA)
    private Map<String, Object> properties;

    /**
     * Empty constructor of {@link SetSurveyPropertiesReqParams}.
     */
    public SetSurveyPropertiesReqParams() {
        this(null, -1, null);
    }

    /**
     * Constructor of {@link AbstractReqParams}, with session key, survey ID and properties specified.
     *
     * @param sessionKey the session key.
     * @param surveyId   the survey ID.
     * @param properties the properties.
     */
    public SetSurveyPropertiesReqParams(final String sessionKey, final int surveyId, final Map<String, Object> properties) {
        super(ConConstants.CMD_SET_SURVEY_PROPERTIES);
        setSessionKey(sessionKey);
        setSurveyId(surveyId);
        setProperties(properties);
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(final int surveyId) {
        this.surveyId = surveyId;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(final Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", surveyId: " + getSurveyId() + ", properties: " + getProperties();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + ((sessionKey == null || sessionKey.isEmpty()) ? 0 : sessionKey.hashCode());
        hashcode += PRIME + ((properties == null || properties.isEmpty()) ? 0 : properties.hashCode());
        hashcode += PRIME + surveyId;

        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof SetSurveyPropertiesReqParams))
            return false;

        SetSurveyPropertiesReqParams that = (SetSurveyPropertiesReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);
        isEqualed = isEqualed && ((properties == null) ? that.properties == null : properties.equals(that.properties));

        return isEqualed;
    }

}
