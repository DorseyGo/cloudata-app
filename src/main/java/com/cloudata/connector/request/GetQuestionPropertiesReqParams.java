/*
 * File name: GetQuestionPropertiesReqParams
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

import java.util.List;

/**
 * The request parameters should be sent when command {@link ConConstants#CMD_GET_QUESTION_PROPERTIES} is executed on
 * server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_IQUESTION_ID, ConConstants.SERIALIZED_QUESTION_SETTINGS, ConConstants.SERIALIZED_SLANGUAGE})
public class GetQuestionPropertiesReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IQUESTION_ID)
    private int questionId;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_QUESTION_SETTINGS)
    private List<String> propKeys;

    @Optional
    @Serialize(name = ConConstants.SERIALIZED_SLANGUAGE)
    private String language;

    /**
     * Empty constructor of {@link GetQuestionPropertiesReqParams}.
     */
    public GetQuestionPropertiesReqParams() {
        this(null, -1, null);
    }

    /**
     * Constructor of {@link GetQuestionPropertiesReqParams}, with session key, question ID and property keys
     * specified.
     *
     * @param sessionKey the session key.
     * @param questionId the question ID.
     * @param propKeys   the property keys.
     */
    public GetQuestionPropertiesReqParams(final String sessionKey, final int questionId, final List<String> propKeys) {
        super(ConConstants.CMD_GET_QUESTION_PROPERTIES);
        setSessionKey(sessionKey);
        setQuestionId(questionId);
        setPropKeys(propKeys);
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

    public List<String> getPropKeys() {
        return propKeys;
    }

    public void setPropKeys(final List<String> propKeys) {
        this.propKeys = propKeys;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", questionId: " + getQuestionId() + ", propKeys: " + getPropKeys() + ", language: " + getLanguage();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof GetQuestionPropertiesReqParams))
            return false;

        GetQuestionPropertiesReqParams that = (GetQuestionPropertiesReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (questionId == that.questionId);
        isEqualed = isEqualed && (propKeys == null ? that.propKeys == null : propKeys.equals(that.propKeys));
        isEqualed = isEqualed && (language == null ? that.language == null : language.equals(that.language));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (questionId);
        hashcode += PRIME + (propKeys == null || propKeys.isEmpty() ? 0 : propKeys.hashCode());
        hashcode += PRIME + (language == null || language.isEmpty() ? 0 : language.hashCode());

        return hashcode;
    }
}
