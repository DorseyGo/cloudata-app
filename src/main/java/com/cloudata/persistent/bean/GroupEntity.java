/*
 * File name: GroupEntity
 * Author: Dorsey Q F TANG
 * Date: 9/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.bean;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public class GroupEntity implements Serializable {
    private int groupId;
    private int groupOrder;
    private String groupTitle;
    private String groupDescription;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(int groupOrder) {
        this.groupOrder = groupOrder;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{groupId: ").append(groupId);
        builder.append(", groupOrder: ").append(groupOrder);
        builder.append(", groupTitle: ").append(groupTitle);
        builder.append(", groupDescription: ").append(groupDescription);
        builder.append("}");

        return builder.toString();
    }
}
