/*
 * File name: ImportQuestionReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/19/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.NotNull;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;

/**
 * The request parameters should be sent when command {@link ConConstants#CMD_IMPORT_QUESTION} is executed on server
 * side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID, ConConstants.SERIALIZED_IGROUP_ID, ConConstants.SERIALIZED_IMPORT_DATA, ConConstants.SERIALIZED_IMPORT_DATA_TYPE})
public class ImportQuestionReqParams extends AbstractReqParams {

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int surveyId;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IGROUP_ID)
    private int groupId;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IMPORT_DATA)
    private String importedData;

    @NotNull
    @Serialize(name = ConConstants.SERIALIZED_IMPORT_DATA_TYPE)
    private String importedDataType = "lsq";

    /**
     * Empty constructor of {@link ImportQuestionReqParams}.
     */
    public ImportQuestionReqParams() {
        this(null, -1, -1, null);
    }

    /**
     * Constructor of {@link AbstractReqParams}, with session key, survey id, group id and question imported data
     * specified.
     *
     * @param sessionKey the session key.
     * @param surveyId   the survey ID.
     * @param groupId    the group id.
     * @param importData question imported data.
     */
    public ImportQuestionReqParams(final String sessionKey, final int surveyId, final int groupId, final String importData) {
        super(ConConstants.CMD_IMPORT_QUESTION);
        setSessionKey(sessionKey);
        setSurveyId(surveyId);
        setGroupId(groupId);
        setImportedData(importData);
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(final int surveyId) {
        this.surveyId = surveyId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(final int groupId) {
        this.groupId = groupId;
    }

    public String getImportedData() {
        return importedData;
    }

    public void setImportedData(final String importedData) {
        this.importedData = importedData;
    }

    public String getImportedDataType() {
        return importedDataType;
    }

    public void setImportedDataType(final String importedDataType) {
        this.importedDataType = importedDataType;
    }

    @Override
    public String toString() {
        return "sessionKey: " + getSessionKey() + ", surveyId: " + getSurveyId() + ", groupId: " + getGroupId() +
                "importData: " + getImportedData() + ", importDataType: " + getImportedDataType();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || !(obj instanceof ImportQuestionReqParams))
            return false;

        ImportQuestionReqParams that = (ImportQuestionReqParams) obj;
        boolean isEqualed = (sessionKey == null ? that.sessionKey == null : sessionKey.equals(that.sessionKey));
        isEqualed = isEqualed && (surveyId == that.surveyId);
        isEqualed = isEqualed && (groupId == that.groupId);
        isEqualed = isEqualed && (importedData == null ? that.importedData == null : importedData.equals(that.importedData));
        isEqualed = isEqualed && (importedDataType == null ? that.importedDataType == null : importedDataType.equals(that.importedDataType));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + (sessionKey == null || sessionKey.isEmpty() ? 0 : sessionKey.hashCode());
        hashcode += PRIME + (surveyId);
        hashcode += PRIME + (groupId);
        hashcode += PRIME + (importedData == null || importedData.isEmpty() ? 0 : importedData.hashCode());
        hashcode += PRIME + (importedDataType == null || importedDataType.isEmpty() ? 0 : importedDataType.hashCode());

        return hashcode;
    }
}
