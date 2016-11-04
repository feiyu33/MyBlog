package org.feiyu.myblog.admin.entity;/**
 * Created by feiyu on 2016/10/25.
 */

import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @title: Visits
 * @description 用户访问次数实体类
 * @create 2016/10/25
 */
public class Visits {
    
    /**id**/
    private String id;
    
    /**访问时间**/
    private Date visitDate;
    
    /**当日访问次数**/
    private int visitDateCounts;


    public Visits(){}

    public Visits(String id, Date visitDate, int visitDateCounts) {
        this.id = id;
        this.visitDate = visitDate;
        this.visitDateCounts = visitDateCounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public int getVisitDateCounts() {
        return visitDateCounts;
    }

    public void setVisitDateCounts(int visitDateCounts) {
        this.visitDateCounts = visitDateCounts;
    }


    @Override
    public String toString() {
        return "Visits{" +
                "id='" + id + '\'' +
                ", visitDate=" + visitDate +
                ", visitDateCounts=" + visitDateCounts +
                '}';
    }
}
