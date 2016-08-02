/*
 * File name: TimedSession
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.structs;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: DORSEy
 */
public class TimedSession implements Serializable {

    /**
     * The session key.
     */
    private String sessionKey;

    /**
     * The created time.
     */
    private Date createdTime;

    /**
     * Empty constructor of {@link TimedSession}.
     */
    public TimedSession() {
        this(null);
    }

    /**
     * Constructor of {@link TimedSession}, with session key and created time specified.
     *
     * @param sessionKey  the session key.
     */
    public TimedSession(final String sessionKey) {
        setSessionKey(sessionKey);
        setCreatedTime(new Date());
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
