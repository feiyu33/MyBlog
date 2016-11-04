package org.feiyu.myblog.admin.po;/**
 * Created by feiyu on 2016/11/3.
 */

import org.feiyu.myblog.admin.entity.DictEntity;

/**
 * @author feiyu
 * @version 1.0
 * @title: ClassificationPO
 * @description 分类业务员实体
 * @create 2016/11/3
 */
public class ClassificationPO {

    /**博文数量**/
    private int blogCounts;
    /**数据字典实体类**/
    private DictEntity dictEntity;

    public int getBlogCounts() {
        return blogCounts;
    }

    public void setBlogCounts(int blogCounts) {
        this.blogCounts = blogCounts;
    }

    public DictEntity getDictEntity() {
        return dictEntity;
    }

    public void setDictEntity(DictEntity dictEntity) {
        this.dictEntity = dictEntity;
    }

    @Override
    public String toString() {
        return "ClassificationPO{" +
                "blogCounts=" + blogCounts +
                ", dictEntity=" + dictEntity +
                '}';
    }
}
