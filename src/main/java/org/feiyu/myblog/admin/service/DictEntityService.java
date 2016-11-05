package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/11/4.
 */

import org.feiyu.myblog.admin.entity.DictEntity;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: DictEntityService
 * @description 数据字典业务逻辑层接口
 * @create 2016/11/4
 */
public interface DictEntityService {

    /**
     * @title: getListByType
     * Create By feiyu
     * @description: 通过类型获取数据字典列表
     * @params:  * @param type 类型
     * @Date: 2016/11/3
     * @return: list
     */
    List<DictEntity> getListByType(String type);

    /**
     * @title: getByValue
     * Create By feiyu
     * @description: 通过值获取字典实体
     * @params:  * @param value 字典值
     * @Date: 2016/11/3
     * @return: dicEntity
     */
    DictEntity getByValue(String value);
}
