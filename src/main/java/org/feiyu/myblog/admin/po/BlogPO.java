package org.feiyu.myblog.admin.po;/**
 * Created by feiyu on 2016/10/30.
 */

import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.entity.Comments;
import org.feiyu.myblog.common.po.PageWrap;

import java.util.List;

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

    /**博文引用图片**/
    private String img;

    /**评论集合**/
    private List<Comments> comments;

    /**评论次数**/
    private int commentCounts;

    public BlogPO(){}

    public BlogPO(Blog blog, List<Comments> comments,int commentCounts,String img) {
        this.blog = blog;
        this.comments = comments;
        this.commentCounts = commentCounts;
        this.img = img;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public int getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(int commentCounts) {
        this.commentCounts = commentCounts;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "BlogPO{" +
                "blog=" + blog +
                ", comments=" + comments +
                ", commentCounts=" + commentCounts +
                ", img="+img+
                '}';
    }
}
