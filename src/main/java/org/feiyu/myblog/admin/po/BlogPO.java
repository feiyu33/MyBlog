package org.feiyu.myblog.admin.po;/**
 * Created by feiyu on 2016/10/30.
 */

import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.entity.Comments;
import org.feiyu.myblog.common.po.PageWrap;

/**
 * @author feiyu
 * @version 1.0
 * @title: BlogPO
 * @description 博文业务类
 * @create 2016/10/30
 */
public class BlogPO {
    
    /**博文实体类**/
    private Blog blog;

    /**评论集合**/
    private PageWrap<Comments> comments;

    public BlogPO(){}

    public BlogPO(Blog blog, PageWrap<Comments> comments) {
        this.blog = blog;
        this.comments = comments;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public PageWrap<Comments> getComments() {
        return comments;
    }

    public void setComments(PageWrap<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "BlogPO{" +
                "blog=" + blog +
                ", comments=" + comments +
                '}';
    }
}
