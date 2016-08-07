/*
 * File name: GetQuestionsRespView
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.view;

import com.cloudata.CloudataConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author: DORSEy
 */
public class GetQuestionsRespView extends AbstractRespView {

    @Expose
    @SerializedName(CloudataConstants.RESP_VIEW_QUESTIONS)
    private List<QuestionDetailView> questions;

    /**
     * Empty constructor of {@link GetQuestionsRespView}.
     */
    public GetQuestionsRespView() {
        super();
    }

    /**
     * Constructor of {@link GetQuestionsRespView}, with status and code specified.
     *
     * @param status the status.
     * @param code   the code.
     */
    public GetQuestionsRespView(final int status, final int code) {
        this(status, code, null);
    }

    /**
     * Constructor of {@link GetQuestionsRespView}, with status, code and error message specified.
     *
     * @param status       the status.
     * @param code         the code.
     * @param errorMessage the error message.
     */
    public GetQuestionsRespView(final int status, final int code, final String errorMessage) {
        super(status, code, errorMessage);
    }

    public List<QuestionDetailView> getQuestions() {
        return questions;
    }

    public void setQuestions(final List<QuestionDetailView> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return super.toString() + ", questions: " + getQuestions();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof GetQuestionsRespView))
            return false;

        GetQuestionsRespView that = (GetQuestionsRespView) obj;
        boolean isEqualed = (status == that.status);
        isEqualed = isEqualed && (code == that.code);
        isEqualed = isEqualed && (errorMessage == null ? that.errorMessage == null : errorMessage.equals(that.errorMessage));
        isEqualed = isEqualed && (questions == null ? that.questions == null : questions.equals(that.questions));

        return isEqualed;
    }

    @Override
    public int hashCode() {
        final int PRMIE = 31;
        int hashcode = PRMIE + (questions == null || questions.isEmpty() ? 0 : questions.hashCode());

        return (super.hashCode() + hashcode);
    }
}
