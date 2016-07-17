/*
 * File name: DeleteSurveyReqParams
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

/**
 * The request parameters that need be sent to execute {@link ConConstants#CMD_DELETE_SURVEY} on server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID})
public class DeleteSurveyReqParams extends AbstractReqParams {

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
     * Empty constructor of {@link DeleteSurveyReqParams}.
     */
    public DeleteSurveyReqParams() {
        this(null, -1);
    }

    /**
     * Constructor of {@link AbstractReqParams}, with session key and survey ID specified.
     *
     * @param sessionKey the session key.
     * @param surveyId   the survey ID.
     */
    public DeleteSurveyReqParams(final String sessionKey, final int surveyId) {
        super(ConConstants.CMD_DELETE_SURVEY);
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
        hashcode += PRIME + surveyId;

        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof DeleteSurveyReqParams))
            return false;

        DeleteSurveyReqParams that = (DeleteSurveyReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);

        return isEqualed;
    }
}
