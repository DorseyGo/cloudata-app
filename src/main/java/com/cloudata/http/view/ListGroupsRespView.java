/*
 * File name: ListGroupRespView
 * Author: Dorsey Q F TANG
 * Date: 9/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.cloudata.connector.request.ListGroupsReqParams;
import com.cloudata.connector.response.ListGroupsResponse;
import com.cloudata.http.structs.Pagination;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Author: DORSEy
 */
public class ListGroupsRespView extends AbstractRespView {

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_GROUPS)
    private Pagination<GroupDetailView> groups;

    /**
     * Empty constructor of {@link ListGroupsRespView}.
     */
    public ListGroupsRespView() {
        super();
    }

    /**
     * Constructor of {@link ListGroupsRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    public ListGroupsRespView(final int status, final int code, final String errorMessage) {
        super(status, code, errorMessage);
    }

    /**
     * Constructor of {@link ListGroupsRespView}, with status, code and paginated groups specified.
     *
     * @param status the status.
     * @param code   the code.
     * @param groups the groups.
     */
    public ListGroupsRespView(final int status, final int code, final Pagination<GroupDetailView> groups) {
        setStatus(status);
        setCode(code);
        setGroups(groups);
    }

    public Pagination<GroupDetailView> getGroups() {
        return groups;
    }

    public void setGroups(final Pagination<GroupDetailView> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return super.toString() + ", groups: " + groups;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof ListGroupsRespView))
            return false;

        ListGroupsRespView that = (ListGroupsRespView) obj;
        boolean isEqualed = (groups == null ? that.groups == null : groups.equals(that.groups));

        return super.equals(obj) && isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (groups == null ? 0 : groups.hashCode());

        return super.hashCode() + hashcode;
    }

}
