package org.feiyu.myblog.admin.entity;/**
 * Created by feiyu on 2016/10/25.
 */

import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @title: Blog
 * @description 博文实体类
 * @create 2016/10/25
 */
public class Blog {
    
    /**id**/
    private String id;
    
    /**标题**/
    private String title;
    
    /**内容**/
    private String content;

    /**分类**/
    private String classification;
    
    /**是否允许评论 0为允许 1为不允许**/
    private int isComments;
    
    /**阅读次数**/
    private int readCounts;
    
    /**是否能查看 0为可看 1为不可看**/
    private int isRead;
    
    /**是否存为草稿 0为不存为草稿 1为存为草稿**/
    private int isDraft;

    /**点赞次数**/
    private int thumbUpNumber;

    /**发布时间**/
    private Date releaseTime;

    public Blog(){}

    public Blog(String id, String title, String content, String classification, int isComments,
                int readCounts, int isRead, int isDraft, int thumbUpNumber, Date releaseTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.classification = classification;
        this.isComments = isComments;
        this.readCounts = readCounts;
        this.isRead = isRead;
        this.isDraft = isDraft;
        this.thumbUpNumber = thumbUpNumber;
        this.releaseTime = releaseTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getIsComments() {
        return isComments;
    }

    public void setIsComments(int isComments) {
        this.isComments = isComments;
    }

    public int getReadCounts() {
        return readCounts;
    }

    public void setReadCounts(int readCounts) {
        this.readCounts = readCounts;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(int isDraft) {
        this.isDraft = isDraft;
    }

    public int getThumbUpNumber() {
        return thumbUpNumber;
    }

    public void setThumbUpNumber(int thumbUpNumber) {
        this.thumbUpNumber = thumbUpNumber;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", classification='" + classification + '\'' +
                ", isComments=" + isComments +
                ", readCounts=" + readCounts +
                ", isRead=" + isRead +
                ", isDraft=" + isDraft +
                ", thumbUpNumber=" + thumbUpNumber +
                ", releaseTime=" + releaseTime+
                '}';
    }
}
