/*
 * File name: ListQuestionsReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/23/16
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
 * The request parameters should be sent when command {@link ConConstants#CMD_LIST_QUESTIONS} is executed on server
 * side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID, ConConstants.SERIALIZED_IGROUP_ID, ConConstants.SERIALIZED_SURVEY_LANGUAGE})
public class ListQuestionsReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int surveyId;

    @Optional
    @Serialize(name = ConConstants.SERIALIZED_IGROUP_ID)
    private int groupId;

    @Optional
    @Serialize(name = ConConstants.SERIALIZED_SURVEY_LANGUAGE)
    private String language;

    /**
     * Empty constructor of {@link ListQuestionsReqParams}.
     */
    public ListQuestionsReqParams() {
        this(null, -1);
    }

    /**
     * Constructor of {@link ListQuestionsReqParams}, with session key and survey ID specified.
     *
     * @param sessionKey the session key.
     * @param surveyId   the survey ID.
     */
    public ListQuestionsReqParams(final String sessionKey, final int surveyId) {
        super(ConConstants.CMD_LIST_QUESTIONS);
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", surveyId: " + getSurveyId() + ", groupId: " + getGroupId() + ", language: " + getLanguage();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof ListQuestionsReqParams))
            return false;

        ListQuestionsReqParams that = (ListQuestionsReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);
        isEqualed = isEqualed && (groupId == that.groupId);
        isEqualed = isEqualed && (language == null ? that.language == null : language.equals(that.language));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (surveyId);
        hashcode += PRIME + (groupId);
        hashcode += PRIME + (language == null || language.isEmpty() ? 0 : language.hashCode());

        return hashcode;
    }
}
