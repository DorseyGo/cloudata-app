/*
 * File name: AddGroupRespView
 * Author: Dorsey Q F TANG
 * Date: 9/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Author: DORSEy
 */
public class AddGroupRespView extends AbstractRespView {

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_GROUP_ID)
    private int groupId;

    /**
     * Empty constructor of {@link AddGroupRespView}.
     */
    public AddGroupRespView() {
        super();
    }

    /**
     * Constructor of {@link AddGroupRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    public AddGroupRespView(final int status, final int code, final String errorMessage) {
        super(status, code, errorMessage);
    }

    /**
     * Constructor of {@link AddGroupRespView}, with status, code and group ID specified.
     *
     * @param status  the status.
     * @param code    the code.
     * @param groupId the group ID.
     */
    public AddGroupRespView(final int status, final int code, final int groupId) {
        this(status, code, null);
        setGroupId(groupId);
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return super.toString() + ", groupId: " + groupId;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (groupId);

        return super.hashCode() + hashcode;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof AddGroupRespView))
            return false;

        AddGroupRespView that = (AddGroupRespView) obj;
        boolean isEqualed = (groupId == that.groupId);

        return super.equals(obj) && isEqualed;
    }
}
