package org.feiyu.myblog.admin.dao;/**
 * Created by feiyu on 2016/10/30.
 */

import org.apache.ibatis.annotations.Param;
import org.feiyu.myblog.admin.entity.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author feiyu
 * @version 1.0
 * @Title: CommentsDao
 * @description 用户评论数据库访问层接口
 * @create 2016/10/30
 */
@Repository("commentsDao")
public interface CommentsDao {

    /**
     * @title: add
     * Create By feiyu
     * @description: 新增用户评论
     * @params:  * @param comments
     * @Date: 2016/10/30
     * @return: int 受影响行数
     */
    int add(@Param("comments") Comments comments);

    /**
     * @title: delete
     * Create By feiyu
     * @description: 删除评论
     * @params:  * @param cid 评论id
     * @Date: 2016/10/30
     * @return: int 受影响行数
     */
    int delete(String cid);

    /**
     * @title: getListByBlogId
     * Create By feiyu
     * @description: 根据博文id查看评论列表
     * @params:  * @param blogId
     * @Date: 2016/10/30
     * @return: list 评论集合
     */
    List<Comments> getListByBlogId(@Param("blogId") String blogId);

    /**
     * @title: getTotalCounts
     * Create By feiyu
     * @description: 根据博文id得到当前博文的所有评论
     * @params:  * @param null
     * @Date: 2016/10/30
     * @return:
     */
    int getTotalCounts(String bid);

}
