/*
 * File name: Answer
 * Author: Dorsey Q F TANG
 * Date: 8/10/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.structs;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Author: DORSEy
 */
public class Answer implements Serializable {

    @Expose
    @SerializedName(CloudataConstants.REQ_ATTR_ANSWER)
    private String answer;

    /**
     * Empty constructor of {@link Answer}.
     */
    public Answer() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }
}
