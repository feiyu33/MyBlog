package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/29.
 */

import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.po.BlogPO;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.common.po.PageWrap;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: BlogService
 * @description 博文业务逻辑访问层接口
 * @create 2016/10/29
 */
public interface BlogService {


    /**
     * @title: add
     * Create By feiyu
     * @description: 新增博文
     * @params:  * @param blog
     * @Date: 2016/10/29
     * @return: boolean是否新增成功
     */
    boolean addOrDraft(Blog blog,int isDraft) throws Exception;

    /**
     * @title: delete
     * Create By feiyu
     * @description: 删除博文
     * @params:  * @param bid 博文id
     * @Date: 2016/10/29
     * @return: Boolean是否删除成功
     */
    boolean delete(String bid) throws Exception;

    /**
     * @title: getListByPage
     * Create By feiyu
     * @description: 分页查询博文信息
     * @params:  * @param currentPage
     * @Date: 2016/10/29
     * @return: list 博文集合
     */
    PageWrap<BlogPO> getListByPage(int currentPage,String flag) throws Exception;

    /**
     * @title: update
     * Create By feiyu
     * @description: 修改博文内容
     * @params:  * @param blog
     * @Date: 2016/10/29
     * @return: Boolean是否修改成功
     */
    boolean update(Blog blog,int isDraft) throws Exception;

    /**
     * @title: addReadCounts
     * Create By feiyu
     * @description: 添加当前博文阅读次数
     * @params:  * @param bid
     * @Date: 2016/10/29
     * @return: Boolean是否新增成功
     */
    boolean addReadCounts(String bid) throws Exception;

    /**
     * @title: addThumbUpCounts
     * Create By feiyu
     * @description: 增加当前博文点赞数
     * @params:  * @param bid
     * @Date: 2016/10/29
     * @return: iBoolean是否新增成功
     */
    boolean addThumbUpCounts(String bid) throws Exception;

    /**
     * @title: getById
     * Create By feiyu
     * @description: 通过博客id获取博客详情及评论等信息
     * @params:  * @param bid
     * @param currentPage
     * @Date: 2016/10/29
     * @return: BlogPO
     */
    BlogPO getById(String bid, int currentPage) throws Exception;

    /**
     * @title: getById
     * Create By feiyu
     * @description: 根据博文id获取博文详情
     * @params: bid
     * @Date: 2016/11/15
     * @return: blog
     */
    Blog getById(String bid) throws Exception;

    /**
     * @title: getCountsByClassification
     * Create By feiyu
     * @description: 根据分类查询当前分类的文章数
     * @params:  * @param Classification
     * @Date: 2016/11/1
     * @return:
     */
    List<ClassificationPO> getCountsByClassification() throws Exception;

    /**
     * @title: getListByClassification
     * Create By feiyu
     * @description: 根据分类查询博文信息
     * @params:  * @param classification 博文分类
     * * @param currentPage 当前页
     * @Date: 2016/11/1
     * @return:
     */
    PageWrap<BlogPO> getListByClassification(String classification, int currentPage) throws Exception;

    /**
     * @title: getDraftCounts
     * Create By feiyu
     * @description: 获取草稿箱中的博文数量
     * @params:  * @param null
     * @Date: 2016/11/1
     * @return: int 数量
     */
    int getDraftCounts() throws Exception;

    /**
     * @title: getListByKeyword
     * Create By feiyu
     * @description: 根据关键字查询博文列表
     * @params:  * @param keyword 关键字
     * @param currentPage 当前页
     * @Date: 2016/11/16
     * @return: pagewrap
     */
    List<BlogPO> getListByKeyword(String keyword) throws Exception;
}
