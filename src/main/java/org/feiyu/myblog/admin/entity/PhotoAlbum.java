package org.feiyu.myblog.admin.entity;/**
 * Created by feiyu on 2016/10/24.
 */

import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @title: PhotoAlbum
 * @description 相册实体类
 * @create 2016/10/24
 */
public class PhotoAlbum {

    /**id**/
    private String id;

    /**相册服务器连接**/
    private String url;

    /**相册描述（标题）**/
    private String description;

    /**上传时间**/
    private Date loadTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Date loadTime) {
        this.loadTime = loadTime;
    }

    public PhotoAlbum(String id, String url, String description,Date loadTime) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.loadTime = loadTime;
    }

    @Override
    public String toString() {
        return "PhotoAlbum{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", loadTime=" + loadTime +
                '}';
    }
}
