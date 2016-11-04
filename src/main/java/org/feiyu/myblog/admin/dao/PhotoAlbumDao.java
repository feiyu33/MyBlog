package org.feiyu.myblog.admin.dao;/**
 * Created by feiyu on 2016/10/24.
 */

import org.apache.ibatis.annotations.Param;
import org.feiyu.myblog.admin.entity.PhotoAlbum;
import org.feiyu.myblog.common.po.PageWrap;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: PhotoAlbumDao
 * @description 相册数据库访问层接口
 * @create 2016/10/24
 */
@Repository("photoAlbumDao")
public interface PhotoAlbumDao {

    /**
     * @title: add
     * Create By feiyu
     * @description: 添加图片
     * @params:  * @param photoAlbum
     * @Date: 2016/10/24
     * @return: int 受影响行数
     */
    int add(@Param("photo") PhotoAlbum photoAlbum);

    /**
     * @title: delete
     * Create By feiyu
     * @description: 删除照片
     * @params:  * @param id
     * @Date: 2016/10/24
     * @return: int 受影响行数
     */
    int delete(String id);

    /**
     * @title: getCounts
     * Create By feiyu
     * @description: 获取总记录数
     * @params:  * @param null
     * @Date: 2016/10/25
     * @return: int 总记录数
     */
    int getCounts();

    /**
     * @title: getListByPage
     * Create By feiyu
     * @description: 分页查询出相片列表
     * @params:  * @param null
     * @Date: 2016/10/24
     * @return:
     */
    List<PhotoAlbum> getListByPage(@Param("currentPage") int currentPage, @Param("pageNumber") int pageNumber);

    /**
     * @title: batchDelete
     * Create By feiyu
     * @description: 批量删除照片
     * @params:  * @param ids
     * @Date: 2016/10/25
     * @return: 被删除的数据条数
     */
     int batchDelete(@Param("ids") List<String> ids);
}
