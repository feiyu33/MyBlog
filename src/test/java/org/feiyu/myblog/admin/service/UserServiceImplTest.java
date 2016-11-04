package org.feiyu.myblog.admin.service;

import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.common.util.MD5Util;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * UserServiceImpl Tester.
 *
 * @author feiyu
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class UserServiceImplTest {

    @Resource
    private UserService userService;
    @Before
    public void before() throws Exception {
        System.out.println("start test!");
    }

    @After
    public void after() throws Exception {
        System.out.println("end test!");
    }

    /**
     * Method: login(String name, String password)
     */
    @Test
    public void testLogin() throws Exception {
        boolean is = userService.login("feiyu","feiyu033");
        if(is){
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
    }
    @Test
   public void testGetUserInfo() throws Exception {
        User user = userService.getUserInfo();
        System.out.println(user.getUserName()+"---"+user.getEmail());
   }

   @Test
   public void testUpdate() throws Exception {
       User user = userService.getUserInfo();
       user.setUserName("feiyu");
       user.setDiploma("成都信息工程大学");
       user.setPresentAddress("四川省成都市");
       user.setImageUrl("http://");
       user.setLabels("java学习者");
       userService.update(user);
   }

   @Test
   public void testUpdatePwd() throws Exception {
       boolean is = userService.updatePwd("feiyu","123456","feiyu033");
       System.out.println(is);
   }

} 
