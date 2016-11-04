package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/26.
 */

import org.feiyu.myblog.admin.entity.Visits;

import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @Title: VisitsService
 * @description 访问次数业务逻辑层接口
 * @create 2016/10/26
 */
public interface VisitsService {

    /**
     * @title: add
     * Create By feiyu
     * @description: 添加当前日期和历史访问次数
     * @params:  * @param date 当前时间
     * @Date: 2016/10/26
     * @return: 是否添加成功
     */
    boolean add() throws Exception;
    
    /**
     * @title: getCounts
     * Create By feiyu
     * @description: 获取当前日期访问次数
     * @params:  * @param null
     * @Date: 2016/10/26
     * @return: visits
     */
    int getCounts() throws Exception;

    /**
     * @title: update
     * Create By feiyu
     * @description: 修改当前日期的浏览量(+1)
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: boolean 是否更新成功
     */
    boolean update() throws Exception;


}
