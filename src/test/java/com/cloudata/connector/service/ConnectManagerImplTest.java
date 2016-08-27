/*
 * File name: ConnectManagerImplTest
 * Author: Dorsey Q F TANG
 * Date: 7/17/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.connector.service;

import com.cloudata.connector.ReqConnector;
import com.cloudata.connector.creator.HttpClientCreator;
import com.cloudata.connector.creator.HttpMethodCreator;
import com.cloudata.connector.creator.impl.SimpleHttpClientCreator;
import com.cloudata.connector.creator.impl.SimpleHttpMethodCreator;
import com.cloudata.connector.exception.CommandExecutionException;
import com.cloudata.connector.importor.QuestionGenerator;
import com.cloudata.connector.importor.QuestionGeneratorFactory;
import com.cloudata.connector.importor.structs.Answer;
import com.cloudata.connector.importor.structs.MultipleChoiceAnswer;
import com.cloudata.connector.importor.structs.Question;
import com.cloudata.connector.request.*;
import com.cloudata.connector.response.*;
import com.cloudata.connector.structs.QuestionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * A test for {@link ConnectManagerImpl}.
 * <p>
 * Author: DORSEy
 */
public class ConnectManagerImplTest {
    private static final String URL = "http://clouddata.f3322.net:10080/akso/index.php/admin/remotecontrol";
    private static final String USERNAME = "yunshu";
    private static final String PASSWORD = "engine";

    private ConnectManagerImpl manager;

    private String sesionKey;

    @Before
    public void setUp() {
        HttpClientCreator clientCreator = new SimpleHttpClientCreator();
        HttpMethodCreator methodCreator = SimpleHttpMethodCreator.create(URL);
        ReqConnector connector = new ReqConnector(clientCreator, methodCreator);

        manager = new ConnectManagerImpl();
        manager.setConnector(connector);

        try {
            GetSessionKeyResponse response = manager.getSessionKey(new GetSessionKeyReqParams(USERNAME, PASSWORD));
            sesionKey = response.getSessionKey();
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testGetSessionKey() throws CommandExecutionException {
        GetSessionKeyResponse response = manager.getSessionKey(new GetSessionKeyReqParams(USERNAME, PASSWORD));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSessionKey());
        System.out.println(response.getSessionKey());
    }

    @Test
    public void testReleaseSessionKey() {
        try {
            boolean ret = manager.releaseSessionKey(new ReleaseSessionKeyReqParams(sesionKey));
            Assert.assertTrue(ret);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }
    }

    @Test
    public void testListSurveys() {
        List<ListSurveysResponse> responses = null;
        try {
            responses = manager.listSurveys(new ListSurveysReqParams(sesionKey));
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertNotNull(responses);
        for (ListSurveysResponse child : responses) {
            System.out.println(child);
        }
    }

    @Test
    public void testAddSurvey() {
        final String SURVEY_TITLE = "refactor API test04";
        final String SURVEY_LANGUAGE = "en";

        AddSurveyResponse response = null;
        try {
            response = manager.addSurvey(new AddSurveyReqParams(sesionKey, SURVEY_TITLE, SURVEY_LANGUAGE));
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertTrue(response != null);
        Assert.assertTrue(response.getSurveyId() > 0);
        System.out.println(response.getSurveyId());
    }

    @Test
    public void testDeleteSurvey() {
        final String SURVEY_TITLE = "test for deletion";
        final String SURVEY_LANGUAGE = "en";

        AddSurveyResponse addSurveyResponse = null;
        try {
            addSurveyResponse = manager.addSurvey(new AddSurveyReqParams(sesionKey, SURVEY_TITLE, SURVEY_LANGUAGE));
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertNotNull(addSurveyResponse);
        int surveyId = addSurveyResponse.getSurveyId();

        boolean ret = false;
        try {
            ret = manager.deleteSurvey(new DeleteSurveyReqParams(sesionKey, surveyId));
            Assert.assertTrue(ret);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

    }

    @Test
    public void testGetSurveyProperties() {
        int surveyId = getSurveyId();
        List<String> propKeys = new LinkedList<>();
        propKeys.add("sid");
        propKeys.add("faxto");
        propKeys.add("surveyls_title");

        GetOrSetPropertiesResponse getOrSetPropertiesResponse = null;
        try {
            getOrSetPropertiesResponse = manager.getSurveyProperties(new GetSurveyPropertiesReqParams(sesionKey, surveyId, propKeys));
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertNotNull(getOrSetPropertiesResponse);
        Map<String, Object> props = getOrSetPropertiesResponse.getProps();
        System.out.println(props);

        // recycle
        deleteSurvey(surveyId);
    }

    @Test
    public void testSetSurveyProperties() {
        int surveyId = getSurveyId();
        Map<String, Object> settings = new HashMap<>();
        settings.put("faxto", "124@126.com");

        try {
            boolean succeed = manager.setSurveyProperties(new SetSurveyPropertiesReqParams(sesionKey, surveyId, settings));
            Assert.assertTrue(succeed);
        } catch (CommandExecutionException e) {
            Assert.assertTrue(false);
        }

        // recycle
        deleteSurvey(surveyId);
    }

    @Test
    public void testListQuestions() {
        final int SURVEY_ID = 818388;

        List<ListQuestionsResponse> responses = null;
        try {
            responses = manager.listQuestions(new ListQuestionsReqParams(sesionKey, SURVEY_ID));
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertTrue(false);
        }

        Assert.assertTrue(responses != null);
        System.out.println(responses);
    }

    @Test
    public void testListGroups() {
        final int SURVEY_ID = 818388;

        List<ListGroupsResponse> groupsResponses = null;
        try {
            groupsResponses = manager.listGroups(new ListGroupsReqParams(sesionKey, SURVEY_ID));
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertNotNull(groupsResponses);
        for (ListGroupsResponse child : groupsResponses)
            System.out.println(child);
    }

    @Test
    public void testImportSingleChoiceQuestion() {
        // should be passed in when create a single-choice question
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;

        String importData = generate(SURVEY_ID, GROUP_ID);

        ImportQuestionResponse response = null;
        ImportQuestionReqParams reqParams = new ImportQuestionReqParams(sesionKey, SURVEY_ID, GROUP_ID, importData);
        try {
            response = manager.importQuestion(reqParams);
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getQuestionId() > 0);
        System.out.println(response.getQuestionId());
    }

    private String generate(final int surveyId, final int groupId) {
        Question question = new Question(surveyId, groupId, "Is this a single-choice question?", QuestionType.SINGLE_CHOICE);
        List<Answer> answers = new ArrayList<>();
        Answer answer = new Answer("Yes", "A01");
        answers.add(answer);

        answer = new Answer("No", "A02");
        answers.add(answer);

        question.setAnswers(answers);
        question.setLanguage("en");

        String importData = null;
        QuestionGenerator generator = QuestionGeneratorFactory.getFactory().get(question.getType());
        try {
            importData = generator.generate(question);
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.assertTrue(false);
        }


        return importData;
    }

    @Test
    public void testImportMultipleChoiceQuestion() {
        // should be passed in when create a single-choice question
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;

        String importData = generateMultipleQuestionData(SURVEY_ID, GROUP_ID);

        ImportQuestionResponse response = null;
        ImportQuestionReqParams reqParams = new ImportQuestionReqParams(sesionKey, SURVEY_ID, GROUP_ID, importData);
        try {
            response = manager.importQuestion(reqParams);
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getQuestionId() > 0);
        System.out.println(response.getQuestionId());
    }

    private String generateMultipleQuestionData(final int surveyId, final int groupId) {
        Question question = new Question(surveyId, groupId, "Is this a mutliple choice question?", QuestionType.MULTIPLE_CHOICES);
        List<Answer> answers = new ArrayList<>();
        Answer answer = new MultipleChoiceAnswer("Yes", "A01");
        answers.add(answer);

        answer = new MultipleChoiceAnswer("No", "A02");
        answers.add(answer);

        question.setLanguage("en");
        question.setAnswers(answers);

        String importData = null;
        QuestionGenerator generator = QuestionGeneratorFactory.getFactory().get(question.getType());
        try {
            importData = generator.generate(question);
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        return importData;
    }

    @Test
    public void testImport5PointsQuestion() {
        // should be passed in when create a single-choice question
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;

        Question fivePointsQuestion = new Question(SURVEY_ID, GROUP_ID, "Is this 5 points question?", QuestionType.FIVE_POINTS);
        fivePointsQuestion.setLanguage("en");
        String importData = null;
        QuestionGenerator generator = QuestionGeneratorFactory.getFactory().get(fivePointsQuestion.getType());
        try {
            importData = generator.generate(fivePointsQuestion);
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        // import the question
        ImportQuestionReqParams reqParams = new ImportQuestionReqParams(sesionKey, SURVEY_ID, GROUP_ID, importData);
        ImportQuestionResponse response = null;
        try {
            response = manager.importQuestion(reqParams);
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertTrue(false);
        }

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getQuestionId() > 0);
        System.out.println(response.getQuestionId());
    }

    @Test
    public void testImportSingleChoiceWithCommentsQuestion() {
        // should be passed in when create a single-choice question
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;

        String importData = generateSingleChoiceWithComments(SURVEY_ID, GROUP_ID);
        ImportQuestionReqParams reqParams = new ImportQuestionReqParams(sesionKey, SURVEY_ID, GROUP_ID, importData);
        ImportQuestionResponse response = null;
        try {
            response = manager.importQuestion(reqParams);
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertTrue(false);
        }

        Assert.assertTrue(response != null);
        Assert.assertTrue(response.getQuestionId() > 0);
        System.out.println(response.getQuestionId());
    }

    private String generateSingleChoiceWithComments(final int surveyId, final int groupId) {
        Question sccQuestion = new Question(surveyId, groupId, "Is this a single choice question with comments?",QuestionType.SINGLE_CHOICE_WITH_COMMENT);
        List<Answer> answers = new LinkedList<>();
        Answer answer = new Answer("Yes");
        answers.add(answer);

        answer = new Answer("No");
        answers.add(answer);

        sccQuestion.setLanguage("en");
        sccQuestion.setAnswers(answers);

        String importData = null;
        QuestionGenerator generator = QuestionGeneratorFactory.getFactory().get(sccQuestion.getType());
        try {
            importData = generator.generate(sccQuestion);
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        return importData;
    }

    @Test
    public void testMatrixYesUncertainNoQuestion() {
        // should be passed in when create a single-choice question
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;

        String importData = generateMatrix(SURVEY_ID, GROUP_ID);
        ImportQuestionReqParams reqParams = new ImportQuestionReqParams(sesionKey, SURVEY_ID, GROUP_ID, importData);
        ImportQuestionResponse response = null;
        try {
            response = manager.importQuestion(reqParams);
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertTrue(false);
        }

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getQuestionId() > 0);
        System.out.println(response.getQuestionId());
    }

    private String generateMatrix(final int surveyId, final int groupId) {
        Question question = new Question(surveyId, groupId, "Is this a matrix question for yes, uncertain, no?", QuestionType.MATRIX_YES_UNCERTAIN_NO);
        List<Answer> answers = new LinkedList<>();
        Answer answer = new MultipleChoiceAnswer("Manager is good?");
        answers.add(answer);

        answer = new MultipleChoiceAnswer("Environment is good?");
        answers.add(answer);

        question.setAnswers(answers);
        question.setLanguage("en");

        String importData = null;
        QuestionGenerator generator = QuestionGeneratorFactory.getFactory().get(question.getType());
        try {
            importData = generator.generate(question);
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        return importData;
    }

    @Test
    public void testImportMultipleChoicesWithCommentQuestion() {
        // should be passed in when create a single-choice question
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;

        String importData = generateMultiQuestionWithComments(SURVEY_ID, GROUP_ID);
        ImportQuestionResponse response = null;
        ImportQuestionReqParams reqParams = new ImportQuestionReqParams(sesionKey, SURVEY_ID, GROUP_ID, importData);
        try {
            response = manager.importQuestion(reqParams);
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertTrue(false);
        }

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getQuestionId() > 0);
        System.out.println(response.getQuestionId());
    }

    private String generateMultiQuestionWithComments(final int surveyId, final int groupId) {
        Question question = new Question(surveyId, groupId, "Is this a multiple choices question with comments?", QuestionType.MULTIPLE_CHOICES_WITH_COMMENT);
        List<Answer> answers = new LinkedList<>();
        Answer answer = new MultipleChoiceAnswer("Yes");
        answers.add(answer);

        answer = new MultipleChoiceAnswer("Uncertain");
        answers.add(answer);

        answer = new MultipleChoiceAnswer("No");
        answers.add(answer);

        question.setLanguage("en");
        question.setAnswers(answers);

        String importData = null;
        QuestionGenerator generator = QuestionGeneratorFactory.getFactory().get(question.getType());
        try {
            importData = generator.generate(question);
            Assert.assertTrue(true);
        } catch (IOException e) {
            Assert.assertTrue(false);
        }

        return importData;
    }

    private void deleteSurvey(final int surveyId) {
        try {
            boolean succeed = manager.deleteSurvey(new DeleteSurveyReqParams(sesionKey, surveyId));
            Assert.assertTrue(succeed);
        } catch (CommandExecutionException e) {
            Assert.assertTrue(false);
        }
    }

    private int getSurveyId() {
        final String SURVEY_TITLE = "test for deletion1";
        final String SURVEY_LANGUAGE = "en";

        AddSurveyResponse addSurveyResponse = null;
        try {
            addSurveyResponse = manager.addSurvey(new AddSurveyReqParams(sesionKey, SURVEY_TITLE, SURVEY_LANGUAGE));
            Assert.assertTrue(true);
        } catch (CommandExecutionException e) {
            Assert.assertFalse(true);
        }

        Assert.assertNotNull(addSurveyResponse);
        int surveyId = addSurveyResponse.getSurveyId();

        return surveyId;
    }
}
