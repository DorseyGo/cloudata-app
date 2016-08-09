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
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author: DORSEy
 */
@Repository("questionDao")
public interface QuestionDao extends BasicDao {
    List<QuestionVO> listQuestions(@PathVariable("surveyId") final int surveyId);
}
