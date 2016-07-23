/*
 * File name: ActivateSurveyReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.NotNull;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;

/**
 * The request parameters that being sent when command {@link ConConstants#CMD_ACTIVATE_SURVEY} is executed on server
 * side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID})
public class ActivateSurveyReqParams extends AbstractReqParams {

    /**
     * The session key.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * The survey ID
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int surveyId;

    /**
     * Empty constructor of {@link ActivateSurveyReqParams}.
     */
    public ActivateSurveyReqParams() {
        this(null, -1);
    }

    /**
     * Constructor of {@link ActivateSurveyReqParams}, with session key and survey ID specified.
     *
     * @param sessionKey the session key.
     * @param surveyId   the survey ID.
     */
    public ActivateSurveyReqParams(final String sessionKey, final int surveyId) {
        super(ConConstants.CMD_ACTIVATE_SURVEY);
        setSessionKey(sessionKey);
        setSurveyId(surveyId);
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

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", surveyId: " + getSurveyId();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + ((sessionKey == null || sessionKey.isEmpty()) ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (surveyId);

        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof ActivateSurveyReqParams))
            return false;

        ActivateSurveyReqParams that = (ActivateSurveyReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);

        return isEqualed;
    }
}
