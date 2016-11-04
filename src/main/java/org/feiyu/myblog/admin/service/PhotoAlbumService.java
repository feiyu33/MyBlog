package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/24.
 */

import org.feiyu.myblog.admin.entity.PhotoAlbum;
import org.feiyu.myblog.common.po.PageWrap;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: PhotoAlbumService
 * @description 相册业务逻辑层接口
 * @create 2016/10/24
 */
public interface PhotoAlbumService {

    /**
     * @title: add
     * Create By feiyu
     * @description: 添加相片
     * @params:  * @param PhotoAlbum
     * @Date: 2016/10/24
     * @return: boolean 是否添加成功
     */
    boolean add(PhotoAlbum photoAlbum) throws Exception;

    /**
     * @title: delete
     * Create By feiyu
     * @description: 删除相片
     * @params:  * @param null
     * @Date: 2016/10/24
     * @return: boolean 是否删除成功
     */
    boolean delete(String id) throws Exception;

    /**
     * @title: getListByPage
     * Create By feiyu
     * @description: 分页查询照片
     * @params:  * @param page 当前页
     * @Date: 2016/10/24
     * @return: list 照片集合
     */
    PageWrap<PhotoAlbum> getListByPage(int page) throws Exception;

    /**
     * @title: batchDelete
     * Create By feiyu
     * @description: 批量删除照片
     * @params:  * @param ids
     * @Date: 2016/10/25
     * @return: 被删除的数据条数
     */
    boolean batchDelete(List<String> ids) throws Exception;
}
