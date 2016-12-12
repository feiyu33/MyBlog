package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/29.
 */

import org.feiyu.myblog.admin.dao.BlogDao;
import org.feiyu.myblog.admin.dao.DictEntityDao;
import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.entity.DictEntity;
import org.feiyu.myblog.admin.po.BlogPO;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.common.po.PageWrap;
import org.feiyu.myblog.common.po.SystemConstant;
import org.feiyu.myblog.common.service.PackListService;
import org.feiyu.myblog.common.util.HtmlConversionSql;
import org.feiyu.myblog.common.util.IdGen;
import org.feiyu.myblog.common.util.SystemConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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

    @Resource
    private CommentsService commentsService;

    @Resource
    private DictEntityService dictEntityService;

    @Resource
    private PackListService packListService;

    public boolean addOrDraft(Blog blog,int isDraft)  throws Exception{
        blog.setId(IdGen.uuId());
        blog.setReleaseTime(new Date());
        blog.setIsRead(SystemConstant.IS_READ);
        blog.setThumbUpNumber(0);
        blog.setReadCounts(0);
        blog.setIsDraft(isDraft);
        blog.setContent(HtmlConversionSql.conversionSql(blog.getContent()));
        int rows = blogDao.add(blog);
        return rows == 1 ? true : false;
    }

    public boolean delete(String bid)  throws Exception{
        int rows = blogDao.delete(bid, SystemConstant.NOT_READ);
        return rows == 1 ? true : false;
    }

    public PageWrap<BlogPO> getListByPage(int currentPage,String flag)  throws Exception{


        //获取分页博文信息集合
        List<Blog> blogs = new ArrayList<Blog>();

        PageWrap<BlogPO> pageWrap = new PageWrap<BlogPO>();
        pageWrap.setCounts(blogDao.getDraftCounts(SystemConstant.NOT_DRAFT,SystemConstant.IS_READ));
        int index = (currentPage - 1) * Integer.parseInt(SystemConfig.getConfig("page.number").trim());
        if ("new".equals(flag)){
            blogs = blogDao.getNewListByPage(index,
                    Integer.parseInt(SystemConfig.getConfig("page.number").trim()),
                    SystemConstant.IS_READ,SystemConstant.NOT_DRAFT);
        }
        else if ("hot".equals(flag)){
            blogs = blogDao.getHotListByPage(index,
                    Integer.parseInt(SystemConfig.getConfig("page.number").trim()),
                    SystemConstant.IS_READ,SystemConstant.NOT_DRAFT);
        }
        else {
            blogs = blogDao.getNewListByPage(index,
                    Integer.parseInt(SystemConfig.getConfig("page.number").trim()),
                    SystemConstant.IS_READ,SystemConstant.IS_DRAFT);
            pageWrap.setCounts(blogDao.getDraftCounts(SystemConstant.IS_DRAFT,SystemConstant.IS_READ));
        }
        //包装BlogPO实体集合
        List<BlogPO> blogPOs = packListService.packBlogPOList(blogs);

        pageWrap.setCurrentPage(currentPage);
        pageWrap.setData(blogPOs);

        return pageWrap;
    }

    public boolean update(Blog blog,int isDraft) throws Exception{
        blog.setReleaseTime(new Date());
        blog.setIsDraft(isDraft);
        blog.setContent(HtmlConversionSql.conversionSql(blog.getContent()));
        int rows = blogDao.update(blog);
        return rows == 1 ? true : false;
    }

    public boolean addReadCounts(String bid)  throws Exception{
        int rows = blogDao.addReadCounts(bid);
        return rows == 1 ? true : false;
    }

    public boolean addThumbUpCounts(String bid)  throws Exception{
        int rows = blogDao.addThumbUpCounts(bid);
        return rows == 1 ? true : false;
    }

    public BlogPO getListById(String bid)  throws Exception{
        BlogPO blogPO = new BlogPO();
        //根据id查询到博文信息
        Blog blog = blogDao.getById(bid);
        //转化博文内容
        blog.setContent(HtmlConversionSql.conversionHtml(blog.getContent()));
        //将博文分类编码转换为对应的分类
        DictEntity dictEntity = dictEntityService.getByValue(blog.getClassification());
        blog.setClassification(dictEntity.getDictName());
        blogPO.setBlog(blog);
        blogPO.setCommentCounts(commentsService.getCountsByBlogId(bid));
        blogPO.setComments(commentsService.getListByBlogId(bid));
        return blogPO;
    }

    public Blog getById(String bid) throws Exception {
        return blogDao.getById(bid);
    }

    public List<ClassificationPO> getCountsByClassification() throws Exception {

        List<ClassificationPO> classificationPOs = new ArrayList<ClassificationPO>();
        //获取分类列表并给每一个分类赋值
        List<DictEntity> classifications = dictEntityDao.getListByType("classification");
        for(DictEntity dictEntity : classifications){
            ClassificationPO classificationPO = new ClassificationPO();
            classificationPO.setBlogCounts(blogDao.getCountsByClassification(dictEntity.getDictValue(),SystemConstant.IS_READ));
            classificationPO.setDictEntity(dictEntity);
            classificationPOs.add(classificationPO);
        }
        return classificationPOs;
    }

    public PageWrap<BlogPO> getListByClassification(String classification, int currentPage) throws Exception {

        int index = (currentPage - 1) * Integer.parseInt(SystemConfig.getConfig("page.number").trim());
        //获取分页博文信息集合
        List<Blog> blogs = blogDao.getListByClassification(classification,
                index,Integer.parseInt(SystemConfig.getConfig("page.number")),
                SystemConstant.IS_READ,SystemConstant.NOT_DRAFT);
        //包装BlogPO实体集合
        List<BlogPO> blogPOs = packListService.packBlogPOList(blogs);

        PageWrap<BlogPO> blogPageWrap = new PageWrap<BlogPO>();
        blogPageWrap.setCurrentPage(currentPage);
        blogPageWrap.setCounts(blogDao.getCountsByClassification(classification,SystemConstant.IS_READ));
        blogPageWrap.setData(blogPOs);
        return blogPageWrap;
    }

    public int getDraftCounts() throws  Exception{
        return blogDao.getDraftCounts(SystemConstant.IS_DRAFT,SystemConstant.IS_READ);
    }

    public PageWrap<BlogPO> getListByKeyword(String keyword) throws Exception {
        //分页获取博文信息
        List<Blog> blogs = blogDao.getListByKeyword(keyword, SystemConstant.IS_READ,SystemConstant.NOT_DRAFT);
        List<BlogPO> blogPOs = packListService.packBlogPOList(blogs);

        PageWrap<BlogPO> blogPageWrap = new PageWrap<BlogPO>();
        blogPageWrap.setCurrentPage(1);
        blogPageWrap.setCounts(blogs.size());
        blogPageWrap.setData(blogPOs);
        return blogPageWrap;
    }
}
