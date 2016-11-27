package org.feiyu.myblog.admin.dao;/**
 * Created by feiyu on 2016/10/30.
 */

import org.apache.ibatis.annotations.Param;
import org.feiyu.myblog.admin.entity.VisitsHistory;
import org.springframework.stereotype.Repository;

/**
 * @author feiyu
 * @version 1.0
 * @Title: VisitsHistoryDao
 * @description 历史访问数数据库访问层接口
 * @create 2016/10/30
 */
@Repository("visitsHistoryDao")
public interface VisitsHistoryDao {

    /**
     * @title: add
     * Create By feiyu
     * @description: 新增一条历史访问次数记录
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: int 受影响行数
     */
    int add(@Param("vHistory")VisitsHistory visitsHistory);

    /**
     * @title: update
     * Create By feiyu
     * @description: 更新历史访问次数
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: int 受影响行数
    */
    int update();

    /**
     * @title: get
     * Create By feiyu
     * @description: 得到历史浏览次数
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: int 历史浏览次数
     */
    int get();

    /**
     * @title: getVisitsHistory
     * Create By feiyu
     * @description: 得到历史浏览实体
     * @params:  * @param null
     * @Date: 2016/11/21
     * @return:
     */
    VisitsHistory getVisitsHistory();
}
