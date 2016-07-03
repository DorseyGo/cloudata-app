/**
 * File name: SurveyView Author: Dorsey Q F TANG Date: 6/30/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.app.views;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Author: DORSEy
 */
public class SurveyView implements Serializable {
    private int surveyId;
    private String surveyTitle;
    private String owner;
    private Date createdTime;

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
