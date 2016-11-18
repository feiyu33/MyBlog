package org.feiyu.myblog.common.service;/**
 * Created by feiyu on 2016/11/9.
 */

import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.po.BlogPO;
import org.feiyu.myblog.admin.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @title: PackListServiceImpl
 * @description 包装业务实体类集合实现类
 * @create 2016/11/9
 */
@Service("packListService")
public class PackListServiceImpl implements PackListService{

    @Resource
    private CommentsService commentsService;

    public List<BlogPO> packBlogPOList(List<Blog> blogs) throws Exception {
        /**
         * @title: packBlogPOList
         * Create By feiyu
         * @description: 包装博文业务实体集合
         * @params:  * @param list
         * @Date: 2016/11/9
         * @return: java.util.List<org.feiyu.myblog.admin.po.BlogPO>
         */
        List<BlogPO> blogPOs = new ArrayList<BlogPO>();

        if (blogs.size()>=0 && blogs != null){
            for (int i = 0; i < blogs.size(); i++){
                BlogPO blogPO = new BlogPO();
                blogPO.setCommentCounts(commentsService.getCountsByBlogId(blogs.get(i).getId()));
                blogPO.setBlog(blogs.get(i));
                blogPOs.add(blogPO);
            }
        }
        return blogPOs;
    }
}