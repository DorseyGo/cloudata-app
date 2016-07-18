/*
 * File name: DeleteGroupReqParams
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

/**
 * The request parameters should be sent when command {@link ConConstants#CMD_DELETE_GROUP} is executed on server side.
 *
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID, ConConstants.SERIALIZED_IGROUP_ID})
public class DeleteGroupReqParams extends AbstractReqParams {

    /**
     * The session key.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * The survey id.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int surveyId;

    /**
     * The group id.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IGROUP_ID)
    private int groupId;

    /**
     * Constructor of {@link AbstractReqParams}, with session key, survey id and group Id specified.
     *
     * @param sessionKey the session key.
     *                   @param surveyId the survey id.
     *                                   @param groupId the group id.
     */
    public DeleteGroupReqParams(final String sessionKey, final int surveyId, final int groupId) {
        super(ConConstants.CMD_DELETE_GROUP);
        setSessionKey(sessionKey);
        setSurveyId(surveyId);
        setGroupId(groupId);
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", surveyId: "+ getSurveyId() + ", groupId: " + getGroupId();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + surveyId;
        hashcode += PRIME + groupId;

        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof DeleteGroupReqParams))
            return false;

        DeleteGroupReqParams that = (DeleteGroupReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey) );
        isEqualed = isEqualed && (surveyId == that.surveyId);
        isEqualed = isEqualed && (groupId == that.groupId);

        return isEqualed;
    }
}
