/*
 * File name: GroupDetailView
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
public class GroupDetailView extends AbstractRespView {
    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_GROUP_ID)
    private int groupId;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_GROUP_ORDER)
    private int groupOrder;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_GROUP_TITLE)
    private String groupTitle;

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_GROUP_DESCRIPTION)
    private String groupDescription;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    public int getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(final int groupOrder) {
        this.groupOrder = groupOrder;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(final String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(final String groupDescription) {
        this.groupDescription = groupDescription;
    }
}
