/*
 * File name: AddSurveyReqParams
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.request;

import com.cloudata.connector.ConConstants;
import com.cloudata.connector.annotations.Orderized;
import com.cloudata.connector.annotations.Serialize;
import com.cloudata.connector.structs.SurveyFormat;

/**
 * The request to be sent when command {@link ConConstants#CMD_ADD_SURVEY} is executed on server side.
 * <p>
 * Author: DORSEy
 */
@Orderized(order = {ConConstants.SERIALIZED_SESSION_KEY, ConConstants.SERIALIZED_ISURVEY_ID, ConConstants.SERIALIZED_SURVEY_TITLE, ConConstants.SERIALIZED_SURVEY_LANGUAGE, ConConstants.SERIALIZED_FORMAT})
public class AddSurveyReqParams extends AbstractReqParams {

    /**
     * The session key.
     */
    @Serialize(name = ConConstants.SERIALIZED_SESSION_KEY)
    private String sessionKey;

    /**
     * The wished survey ID.
     */
    @Serialize(name = ConConstants.SERIALIZED_ISURVEY_ID)
    private int wishedSurveyId;

    /**
     * The survey title.
     */
    @Serialize(name = ConConstants.SERIALIZED_SURVEY_TITLE)
    private String surveyTitle;

    /**
     * The survey language.
     */
    @Serialize(name = ConConstants.SERIALIZED_SURVEY_LANGUAGE)
    private String surveyLanguage;

    /**
     * The survey format.
     */
    @Serialize(name = ConConstants.SERIALIZED_FORMAT)
    private String surveyFormat;


    /**
     * Constructor of {@link AbstractReqParams}, with method specified.
     *
     * @param method the method.
     */
    public AddSurveyReqParams(final String sessionKey, final String surveyTitle, final String surveyLanguage) {
        super(ConConstants.CMD_ADD_SURVEY);
        setSessionKey(sessionKey);
        setSurveyTitle(surveyTitle);
        setSurveyLanguage(surveyLanguage);
        setSurveyFormat(SurveyFormat.G_FORMAT.value());
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getWishedSurveyId() {
        return wishedSurveyId;
    }

    public void setWishedSurveyId(int wishedSurveyId) {
        this.wishedSurveyId = wishedSurveyId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public String getSurveyLanguage() {
        return surveyLanguage;
    }

    public void setSurveyLanguage(String surveyLanguage) {
        this.surveyLanguage = surveyLanguage;
    }

    public String getSurveyFormat() {
        return surveyFormat;
    }

    public void setSurveyFormat(String surveyFormat) {
        this.surveyFormat = surveyFormat;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("sessionKey: ").append(getSessionKey());
        builder.append(", surveyTitle: ").append(getSurveyTitle());
        builder.append(", surveyLanguage: ").append(getSurveyLanguage());
        builder.append(", surveyFormat: ").append(getSurveyFormat());

        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int hashcode = PRIME + ((sessionKey == null || sessionKey.isEmpty()) ? 0 : sessionKey.hashCode());
        hashcode += PRIME + ((surveyTitle == null || surveyTitle.isEmpty()) ? 0 : surveyTitle.hashCode());
        hashcode += PRIME + ((surveyLanguage == null || surveyLanguage.isEmpty()) ? 0 : surveyLanguage.hashCode());
        hashcode += PRIME + ((surveyFormat == null || surveyFormat.isEmpty()) ? 0 : surveyFormat.hashCode());

        return hashcode;
    }
}
