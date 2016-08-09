/*
 * File name: ViewUtils
 * Author: Dorsey Q F TANG
 * Date: 8/5/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.converter;

import com.cloudata.connector.response.ListQuestionsResponse;
import com.cloudata.connector.response.ListSurveysResponse;
import com.cloudata.http.structs.Pagination;
import com.cloudata.http.view.AnswerDetailView;
import com.cloudata.http.view.QuestionDetailView;
import com.cloudata.http.view.SurveyDetailView;
import com.cloudata.persistent.bean.AnswerVO;
import com.cloudata.persistent.bean.QuestionVO;
import com.cloudata.persistent.bean.SurveyVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: DORSEy
 */
public final class ViewUtils {
    public static List<SurveyDetailView> copyOf(final ListSurveysResponse... responses) {
        if (responses == null || responses.length == 0) {
            return new ArrayList<>(0);
        }

        List<SurveyDetailView> views = new ArrayList<>(responses.length);
        for (ListSurveysResponse response : responses)
            views.add(copyOf(response));

        return views;
    }

    public static SurveyDetailView copyOf(final ListSurveysResponse response) {
        if (response == null)
            return null;

        int surveyId = response.getSurveyId();
        String surveyTitle = response.getSurveyTitle();
        String startDate = response.getStartDate();
        String expires = response.getExpires();
        String active = response.getActive();

        SurveyDetailView view = new SurveyDetailView();
        view.setSurveyId(surveyId);
        view.setSurveyTitle(surveyTitle);
        view.setStartDate(startDate);
        view.setExpired(expires);
        view.setActive(active);

        return view;
    }

    public static List<QuestionDetailView> copyOf(final ListQuestionsResponse... responses) {
        if (responses == null || responses.length == 0) {
            return new ArrayList<>(0);
        }

        List<QuestionDetailView> views = new ArrayList<>(responses.length);
        for (ListQuestionsResponse response : responses)
            views.add(copyOf(response));

        return views;
    }

    public static QuestionDetailView copyOf(final ListQuestionsResponse response) {
        if (response == null) {
            return null;
        }

        int questionId = response.getQuestionId();
        String question = response.getQuestion();
        int questionOrder = response.getQuestionOrder();
        String mandatory = response.getMandatory();
        int surveyId = response.getSurveyId();
        String type = response.getType();

        QuestionDetailView view = new QuestionDetailView();
        view.setSurveyId(surveyId);
        view.setQuestionId(questionId);
        view.setQuestion(question);
        view.setMandatory(mandatory);
        view.setQuestionOrder(questionOrder);
        view.setType(type);

        return view;
    }

    public static Pagination<SurveyDetailView> copyOf(final com.cloudata.persistent.structs.Pagination<SurveyVO> surveyModelPagination) {
        if (surveyModelPagination == null) {
            return null;
        }

        int currentPage = surveyModelPagination.getCurrentPage();
        int numRecords = surveyModelPagination.getTotalCount();
        List<SurveyVO> surveyVORecords = surveyModelPagination.getRecords();
        List<SurveyDetailView> records = copyOf(surveyVORecords.toArray(new SurveyVO[surveyVORecords.size()]));

        return new Pagination<>(currentPage, numRecords, records);
    }

    private static List<SurveyDetailView> copyOf(final SurveyVO... surveyVOs) {
        int len = -1;
        if (surveyVOs == null || (len = surveyVOs.length) == 0) {
            return new ArrayList<>(0);
        }

        List<SurveyDetailView> views = new ArrayList<>(len);
        for (SurveyVO model : surveyVOs)
            views.add(copyOf(model));

        return views;
    }

    public static SurveyDetailView copyOf(final SurveyVO model) {
        if (model == null) {
            return null;
        }

        int surveyId = model.getSurveyId();
        String expires = model.getExpires();
        String active = model.getActive();
        String startDate = model.getStartDate();
        String surveyTitle = model.getSurveyTitle();

        SurveyDetailView view = new SurveyDetailView();
        view.setSurveyId(surveyId);
        view.setSurveyTitle(surveyTitle);
        view.setStartDate(startDate);
        view.setExpired(expires);
        view.setActive(active);

        return view;
    }

    public static List<QuestionDetailView> copyOf(final QuestionVO... questionVOs) {
        int len = -1;
        if (questionVOs == null || (len = questionVOs.length) == 0)
            return new ArrayList<>(0);

        List<QuestionDetailView> views = new ArrayList<>(len);
        for (QuestionVO questionVO : questionVOs) {
            views.add(copyOf(questionVO));
        }

        return views;
    }

    public static QuestionDetailView copyOf(final QuestionVO questionVO) {
        if (questionVO == null)
            return null;

        int questionId = questionVO.getQuestionId();
        String question = questionVO.getQuestion();
        int questionOrder = questionVO.getQuestionOrder();
        String mandatory = questionVO.getMandatory();
        String type = questionVO.getType();
        List<AnswerVO> answerVOs = questionVO.getAnswerVOs();
        List<AnswerDetailView> answers = copyOf(answerVOs.toArray(new AnswerVO[answerVOs.size()]));

        QuestionDetailView view = new QuestionDetailView();
        view.setQuestionId(questionId);
        view.setQuestion(question);
        view.setQuestionOrder(questionOrder);
        view.setMandatory(mandatory);
        view.setType(type);
        view.setAnswers(answers);

        return view;
    }

    public static List<AnswerDetailView> copyOf(final AnswerVO... answerVOs) {
        int len = -1;
        if (answerVOs == null || (len = answerVOs.length) == 0)
            return new ArrayList<>(0);

        List<AnswerDetailView> views = new ArrayList<>(len);
        for (AnswerVO answerVO : answerVOs)
            views.add(copyOf(answerVO));

        return views;
    }

    public static AnswerDetailView copyOf(final AnswerVO answerVO) {
        if (answerVO == null)
            return null;

        int questionId = answerVO.getQuestionId();
        String answer = answerVO.getAnswer();
        int answerOrder = answerVO.getOrder();

        AnswerDetailView view = new AnswerDetailView(answer);
        view.setQuestionId(questionId);
        view.setAnswerOrder(answerOrder);

        return view;
    }
}
