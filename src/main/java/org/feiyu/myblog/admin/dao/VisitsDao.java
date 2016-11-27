package org.feiyu.myblog.admin.dao;/**
 * Created by feiyu on 2016/10/26.
 */

import org.apache.ibatis.annotations.Param;
import org.feiyu.myblog.admin.entity.Visits;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @Title: VisitsDao
 * @description 访问数数据库访问接口
 * @create 2016/10/26
 */
@Repository("visitsDao")
public interface VisitsDao {

    /**
     * @title: add
     * Create By feiyu
     * @description: 新增当前日期的浏览量记录
     * @params:  * @param null
     * @Date: 2016/10/26
     * @return: int 被影响行数
     */
    int add(@Param("visits") Visits visits);

    /**
     * @title: get
     * Create By feiyu
     * @description: 获取当前日期的浏览次数
     * @params:  * @param null
     * @Date: 2016/10/26
     * @return: visits
     */
    int getCounts(Date date);

    /**
     * @title: update
     * Create By feiyu
     * @description: 修改当前日期的浏览量
     * @params:  * @param date
     * @Date: 2016/10/30
     * @return: int 受影响行数
     */
    int update(Date date);

    /**
     * @title: get
     * Create By feiyu
     * @description: 得到浏览实体
     * @params:  * @param date
     * @Date: 2016/11/21
     * @return:
     */
    Visits get(Date date);
}
