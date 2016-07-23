/*
 * File name: GetSurveyPropertiesReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/18/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.NotNull;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;

import java.util.List;

/**
 * The request parameters will be sent when {@link ConConstants#CMD_GET_SURVEY_PROPERTIES} is executed on server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID, ConConstants.SERIALIZED_SURVEY_SETTINGS})
public class GetSurveyPropertiesReqParams extends AbstractReqParams {

    /**
     * The session key.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * The survey ID.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int surveyId;

    /**
     * The property keys.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SURVEY_SETTINGS)
    private List<String> propKeys;

    /**
     * Empty constructor of {@link GetSurveyPropertiesReqParams}.
     */
    public GetSurveyPropertiesReqParams() {
        this(null, -1, null);
    }

    /**
     * Constructor of {@link AbstractReqParams}, with session key, survey Id and property keys specified.
     *
     * @param sessionKey the session key.
     * @param surveyId   the survey ID.
     * @param propKeys   the property keys.
     */
    public GetSurveyPropertiesReqParams(final String sessionKey, final int surveyId, final List<String> propKeys) {
        super(ConConstants.CMD_GET_SURVEY_PROPERTIES);
        setSessionKey(sessionKey);
        setSurveyId(surveyId);
        setPropKeys(propKeys);
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

    public List<String> getPropKeys() {
        return propKeys;
    }

    public void setPropKeys(final List<String> propKeys) {
        this.propKeys = propKeys;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", surveyId: " + getSurveyId() + ", propKeys: " + getPropKeys();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + ((sessionKey == null || sessionKey.isEmpty()) ? 0 : sessionKey.hashCode());
        hashcode += PRIME + ((propKeys == null || propKeys.isEmpty()) ? 0 : propKeys.hashCode());
        hashcode += PRIME + (surveyId);

        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof GetSurveyPropertiesReqParams))
            return false;

        GetSurveyPropertiesReqParams that = (GetSurveyPropertiesReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);
        isEqualed = isEqualed && ((propKeys == null) ? that.propKeys == null : propKeys.equals(that.propKeys));

        return isEqualed;
    }
}
