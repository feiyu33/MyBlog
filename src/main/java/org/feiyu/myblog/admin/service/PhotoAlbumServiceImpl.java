package org.feiyu.myblog.admin.service;/**
 * Created by feiyu on 2016/10/24.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.feiyu.myblog.admin.dao.PhotoAlbumDao;
import org.feiyu.myblog.admin.entity.PhotoAlbum;
import org.feiyu.myblog.common.po.PageWrap;
import org.feiyu.myblog.common.util.SystemConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.feiyu.myblog.common.util.SystemConfig.getConfig;

/**
 * @author feiyu
 * @version 1.0
 * @title: PhotoAlbumServiceImpl
 * @description 相册业务逻辑层实现类
 * @create 2016/10/24
 */
@Service("photoAlbumService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class PhotoAlbumServiceImpl implements PhotoAlbumService{

    private Log log = LogFactory.getLog(PhotoAlbumServiceImpl.class);
    @Resource
    private PhotoAlbumDao photoAlbumDao;

    public boolean add(PhotoAlbum photoAlbum)  throws Exception{

        photoAlbum.setLoadTime(new Date());
        int rows = photoAlbumDao.add(photoAlbum);
        return rows == 1 ? true : false;
    }

    public boolean delete(String id)  throws Exception{

        int rows = photoAlbumDao.delete(id);
        return rows == 1 ? true : false;
    }

    public PageWrap<PhotoAlbum> getListByPage(int page)  throws Exception{
        PageWrap<PhotoAlbum> pageWrap = new PageWrap<PhotoAlbum>();
        pageWrap.setCounts(photoAlbumDao.getCounts());
        pageWrap.setCurrentPage(page);
        //前端页数下标是从1开始记数的,数据库里的是从0开始记数的。所以传过来的页码要减1
        List<PhotoAlbum> photoAlba = photoAlbumDao.getListByPage(page-1, Integer.parseInt(SystemConfig.getConfig("page.number").trim()));
        pageWrap.setData(photoAlba);
        return pageWrap;
    }

    public boolean batchDelete(List<String> ids)  throws Exception{

        int rows = photoAlbumDao.batchDelete(ids);
        return rows >= 1 ? true : false;
    }
}
