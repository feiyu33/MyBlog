package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/30.
 */

import org.feiyu.myblog.admin.entity.Comments;
import org.feiyu.myblog.common.po.PageWrap;

/**
 * @author feiyu
 * @version 1.0
 * @Title: CommentsService
 * @description 用户评论业务逻辑层接口
 * @create 2016/10/30
 */
public interface CommentsService {

    /**
     * @title: add
     * Create By feiyu
     * @description: 添加用户评论
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return: boolean 是否添加成功
     */
    boolean add(Comments comments) throws Exception;

    /**
     * @title: delete
     * Create By feiyu
     * @description: 根据评论id删除评论
     * @params:  * @param cid 评论id
     * @Date: 2016/10/30
     * @return: Boolean 是否删除成功
     */
    boolean delete(String cid) throws Exception;
    
    /**
     * @title: getListByBlogId
     * Create By feiyu
     * @description: 根据博文id分页查询评论集合
     * @params:  * @param bid 博文id
     * @param currentPage 当前页
     * @Date: 2016/10/30
     * @return:
     */
    PageWrap<Comments> getListByBlogId(String blogId, int currentPage) throws Exception;

    /**
     * @title: getCountsByBlogId
     * Create By feiyu
     * @description: 根据博文id查询博文评论数
     * @params:  * @param bid
     * @Date: 2016/11/7
     * @return: int 评论数
     */
    int getCountsByBlogId(String bid) throws Exception;
    
}
