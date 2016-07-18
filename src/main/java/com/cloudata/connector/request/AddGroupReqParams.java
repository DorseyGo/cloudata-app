/*
 * File name: AddGroupReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/18/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.NotNull;
import com.cloudata.connector.annotations.Optional;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;

/**
 * The request parameters that will be sent when command {@link ConConstants#CMD_ADD_GROUP} is executed on server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID, ConConstants.SERIALIZED_GROUP_TITLE, ConConstants.SERIALIZED_GROUP_DESCRIPTION})
public class AddGroupReqParams extends AbstractReqParams {

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
     * The group title.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_GROUP_TITLE)
    private String groupTitle;

    /**
     * The description.
     */
    @Optional
    @Serialize(name = ConConstants.SERIALIZED_GROUP_DESCRIPTION)
    private String groupDesc;

    /**
     * Empty constructor of {@link AddGroupReqParams}.
     */
    public AddGroupReqParams() {
        this(null, -1, null);
    }

    /**
     * Constructor of {@link AbstractReqParams}, with session key, survey id and group title specified.
     *
     * @param sessionKey the method.
     * @param surveyId   the survey id.
     * @param groupTitle the group title.
     */
    public AddGroupReqParams(String sessionKey, final int surveyId, final String groupTitle) {
        super(ConConstants.CMD_ADD_GROUP);
        setSessionKey(sessionKey);
        setSurveyId(surveyId);
        setGroupTitle(groupTitle);
        setGroupDesc(null);
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

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(final String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(final String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", surveyId: " + getSurveyId() + ", groupTitle: " + getGroupTitle() + ", groupDesc: " + getGroupDesc();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (surveyId);
        hashcode += PRIME + (groupTitle == null || groupTitle.isEmpty() ? 0 : groupTitle.hashCode());
        hashcode += PRIME + (groupDesc == null || groupDesc.isEmpty() ? 0 : groupDesc.hashCode());

        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof AddGroupReqParams))
            return false;

        AddGroupReqParams that = (AddGroupReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);
        isEqualed = isEqualed && (groupTitle == null ? that.groupTitle == null : groupTitle.equals(that.groupTitle));
        isEqualed = isEqualed && (groupDesc == null ? that.groupDesc == null : groupDesc.equals(that.groupDesc));

        return isEqualed;
    }
}
