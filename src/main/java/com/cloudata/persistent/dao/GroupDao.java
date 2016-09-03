/*
 * File name: GroupDao
 * Author: Dorsey Q F TANG
 * Date: 9/3/16
 * -----------------------------------------------------
 * Description: 
 * -----------------------------------------------------
 */

package com.cloudata.persistent.dao;

import com.cloudata.persistent.bean.GroupEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: DORSEy
 */
@Repository("groupDao")
public interface GroupDao extends BasicDao {
    List<GroupEntity> listGroups(@Param("surveyId") final int surveyId, @Param("offset") final int offset, @Param("pageSize") final int pageSize);

    int countGroups(@Param("surveyId") final int surveyId);
}
