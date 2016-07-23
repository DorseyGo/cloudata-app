/*
 * File name: GetSessionKeyReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/16/16
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
 * The request parameters to be sent when command {@link ConConstants#CMD_GET_SESSION_KEY} is executed on server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_USERNAME, ConConstants.SERIALIZED_PASSWORD})
public class GetSessionKeyReqParams extends AbstractReqParams {

    /**
     * The username.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_USERNAME)
    private String username;

    /**
     * The password.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_PASSWORD)
    private String password;

    /**
     * Empty constructor of {@link GetSessionKeyReqParams}.
     */
    public GetSessionKeyReqParams() {
        this(null, null);
    }

    /**
     * Constructor of {@link GetSessionKeyReqParams}, with username and password specified.
     *
     * @param username the username.
     * @param password the password.
     */
    public GetSessionKeyReqParams(final String username, final String password) {
        super(ConConstants.CMD_GET_SESSION_KEY);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username: " + getUsername();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof GetSessionKeyReqParams))
            return false;

        GetSessionKeyReqParams that = (GetSessionKeyReqParams) obj;
        boolean isEqualed = (username == null ? that.username == null : username.equals(that.username));
        isEqualed = isEqualed && (password == null ? that.password == null : password.equals(that.password));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (username == null || username.isEmpty() ? 0 : username.hashCode());
        hashcode += PRIME + (password == null || password.isEmpty() ? 0 : password.hashCode());

        return hashcode;
    }
}
