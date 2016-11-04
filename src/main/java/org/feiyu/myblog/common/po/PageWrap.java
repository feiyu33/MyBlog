package org.feiyu.myblog.common.po;/**
 * Created by feiyu on 2016/10/25.
 */

import org.feiyu.myblog.common.util.SystemConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @title: PageWrap
 * @description 分页工具类
 * @create 2016/10/25
 */
public class PageWrap<T> {

    /**当前页**/
    private int currentPage;

    /**总页数**/
    private int totalPages;
    
    /**总记录数**/
    private int counts;
    
    /**数据**/
    private List<T> data;

    private static int PAGE_NUMBER = Integer.parseInt(SystemConfig.getConfig("page.number"));

    public PageWrap(){}

    public PageWrap(int currentPage, int totalPages, int counts, List<T> data) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.counts = counts;
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
        totalPages = (int)(counts % PAGE_NUMBER) == 0 ?
                (int)(counts / PAGE_NUMBER) : (int)(counts/ PAGE_NUMBER + 1);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageWrap{" +
                "currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", counts=" + counts +
                ", data=" + data +
                '}';
    }
}
