/*
 * File name: ListGroupsResponse
 * Author: Dorsey Q F TANG
 * Date: 7/21/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.response;

import com.cloudata.connector.ConConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The response generated when command {@link ConConstants#CMD_LIST_GROUPS} is executed on the server side.
 * <p>
 * Author: DORSEy
 */
public class ListGroupsResponse implements Resp {

    @SerializedName(ConConstants.SERIALIZED_GROUP_ID)
    private int groupId;

    @SerializedName(ConConstants.SERIALIZED_SURVEY_ID)
    private int surveyId;

    @SerializedName(ConConstants.SERIALIZED_GROUP_NAME)
    private String groupName;

    @SerializedName(ConConstants.SERIALIZED_GROUP_ORDER)
    private String groupOrder;

    @SerializedName(ConConstants.SERIALIZED_DESCRIPTION)
    private String groupDesc;

    @SerializedName(ConConstants.SERIALIZED_LANGUAGE)
    private String language;

    @SerializedName(ConConstants.SERIALIZED_GROUP_RELEVANCE)
    private String groupRelevance;

    /**
     * Empty constructor of {@link ListGroupsResponse}.
     */
    public ListGroupsResponse() {
        // empty constructor
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(String groupOrder) {
        this.groupOrder = groupOrder;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGroupRelevance() {
        return groupRelevance;
    }

    public void setGroupRelevance(String groupRelevance) {
        this.groupRelevance = groupRelevance;
    }

    @Override
    public String toString() {
        return "groupId: " + getGroupId() + ", surveyId: " + getSurveyId() + ", groupName: " + getGroupName();
    }
}
