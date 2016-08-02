/*
 * File name: SurveyManagerImpl
 * Author: Dorsey Q F TANG
 * Date: 8/2/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.http.service.impl;

import com.cloudata.connector.service.ConnectManager;
import com.cloudata.http.service.SurveyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: DORSEy
 */
@Service("surveyManager")
public class SurveyManagerImpl implements SurveyManager {

    @Autowired
    private ConnectManager connectManager;

    /**
     * A cache to buffer username/sessionkey pair.
     */
    private static Map<String, String> sessionKeyCache = new ConcurrentHashMap<>();
}
