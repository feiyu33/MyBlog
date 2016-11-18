package org.feiyu.myblog.admin.dao;/**
 * Created by feiyu on 2016/10/29.
 */

import org.apache.ibatis.annotations.Param;
import org.feiyu.myblog.admin.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: BlogDao
 * @description 博文数据库访问层接口
 * @create 2016/10/29
 */
@Repository("blogDao")
public interface BlogDao {

    /**
     * @title: add
     * Create By feiyu
     * @description: 新增博文
     * @params:  * @param blog
     * @Date: 2016/10/29
     * @return: int 受影响行数
     */
    int add(@Param("blog") Blog blog);

    /**
     * @title: delete
     * Create By feiyu
     * @description: 删除博文
     * @params:  * @param bid 博文id
     * @Date: 2016/10/29
     * @return: int 受影响行数
     */
    int delete(@Param("bid") String bid,@Param("notRead") int notRead);
    
    /**
     * @title: getListByPage
     * Create By feiyu
     * @description: 分页查询博文(以时间排序)
     * @params:  * @param currentPage 当前页
     * @param pageNumber 每页显示条数
     * @param isRead 是否可读
     * @Date: 2016/10/29
     * @return: list 数据集合
     */
    List<Blog> getNewListByPage(@Param("currentPage") int currentPage, @Param("pageNumber") int pageNumber,
                                @Param("isRead")int isRead,@Param("isDraft") int isDraft);

    /**
     * @title: getHotListByPage
     * Create By feiyu
     * @description: 分页查询博文（以浏览量排序）
     * @params:  * @param currentPage 当前页
     * @param pageNumber 每页显示条数
     * @param isRead 是否可读
     * @Date: 2016/11/15
     * @return: list 数据集合
     */
    List<Blog> getHotListByPage(@Param("currentPage") int currentPage, @Param("pageNumber") int pageNumber,
                                @Param("isRead")int isRead,@Param("isDraft") int isDraft);
    /**
     * @title: update
     * Create By feiyu
     * @description: 修改博文内容
     * @params:  * @param blog
     * @Date: 2016/10/29
     * @return: int 受影响行数
     */
    int update(@Param("blog") Blog blog);

    /**
     * @title: addReadCounts
     * Create By feiyu
     * @description: 添加当前博文阅读次数
     * @params:  * @param bid
     * @Date: 2016/10/29
     * @return: int 受影响行数
     */
    int addReadCounts(String bid);

    /**
     * @title: addThumbUpCounts
     * Create By feiyu
     * @description: 增加当前博文点赞数
     * @params:  * @param bid
     * @Date: 2016/10/29
     * @return: int 受影响行数
     */
    int addThumbUpCounts(String bid);

    /**
     * @title: getTotalCounts
     * Create By feiyu
     * @description: 得到博文总数
     * @params:  * @param null
     * @Date: 2016/10/29
     * @return: int 博文总数
     */
    int getTotalCounts(int isRead);

    /**
     * @title: getById
     * Create By feiyu
     * @description: 根据id获取博客详情
     * @params:  * @param bid
     * @Date: 2016/10/29
     * @return: blog 博客实体
     */
    Blog getById(String bid);

    /**
     * @title: getCountsByClassification
     * Create By feiyu
     * @description: 根据分类查询当前分类的文章数
     * @params:  * @param Classification
     * @Date: 2016/11/1
     * @return:
     */
    int getCountsByClassification(@Param("classification") String classification,@Param("isRead") int isRead);
    /**
     * @title: getListByClassification
     * Create By feiyu
     * @description: 根据分类分页查询博文
     * @params:  * @param null
     * @Date: 2016/11/1
     * @return:
     */
    List<Blog> getListByClassification(@Param("classification") String classification,
                                       @Param("currentPage") int currentPage,
                                       @Param("pageNumber") int pageNumber,
                                       @Param("isRead") int isRead,
                                       @Param("isDraft") int isDraft);

    /**
     * @title: getDraftCounts
     * Create By feiyu
     * @description: 获取草稿箱中的博文数量
     * @params:  * @param isDraft 是否是草稿
     * @Date: 2016/11/1
     * @return: int 数量
     */
    int getDraftCounts(@Param("isDraft") int isDraft, @Param("isRead") int isRead);

    /**
     * @title: getListByKeyword
     * Create By feiyu
     * @description: 关键字查询（模糊查询）
     * @params:  * @param keyword
     * @param  isRead 是否可读
     * @Date: 2016/11/16
     * @return: list
     */
    List<Blog> getListByKeyword(@Param("keyword") String keyword, @Param("isRead") int isRead,
                                @Param("isDraft") int isDraft);
}
