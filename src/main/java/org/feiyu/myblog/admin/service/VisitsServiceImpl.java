package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/26.
 */

import org.feiyu.myblog.admin.dao.VisitsDao;
import org.feiyu.myblog.admin.entity.Visits;
import org.feiyu.myblog.common.util.IdGen;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author feiyu
 * @version 1.0
 * @title: VisitsServiceImpl
 * @description 访问次数业务逻辑层实现类
 * @create 2016/10/26
 */
@Service("visitsService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class VisitsServiceImpl  implements VisitsService{

    @Resource
    private VisitsDao visitsDao;

    public boolean add() throws Exception {
        Visits visits = new Visits(IdGen.uuId(), new java.sql.Date(new java.util.Date().getTime()),0);
        int rows = visitsDao.add(visits);
        return rows == 1 ? true : false;
    }

    public int getCounts() throws Exception {
        return visitsDao.getCounts(new java.sql.Date(new java.util.Date().getTime()));
    }

    public boolean update() throws Exception {
        int rows = visitsDao.update(new java.sql.Date(new java.util.Date().getTime()));
        return rows == 1 ? true : false;
    }

    public Visits get() throws Exception {
        return visitsDao.get(new java.sql.Date(new java.util.Date().getTime()));
    }
}
