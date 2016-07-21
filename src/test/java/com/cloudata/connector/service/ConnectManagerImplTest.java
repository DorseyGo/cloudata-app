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
import com.cloudata.connector.request.*;
import com.cloudata.connector.response.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        final String SURVEY_TITLE = "refactor API test01";
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
