/*
 * File name: DeleteGroupResponse
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
 * The response generated when {@link ConConstants#CMD_DELETE_GROUP} is executed on server side.
 * <p>
 * Author: DORSEy
 */
public class DeleteGroupResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_RESULT)
    private int groupIdRemoved;

    /**
     * Empty constructor of {@link DeleteGroupResponse}.
     */
    public DeleteGroupResponse() {
        // empty constructor
    }

    public int getGroupIdRemoved() {
        return groupIdRemoved;
    }

    public void setGroupIdRemoved(final int groupIdRemoved) {
        this.groupIdRemoved = groupIdRemoved;
    }

    @Override
    public String toString() {
        return "groupIdRemoved: " + getGroupIdRemoved();
    }
}
