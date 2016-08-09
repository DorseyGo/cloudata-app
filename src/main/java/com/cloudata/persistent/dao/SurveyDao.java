/*
 * File name: SurveyDao
 * Author: Dorsey Q F TANG
 * Date: 8/6/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.dao;

import com.cloudata.persistent.bean.SurveyVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: DORSEy
 */
@Repository("surveyDao")
public interface SurveyDao extends BasicDao {
    List<SurveyVO> listSurveys(@Param("offset") final int offset, @Param("limit") final int limit, @Param("owner") final String owner);

    int count(@Param("owner") final String owner);

    SurveyVO querySurveyById(@Param("surveyId") final int surveyId);
}
