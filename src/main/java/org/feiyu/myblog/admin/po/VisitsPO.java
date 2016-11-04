package org.feiyu.myblog.admin.po;/**
 * Created by feiyu on 2016/10/30.
 */

import org.feiyu.myblog.admin.entity.Visits;
import org.feiyu.myblog.admin.entity.VisitsHistory;

/**
 * @author feiyu
 * @version 1.0
 * @title: VisitsPO
 * @description 访问次数业务类
 * @create 2016/10/30
 */
public class VisitsPO {

    /**当前日期访问次数实体类**/
    private Visits visits;

    /**历史访问次数实体类**/
    private VisitsHistory visitsHistory;

    public VisitsPO(){}

    public VisitsPO(Visits visits, VisitsHistory visitsHistory) {
        this.visits = visits;
        this.visitsHistory = visitsHistory;
    }

    public Visits getVisits() {
        return visits;
    }

    public void setVisits(Visits visits) {
        this.visits = visits;
    }

    public VisitsHistory getVisitsHistory() {
        return visitsHistory;
    }

    public void setVisitsHistory(VisitsHistory visitsHistory) {
        this.visitsHistory = visitsHistory;
    }

    @Override
    public String toString() {
        return "VisitsPO{" +
                "visits=" + visits +
                ", visitsHistory=" + visitsHistory +
                '}';
    }
}
