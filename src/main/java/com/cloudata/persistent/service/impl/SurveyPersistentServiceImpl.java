/*
 * File name: SurveyPersistentServiceImpl
 * Author: Dorsey Q F TANG
 * Date: 8/6/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.service.impl;

import com.cloudata.persistent.bean.QuestionVO;
import com.cloudata.persistent.bean.SurveyVO;
import com.cloudata.persistent.dao.QuestionDao;
import com.cloudata.persistent.dao.SurveyDao;
import com.cloudata.persistent.service.SurveyPersistentService;
import com.cloudata.persistent.structs.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: DORSEy
 */
public class SurveyPersistentServiceImpl implements SurveyPersistentService {

    @Autowired
    private SurveyDao surveyDao;

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<SurveyVO> listSurveys(int offset, int limit, String owner) {
        return surveyDao.listSurveys(offset, limit, owner);
    }

    @Override
    public int count(String owner) {
        return surveyDao.count(owner);
    }

    @Override
    public Pagination<SurveyVO> paginate(final int currentPage, final int pageSize, final String owner) {
        int offset = (currentPage - 1) * pageSize;
        int totalCount = count(owner);
        List<SurveyVO> surveys = listSurveys(offset, pageSize, owner);

        return new Pagination<>(currentPage, totalCount, surveys);
    }

    @Override
    public List<QuestionVO> queryForQuestions(final int surveyId) {
        return questionDao.listQuestions(surveyId);
    }

    @Override
    public SurveyVO queryForSurvey(final int surveyId) {
        return surveyDao.querySurveyById(surveyId);
    }
}
