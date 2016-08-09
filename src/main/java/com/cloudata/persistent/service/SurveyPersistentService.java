/*
 * File name: SurveyPersistentService
 * Author: Dorsey Q F TANG
 * Date: 8/6/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.service;

import com.cloudata.persistent.bean.QuestionVO;
import com.cloudata.persistent.bean.SurveyVO;
import com.cloudata.persistent.structs.Pagination;

import java.util.List;

/**
 * Author: DORSEy
 */
public interface SurveyPersistentService {
    List<SurveyVO> listSurveys(final int offset, final int limit, final String owner);

    int count(final String owner);

    Pagination<SurveyVO> paginate(final int currentPage, final int pageSize, final String owner);

    SurveyVO queryForSurvey(final int surveyId);

    List<QuestionVO> queryForQuestions(final int surveyId);
}
