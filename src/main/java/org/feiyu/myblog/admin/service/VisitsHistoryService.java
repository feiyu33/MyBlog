package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/30.
 */

/**
 * @author feiyu
 * @version 1.0
 * @Title: VisitsHistoryService
 * @description 历史访问次数业务逻辑层接口
 * @create 2016/10/30
 */
public interface VisitsHistoryService {

    /**
     * @title: add
     * Create By feiyu
     * @description: 添加一条历史访问次数记录
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: boolean 是否添加成功
     */
    boolean add();

    /**
     * @title: update
     * Create By feiyu
     * @description: 更新历史访问次数（+1）
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: boolean 是否更新成功
     */
    boolean update();

    /**
     * @title: get
     * Create By feiyu
     * @description: 获取历史访问次数
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: int 历史访问次数
     */
    int get();
}
