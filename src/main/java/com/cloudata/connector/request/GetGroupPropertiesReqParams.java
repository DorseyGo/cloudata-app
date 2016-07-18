/*
 * File name: GetGroupPropertiesReqParams
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

import java.util.List;

/**
 * The request parameters should be sent when command {@link ConConstants#CMD_GET_GROUP_PROPERTIES} is executed on
 * server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_IGROUP_ID, ConConstants.SERIALIZED_GROUP_SETTINGS})
public class GetGroupPropertiesReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IGROUP_ID)
    private int groupId;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_GROUP_SETTINGS)
    private List<String> propKeys;

    /**
     * Constructor of {@link AbstractReqParams}, with session key, group id and property keys specified.
     *
     * @param sessionKey the session key.
     * @param groupId    the group ID.
     * @param propKeys   the property keys.
     */
    public GetGroupPropertiesReqParams(final String sessionKey, final int groupId, final List<String> propKeys) {
        super(ConConstants.CMD_GET_GROUP_PROPERTIES);
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

    public List<String> getPropKeys() {
        return propKeys;
    }

    public void setPropKeys(final List<String> propKeys) {
        this.propKeys = propKeys;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", groupId: " + getGroupId() + ", propKeys: " + getPropKeys();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof GetGroupPropertiesReqParams))
            return false;

        GetGroupPropertiesReqParams that = (GetGroupPropertiesReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (groupId == that.groupId);
        isEqualed = isEqualed && (propKeys == null ? that.propKeys == null : propKeys.equals(that.propKeys));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (groupId);
        hashcode += PRIME + (propKeys == null || propKeys.isEmpty() ? 0 : propKeys.hashCode());

        return hashcode;
    }
}
