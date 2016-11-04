package org.feiyu.myblog.admin.service;

import org.feiyu.myblog.admin.entity.PhotoAlbum;
import org.feiyu.myblog.common.po.PageWrap;
import org.feiyu.myblog.common.util.IdGen;
import org.feiyu.myblog.common.util.TimeUtil;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.text.resources.cldr.ee.FormatData_ee;

import javax.annotation.Resource;
import java.util.Date;

/**
 * PhotoAlbumServiceImpl Tester.
 *
 * @author feiyu
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class PhotoAlbumServiceImplTest {

    @Resource
    private PhotoAlbumService photoAlbumService;
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(PhotoAlbum photoAlbum)
     */
    @Test
    public void testAdd() throws Exception {
        PhotoAlbum photoAlbum = new PhotoAlbum(IdGen.uuId(),"http://","test",new Date());
        boolean is = photoAlbumService.add(photoAlbum);
        System.out.println(is);
    }

    @Test
    public void testDelete() throws Exception{
        boolean is = photoAlbumService.delete("2d5726d771ab4b6cb438a726d020b832");
        System.out.println(is);
    }

    @Test
    public void testGetList() throws Exception{
        PageWrap<PhotoAlbum> pageWrap = photoAlbumService.getListByPage(1);
        for(PhotoAlbum photoAlbum : pageWrap.getData()){
            System.out.println(photoAlbum.getDescription());
        }
    }
} 
