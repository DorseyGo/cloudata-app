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
import com.cloudata.connector.request.GetSessionKeyReqParams;
import com.cloudata.connector.response.GetSessionKeyResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A test for {@link ConnectManagerImpl}.
 *
 * Author: DORSEy
 */
public class ConnectManagerImplTest {
    private static final String URL = "http://clouddata.f3322.net:10080/akso/index.php/admin/remotecontrol";
    private static final String USERNAME = "yunshu";
    private static final String PASSWORD = "engine";

    private ConnectManagerImpl manager;

    @Before
    public void setUp() {
        HttpClientCreator clientCreator = new SimpleHttpClientCreator();
        HttpMethodCreator methodCreator = SimpleHttpMethodCreator.create(URL);
        ReqConnector connector = new ReqConnector(clientCreator, methodCreator);

        manager = new ConnectManagerImpl();
        manager.setConnector(connector);
    }

    @Test
    public void testGetSessionKey() throws CommandExecutionException {
        GetSessionKeyResponse response = manager.getSessionKey(new GetSessionKeyReqParams(USERNAME, PASSWORD));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSessionKey());
        System.out.println(response.getSessionKey());
    }
}
