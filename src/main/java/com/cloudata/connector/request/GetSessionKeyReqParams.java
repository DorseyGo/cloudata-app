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
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;

/**
 * The request parameters to be sent when attempts to get the session key from specific server.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_USERNAME, ConConstants.SERIALIZED_PASSWORD})
public class GetSessionKeyReqParams extends AbstractReqParams {

    /**
     * The username.
     */
    @Serialize(name = ConConstants.SERIALIZED_USERNAME)
    private String username;

    /**
     * The password.
     */
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
}
