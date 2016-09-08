/*
 * File name: QuestionDao
 * Author: Dorsey Q F TANG
 * Date: 8/8/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.dao;

import com.cloudata.persistent.bean.QuestionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: DORSEy
 */
@Repository("questionDao")
public interface QuestionDao extends BasicDao {
    List<QuestionVO> listQuestions(@Param("surveyId") final int surveyId, @Param("groupId") final int groupId);
}
