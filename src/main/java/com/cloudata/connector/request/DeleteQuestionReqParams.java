/*
 * File name: DeleteQuestionReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
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
 * The request parameters should be sent when command {@link ConConstants#CMD_DELETE_QUESTION} is executed on server
 * side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_IQUESTION_ID})
public class DeleteQuestionReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * The question id to be removed.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IQUESTION_ID)
    private int questionId;

    /**
     * Empty constructor of {@link DeleteQuestionReqParams}.
     */
    public DeleteQuestionReqParams() {
        this(null, -1);
    }

    /**
     * Constructor of {@link AbstractReqParams}, with session key and question ID specified.
     *
     * @param sessionKey the session key.
     * @param questionId the question id.
     */
    public DeleteQuestionReqParams(final String sessionKey, final int questionId) {
        super(ConConstants.CMD_DELETE_QUESTION);
        setSessionKey(sessionKey);
        setQuestionId(questionId);
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

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", questionId: " + getQuestionId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof DeleteQuestionReqParams))
            return false;

        DeleteQuestionReqParams that = (DeleteQuestionReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (questionId == that.questionId);

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (questionId);

        return hashcode;
    }
}
