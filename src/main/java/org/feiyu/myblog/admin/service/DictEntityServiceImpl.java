package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/11/4.
 */

import org.feiyu.myblog.admin.dao.DictEntityDao;
import org.feiyu.myblog.admin.entity.DictEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @title: DictEntityServiceImpl
 * @description 数据字典业务逻辑层实现类
 * @create 2016/11/4
 */
@Service("dictEntityService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class DictEntityServiceImpl implements DictEntityService{

    @Resource
    private DictEntityDao dictEntityDao;

    public List<DictEntity> getListByType(String type) {
        return dictEntityDao.getListByType(type);
    }

    public DictEntity getByValue(String value) {
        return dictEntityDao.getByValue(value);
    }
}
