package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/29.
 */

import org.feiyu.myblog.admin.dao.BlogDao;
import org.feiyu.myblog.admin.dao.DictEntityDao;
import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.entity.DictEntity;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.common.po.PageWrap;
import org.feiyu.myblog.common.po.SystemConstant;
import org.feiyu.myblog.common.util.SystemConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @title: BlogServiceImpl
 * @description 博文业务逻辑层实现类
 * @create 2016/10/29
 */
@Service("blogService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    @Resource
    private DictEntityDao dictEntityDao;

    public boolean add(Blog blog)  throws Exception{
        int rows = blogDao.add(blog);
        if(rows == 1){
            return true;
        }
        return false;
    }

    public boolean delete(String bid)  throws Exception{
        int rows = blogDao.delete(bid, SystemConstant.NOT_READ);
        if(rows == 1){
            return true;
        }
        return false;
    }

    public PageWrap<Blog> getListByPage(int currentPage)  throws Exception{
        PageWrap<Blog> pageWrap = new PageWrap<Blog>();
        pageWrap.setCurrentPage(currentPage);
        pageWrap.setCounts(blogDao.getTotalCounts(SystemConstant.IS_READ));
        pageWrap.setData(blogDao.getListByPage(currentPage-1,
                Integer.parseInt(SystemConfig.getConfig("page.number").trim()),
                SystemConstant.IS_READ));

        return pageWrap;
    }

    public boolean update(Blog blog) throws Exception{
        int rows = blogDao.update(blog);
        if(rows == 1){
            return true;
        }
        return false;
    }

    public boolean addReadCounts(String bid)  throws Exception{
        int rows = blogDao.addReadCounts(bid);
        if(rows == 1){
            return true;
        }
        return false;
    }

    public boolean addThumbUpCounts(String bid)  throws Exception{
        int rows = blogDao.addThumbUpCounts(bid);
        if(rows == 1){
            return true;
        }
        return false;
    }

    public Blog getById(String bid)  throws Exception{
        return blogDao.getById(bid);
    }

    public List<ClassificationPO> getCountsByClassification() throws Exception {

        List<ClassificationPO> classificationPOs = new ArrayList<ClassificationPO>();
        //获取分类列表
        List<DictEntity> classifications = dictEntityDao.getListByType("classification");
        for(DictEntity dictEntity : classifications){
            ClassificationPO classificationPO = new ClassificationPO();
            classificationPO.setBlogCounts(blogDao.getCountsByClassification(dictEntity.getDictValue()));
            classificationPO.setDictEntity(dictEntity);
            classificationPOs.add(classificationPO);
        }
        return classificationPOs;
    }

    public PageWrap<Blog> getListByClassification(String classification, int currentPage) throws Exception {
        PageWrap<Blog> blogPageWrap = new PageWrap<Blog>();
        blogPageWrap.setCurrentPage(currentPage);
        blogPageWrap.setCounts(blogDao.getCountsByClassification(classification));
        blogPageWrap.setData(blogDao.getListByClassification(classification,currentPage,Integer.parseInt(SystemConfig.getConfig("page.number"))));

        return blogPageWrap;
    }

    public int getDraftCounts() throws  Exception{
        return blogDao.getDraftCounts(SystemConstant.IS_DRAFT);
    }
}
