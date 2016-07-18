/*
 * File name: SetGroupPropertiesReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/18/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.NotNull;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;

import java.util.Map;

/**
 * The request parameters should be sent when command {@link ConConstants#CMD_SET_GROUP_PROPERTIES} is executed on
 * server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_IGROUP_ID, ConConstants.SERIALIZED_GROUP_DATA})
public class SetGroupPropertiesReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IGROUP_ID)
    private int groupId;

    /**
     * The key/value pair to be set.
     */
    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_GROUP_DATA)
    private Map<String, Object> properties;

    /**
     * Empty constructor of {@link SetGroupPropertiesReqParams}.
     */
    public SetGroupPropertiesReqParams() {
        this(null, -1, null);
    }

    /**
     * Constructor of {@link AbstractReqParams}, with session key, group id and properties specified.
     *
     * @param sessionKey the session key.
     * @param groupId    the group id.
     * @param properties the key/value pair.
     */
    public SetGroupPropertiesReqParams(final String sessionKey, final int groupId, final Map<String, Object> properties) {
        super(ConConstants.CMD_SET_GROUP_PROPERTIES);
        setSessionKey(sessionKey);
        setGroupId(groupId);
        setProperties(properties);
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(final Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", goupId: " + getGroupId() + ", properties: " + getProperties();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof SetGroupPropertiesReqParams))
            return false;

        SetGroupPropertiesReqParams that = (SetGroupPropertiesReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (groupId == that.groupId);
        isEqualed = isEqualed && (properties == null ? that.properties == null : properties.equals(that.properties));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (groupId);
        hashcode += PRIME + (properties == null || properties.isEmpty() ? 0 : properties.hashCode());

        return hashcode;
    }
}
