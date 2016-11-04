package org.feiyu.myblog.admin.controller;/**
 * Created by feiyu on 2016/10/18.
 */

import org.feiyu.myblog.admin.service.UserService;
import org.feiyu.myblog.common.util.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <p>Title: TestController</p>
 * <p>description 视图控制器测试类</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/18
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public ModelAndView test(){
        /**
         * @title: test
         * Create By feiyu
         * @description: 
         * @params:  * @param 
         * @throws: 
         * @Date: 2016/10/18
         * @return: org.springframework.web.servlet.ModelAndView
         */
        System.out.print("IDEA 使用maven搭建spring框架成功！");
        return new ModelAndView("test");
    }
    @RequestMapping("/login")
    public ModelAndView login(String userName, String password) throws Exception {
    /**
     * @title: login
     * Create By feiyu
     * @description:
     * @params:  * @param userName
     * @param password
     * @Date: 2016/10/19
     * @return: java.lang.String
     */
        ModelAndView mv = new ModelAndView();
        boolean is = userService.login(userName,password);
       if(is){
           System.out.println("测试成功");
       }else{
           System.out.println("测试失败");
       }
        mv.setViewName("admin");
        mv.addObject("msg",SystemConfig.getConfig("jdbc.url"));
        return mv;
    }
}
