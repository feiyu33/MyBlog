package org.feiyu.myblog.admin.service;

import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.common.po.SystemConstant;
import org.feiyu.myblog.common.util.IdGen;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * BlogServiceImpl Tester.
 *
 * @author feiyu
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class BlogServiceImplTest {

    @Resource
    private BlogService blogService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(Blog blog)
     */
    @Test
    public void testAdd() throws Exception {

    }

    /**
     * Method: delete(String bid)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getListByPage(int currentPage)
     */
    @Test
    public void testGetListByPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: update(Blog blog)
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addReadCounts(String bid)
     */
    @Test
    public void testAddReadCounts() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addThumbUpCounts(String bid)
     */
    @Test
    public void testAddThumbUpCounts() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getById(String bid)
     */
    @Test
    public void testGetById() throws Exception {

    }
} 
