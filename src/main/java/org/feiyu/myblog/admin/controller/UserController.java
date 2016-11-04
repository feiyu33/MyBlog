package org.feiyu.myblog.admin.controller;
/**
 * Created by feiyu on 2016/10/23.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.admin.service.BlogService;
import org.feiyu.myblog.admin.service.PhotoAlbumService;
import org.feiyu.myblog.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @itle: UserController
 * @description 用户视图管理层
 * @create 2016/10/23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Log log = LogFactory.getLog(UserController.class);
    @Resource
    private UserService userService;

    @Resource
    private PhotoAlbumService photoAlbumService;

    @Resource
    private BlogService blogService;

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        /**
         * @title: toLogin
         * Create By feiyu
         * @description: 到登录页面
         * @params:  * @param
         * @Date: 2016/10/23
         * @return: java.lang.String
         */
        return "loginPage";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String name, String password, RedirectAttributes attributes){
        /**
         * @title: login
         * Create By feiyu
         * @description: 博主登录
         * @params:  * @param name 博主姓名
         * @param password 博主密码
         * @Date: 2016/10/23
         * @return: java.lang.String
         */
        ModelAndView mv = new ModelAndView();
        try {
            boolean is = userService.login(name,password);
            if(is){
                mv.setViewName("admin");
                //获取用户信息
                User user = userService.getUserInfo();
                mv.addObject("user",user);
                //获取草稿箱
                int draftCounts = blogService.getDraftCounts();
                mv.addObject("draftCounts",draftCounts);
                //获取博文分类和对应的篇数
                List<ClassificationPO> classificationPOs = blogService.getCountsByClassification();
                mv.addObject("classificationPOs",classificationPOs);
                return mv;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("用户登录异常");
        }
        //重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象
        attributes.addFlashAttribute("msg","用户密码错误，请重新输入！");
        mv.setViewName("redirect:/user/toLogin");
        return mv;
    }
}
