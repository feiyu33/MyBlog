package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/30.
 */

import org.feiyu.myblog.admin.dao.CommentsDao;
import org.feiyu.myblog.admin.entity.Comments;
import org.feiyu.myblog.common.po.PageWrap;
import org.feiyu.myblog.common.util.IdGen;
import org.feiyu.myblog.common.util.SystemConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @title: CommentsServiceImpl
 * @description 用户评论业务逻辑层实现类
 * @create 2016/10/30
 */
@Service("commentsService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class CommentsServiceImpl implements CommentsService{

    @Resource
    private CommentsDao commentsDao;

    public boolean add(Comments comments)  throws Exception{
        comments.setId(IdGen.uuId());
        comments.setCommentTime(new Date());
        int rows = commentsDao.add(comments);
        return rows == 1 ? true : false;
    }

    public boolean delete(String cid)  throws Exception{
        int rows = commentsDao.delete(cid);
        return rows == 1 ? true : false;
    }

    public List<Comments> getListByBlogId(String blogId) throws Exception {
        return commentsDao.getListByBlogId(blogId);
    }

    public int getCountsByBlogId(String bid) throws Exception {
        return commentsDao.getTotalCounts(bid);
    }
}
