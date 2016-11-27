package org.feiyu.myblog.admin.entity;/**
 * Created by feiyu on 2016/10/30.
 */

import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @title: Comments
 * @description 用户评论实体类
 * @create 2016/10/30
 */
public class Comments {

    /**id**/
    private String id;

    /**评论内容**/
    private String comments;

    /**用户名**/
    private String userName;

    /**用户email**/
    private String email;

    /**博文id**/
    private String blogId;

    /**评论时间**/
    private Date commentTime;

    public Comments(){}

    public Comments(String id, String comments, String userName, String email, String blogId, Date commentTime) {
        this.id = id;
        this.comments = comments;
        this.userName = userName;
        this.email = email;
        this.blogId = blogId;
        this.commentTime = commentTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id='" + id + '\'' +
                ", comments='" + comments + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", blogId='" + blogId + '\'' +
                ", commontTime=" + commentTime +
                '}';
    }
}
