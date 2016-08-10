/*
 * File name: AddQuestionCallback
 * Author: Dorsey Q F TANG
 * Date: 8/10/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.callback.impl;

import com.cloudata.connector.importor.MultipleChoiceQuestionGenerator;
import com.cloudata.connector.importor.structs.MultipleChoiceAnswer;
import com.cloudata.connector.structs.QuestionType;
import com.cloudata.http.structs.Answer;
import com.cloudata.http.structs.Question;
import com.cloudata.http.view.AddQuestionRespView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: DORSEy
 */
public class AddQuestionCallback extends AbstractSessionCallback<AddQuestionRespView> {

    private static final List<String> PURE_ANSWER_TYPES = new ArrayList<>();

    static {
        PURE_ANSWER_TYPES.add(QuestionType.FIVE_POINTS.getValue());
        PURE_ANSWER_TYPES.add(QuestionType.SINGLE_CHOICE.getValue());
        PURE_ANSWER_TYPES.add(QuestionType.SINGLE_CHOICE_WITH_COMMENT.getValue());
    }

    /**
     * The survey ID.
     */
    private int surveyId;

    /**
     * The question.
     */
    private Question question;

    /**
     * Constructor of {@link AddQuestionCallback}, with survey ID and question specified.
     *
     * @param surveyId the survey ID.
     * @param question the question.
     */
    public AddQuestionCallback(final int surveyId, final Question question) {
        this.surveyId = surveyId;
        this.question = question;
    }

    @Override
    public AddQuestionRespView doInSession(final String sessionKey) {
        int surveyId = question.getSurveyId();
        int groupId = question.getGroupId();
        com.cloudata.connector.importor.structs.Question newQuestion = new com.cloudata.connector.importor.structs.Question(surveyId, groupId, question.getQuestion(), QuestionType.typeOf(question.getType()));
        newQuestion.setLanguage(question.getLanguage());
        List<Answer> answers = question.getAnswers();
        List<com.cloudata.connector.importor.structs.Answer> newAnswers = new ArrayList<>();
        if (PURE_ANSWER_TYPES.contains(question.getType())) {
            com.cloudata.connector.importor.structs.Answer answer = null;
            for (Answer oldAnswer : answers) {
                answer = new com.cloudata.connector.importor.structs.Answer(oldAnswer.getAnswer());
                newAnswers.add(answer);
            }
        } else {
            MultipleChoiceAnswer answer = null;
            for (Answer oldAnswer : answers) {
                answer = new MultipleChoiceAnswer(oldAnswer.getAnswer());
                newAnswers.add(answer);
            }
        }

        newQuestion.setAnswers(newAnswers);

        return surveyManager.addQuestion(sessionKey, surveyId, groupId, newQuestion);
    }
}
