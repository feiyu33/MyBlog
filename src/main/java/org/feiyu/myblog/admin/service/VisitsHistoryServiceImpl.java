package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/30.
 */

import org.feiyu.myblog.admin.dao.VisitsHistoryDao;
import org.feiyu.myblog.admin.entity.VisitsHistory;
import org.feiyu.myblog.common.util.IdGen;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author feiyu
 * @version 1.0
 * @title: VisitsHistoryServiceImpl
 * @description 历史访问次数业务逻辑层实现类
 * @create 2016/10/30
 */
@Service("visitsHistoryService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class VisitsHistoryServiceImpl implements VisitsHistoryService{

    @Resource
    private VisitsHistoryDao visitsHistoryDao;

    public boolean add() {
        VisitsHistory visitsHistory = new VisitsHistory(IdGen.uuId(),0);
        int rows = visitsHistoryDao.add(visitsHistory);
        if(rows == 1){
            return true;
        }
        return false;
    }

    public boolean update() {
        int rows = visitsHistoryDao.update();
        if(rows == 1){
            return true;
        }
        return false;
    }

    public int get() {
        return visitsHistoryDao.get();
    }
}
