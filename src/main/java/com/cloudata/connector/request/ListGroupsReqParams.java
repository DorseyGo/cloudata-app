/*
 * File name: ListGroupsReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/21/16
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
 * The request parameters should be sent when command {@link ConConstants#CMD_LIST_GROUPS} is executed on server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID})
public class ListGroupsReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int surveyId;

    /**
     * Empty constructor of {@link ListGroupsReqParams}.
     */
    public ListGroupsReqParams() {
        this(null, -1);
    }

    /**
     * Constructor of {@link ListGroupsReqParams}, with session key and survey Id specified.
     *
     * @param sessionKey the session key.
     * @param surveyId   the survey ID.
     */
    public ListGroupsReqParams(final String sessionKey, final int surveyId) {
        super(ConConstants.CMD_LIST_GROUPS);
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof ListGroupsReqParams))
            return false;

        ListGroupsReqParams that = (ListGroupsReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (surveyId);

        return hashcode;
    }
}
