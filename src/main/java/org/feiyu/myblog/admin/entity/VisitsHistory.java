package org.feiyu.myblog.admin.entity;/**
 * Created by feiyu on 2016/10/29.
 */

/**
 * @author feiyu
 * @version 1.0
 * @title: VisitsHistory
 * @description 历史访问次数实体类
 * @create 2016/10/29
 */
public class VisitsHistory {

    /**id**/
    public String id;

    /**历史访问次数**/
    public int visitsHistoryCounts;

    public VisitsHistory(){}

    public VisitsHistory(String id, int visitsHistoryCounts) {
        this.id = id;
        this.visitsHistoryCounts = visitsHistoryCounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVisitsHistoryCounts() {
        return visitsHistoryCounts;
    }

    public void setVisitsHistoryCounts(int visitsHistoryCounts) {
        this.visitsHistoryCounts = visitsHistoryCounts;
    }

    @Override
    public String toString() {
        return "VisitsHistory{" +
                "id='" + id + '\'' +
                ", visitsHistoryCounts=" + visitsHistoryCounts +
                '}';
    }
}
