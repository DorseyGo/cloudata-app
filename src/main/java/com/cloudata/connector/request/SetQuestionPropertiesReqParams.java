/*
 * File name: SetQuestionPropertiesReqParams
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

import java.util.Map;

/**
 * The request parameters should be sent when command {@link ConConstants#CMD_SET_QUESTION_PROPERTIES} is executed on
 * server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_IQUESTION_ID, ConConstants.SERIALIZED_QUESTION_DATA, ConConstants.SERIALIZED_SLANGUAGE})
public class SetQuestionPropertiesReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IQUESTION_ID)
    private int questionId;

    /**
     * key/value pair to set.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_QUESTION_DATA)
    private Map<String, Object> questionData;

    @Optional
    @Serialize(name = ConConstants.SERIALIZED_SLANGUAGE)
    private String language;

    /**
     * Empty constructor of {@link SetQuestionPropertiesReqParams}.
     */
    public SetQuestionPropertiesReqParams() {
        this(null, -1, null);
    }

    /**
     * Constructor of {@link SetQuestionPropertiesReqParams}, with session key, question ID and question data
     * specified.
     *
     * @param sessionKey   the session key.
     * @param questionId   the question ID.
     * @param questionData the question data.
     */
    public SetQuestionPropertiesReqParams(final String sessionKey, final int questionId, final Map<String, Object> questionData) {
        super(ConConstants.CMD_SET_QUESTION_PROPERTIES);
        setSessionKey(sessionKey);
        setQuestionId(questionId);
        setQuestionData(questionData);
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(final int questionId) {
        this.questionId = questionId;
    }

    public Map<String, Object> getQuestionData() {
        return questionData;
    }

    public void setQuestionData(final Map<String, Object> questionData) {
        this.questionData = questionData;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", questionId: " + getQuestionId() + ", questionData: " + getQuestionData() + ", lanaguage: " + getLanguage();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof SetQuestionPropertiesReqParams))
            return false;

        SetQuestionPropertiesReqParams that = (SetQuestionPropertiesReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (questionId == that.questionId);
        isEqualed = isEqualed && (questionData == null ? that.questionData == null : questionData.equals(that.questionData));
        isEqualed = isEqualed && (language == null ? that.language == null : language.equals(that.language));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (questionId);
        hashcode += PRIME + (questionData == null || questionData.isEmpty() ? 0 : questionData.hashCode());
        hashcode += PRIME + (language == null || language.isEmpty() ? 0 : language.hashCode());

        return hashcode;
    }
}
