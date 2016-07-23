/*
 * File name: ReleaseSessionKeyReqParams
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
 * The request parameters sent to invoke {@link ConConstants#CMD_RELEASE_SESSION_KEY} on the server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY})
public class ReleaseSessionKeyReqParams extends AbstractReqParams {

    /**
     * The session to be released.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * Empty constructor of {@link ReleaseSessionKeyReqParams}.
     */
    public ReleaseSessionKeyReqParams() {
        this(null);
    }

    /**
     * Constructor of {@link ReleaseSessionKeyReqParams}, with the session key specified.
     *
     * @param sessionKey the session key.
     */
    public ReleaseSessionKeyReqParams(final String sessionKey) {
        super(ConConstants.CMD_RELEASE_SESSION_KEY);
        setSessionKey(sessionKey);
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + ((sessionKey == null || sessionKey.isEmpty()) ? 0 : sessionKey.hashCode());

        return hashcode;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof ReleaseSessionKeyReqParams))
            return false;

        ReleaseSessionKeyReqParams that = (ReleaseSessionKeyReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));

        return isEqualed;
    }
}
