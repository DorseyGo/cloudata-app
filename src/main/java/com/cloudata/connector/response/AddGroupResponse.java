/*
 * File name: AddGroupResponse
 * Author: Dorsey Q F TANG
 * Date: 7/18/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command {@link ConConstants#CMD_ADD_GROUP} is executed on server side.
 * <p>
 * Author: DORSEy
 */
public class AddGroupResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private int groupId;

    /**
     * Empty constructor of {@link AddGroupResponse}.
     */
    public AddGroupResponse() {
        // empty constructor
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "groupId: " + groupId;
    }
}
