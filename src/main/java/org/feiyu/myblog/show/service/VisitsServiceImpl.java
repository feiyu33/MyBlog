package org.feiyu.myblog.show.service;/**
 * Created by feiyu on 2016/11/22.
 */

import org.feiyu.myblog.admin.dao.VisitsDao;
import org.feiyu.myblog.admin.dao.VisitsHistoryDao;
import org.feiyu.myblog.admin.entity.Visits;
import org.feiyu.myblog.admin.entity.VisitsHistory;
import org.feiyu.myblog.common.util.IdGen;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author feiyu
 * @version 1.0
 * @title: VisitsServiceImpl
 * @description 展示模块浏览次数业务逻辑层实现类
 * @create 2016/11/22
 */
@Service("showVisits")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class VisitsServiceImpl implements VisitsService{

    @Resource
    private VisitsHistoryDao visitsHistoryDao;
    @Resource
    private VisitsDao visitsDao;

    public Map<String, Object> getVisits() throws Exception {

        int historyVisits = visitsHistoryDao.get();

        int visitCounts = visitsDao.getCounts(new java.sql.Date(new java.util.Date().getTime()));

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("historyVisits",historyVisits);
        map.put("visitCounts",visitCounts);
        return map;
    }

    public Boolean upDateVisits() throws Exception {
        //获取历史浏览量
        VisitsHistory visitsHistory = visitsHistoryDao.getVisitsHistory();
        if(visitsHistory == null){
            VisitsHistory visitsHistory1 = new VisitsHistory(IdGen.uuId(),0);
            visitsHistoryDao.add(visitsHistory1);
        }
        int rows = visitsHistoryDao.update();
        //获取当前日期浏览量
        Visits visits = visitsDao.get(new java.sql.Date(new java.util.Date().getTime()));
        if(visits == null){
            Visits visits1 = new Visits(IdGen.uuId(), new java.sql.Date(new java.util.Date().getTime()),0);
            visitsDao.add(visits1);
        }
        int rows1 = visitsDao.update(new java.sql.Date(new java.util.Date().getTime()));
        if (rows == 1 && rows1 == 1){
            return true;
        }
        return false;
    }
}