/*
 * File name: SurveyPersistentServiceImpl
 * Author: Dorsey Q F TANG
 * Date: 8/6/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.service.impl;

import com.cloudata.persistent.bean.SurveyModel;
import com.cloudata.persistent.dao.SurveyDao;
import com.cloudata.persistent.service.SurveyPersistentService;
import com.cloudata.persistent.structs.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: DORSEy
 */
public class SurveyPersistentServiceImpl implements SurveyPersistentService {

    @Autowired
    private SurveyDao surveyDao;

    @Override
    public List<SurveyModel> listSurveys(int offset, int limit, String owner) {
        return surveyDao.listSurveys(offset, limit, owner);
    }

    @Override
    public int count(String owner) {
        return surveyDao.count(owner);
    }

    @Override
    public Pagination<SurveyModel> paginate(final int currentPage, final int pageSize, final String owner) {
        int offset = (currentPage - 1) * pageSize;
        int totalCount = count(owner);
        List<SurveyModel> surveys = listSurveys(offset, pageSize, owner);

        return new Pagination<>(currentPage, totalCount, surveys);
    }

}
