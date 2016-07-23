/*
 * File name: ListSurveysReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/20/16
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
 * The request parameters should be sent when command {@link ConConstants#CMD_LIST_SURVEYS} is executed on server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_SUSERNAME})
public class ListSurveysReqParams extends AbstractReqParams {

    /**
     * The session key.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * The owner of the survey
     */
    @Optional
    @Serialize(name = ConConstants.SERIALIZED_SUSERNAME)
    private String owner;

    /**
     * Empty constructor of {@link ListSurveysReqParams}.
     */
    public ListSurveysReqParams() {
        this(null);
    }

    /**
     * Constructor of {@link ListSurveysReqParams}, with session key specified.
     *
     * @param sessionKey the session key.
     */
    public ListSurveysReqParams(final String sessionKey) {
        this(sessionKey, null);
    }

    /**
     * Constructor of {@link ListSurveysReqParams}, with session key and owner specified.
     *
     * @param sessionKey the session key.
     * @param owner      the owner.
     */
    public ListSurveysReqParams(final String sessionKey, final String owner) {
        super(ConConstants.CMD_LIST_SURVEYS);
        setSessionKey(sessionKey);
        setOwner(owner);
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", owner: " + getOwner();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof ListSurveysReqParams))
            return false;

        ListSurveysReqParams that = (ListSurveysReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (owner == null ? that.owner == null : owner.equals(that.owner));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (owner == null || owner.isEmpty() ? 0 : owner.hashCode());

        return hashcode;
    }
}
