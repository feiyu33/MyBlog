package org.feiyu.myblog.show.service;/**
 * Created by feiyu on 2016/11/22.
 */

import org.feiyu.myblog.admin.dao.BlogDao;
import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.common.po.SystemConstant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @title: BlogServiceImpl
 * @description 展示模块博文业务逻辑层实现类
 * @create 2016/11/22
 */
@Service("showBlog")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class BlogServiceImpl implements BlogService{

    @Resource
    private BlogDao blogDao;

    public List<Blog> getReadingList() throws Exception {
        List<Blog> blogs = blogDao.getReadingList(SystemConstant.NUMBER,SystemConstant.IS_READ,SystemConstant.NOT_DRAFT);
        return blogs;
    }

    public List<Blog> getTopRanking() throws Exception {
        List<Blog> blogs = blogDao.getTopRanking(SystemConstant.NUMBER,SystemConstant.IS_READ,SystemConstant.NOT_DRAFT);
        return blogs;
    }
}
