package org.feiyu.myblog.admin.dao;/**
 * Created by feiyu on 2016/11/3.
 */

import org.feiyu.myblog.admin.entity.DictEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: DictEntityDao
 * @description 数据字典数据库访问接口
 * @create 2016/11/3
 */
@Repository("dictEntityDao")
public interface DictEntityDao {
    
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
