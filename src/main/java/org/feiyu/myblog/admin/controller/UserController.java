package org.feiyu.myblog.admin.controller;
/**
 * Created by feiyu on 2016/10/23.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.admin.service.UserService;
import org.feiyu.myblog.common.util.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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
    public String login(String name, String password, RedirectAttributes attributes) throws UnsupportedEncodingException {
        /**
         * @title: login
         * Create By feiyu
         * @description: 博主登录
         * @params:  * @param name 博主姓名
         * @param password 博主密码
         * @Date: 2016/10/23
         * @return: java.lang.String
         */
        try {
            boolean is = userService.login(name,password);
            if(is){
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                session.setAttribute("name",name);
                return "redirect:/blog/showAdmin";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("用户登录异常");
        }
        //重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象
        attributes.addFlashAttribute("msg","用户密码错误，请重新输入！");
        Map<String, ?> ss = attributes.getFlashAttributes();
        return "redirect:/user/toLogin"; 
    }
    @RequestMapping(value = "showUser",method = RequestMethod.GET)
    public ModelAndView showUser(){
        /**
         * @title: showUser
         * Create By feiyu
         * @description: 展示个人信息
         * @params:  * @param null
         * @Date: 2016/11/7
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        try {
            User user = userService.getUserInfo();
            if (user != null){
                mv.setViewName("userInfo");
                mv.addObject("user",user);
                return mv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView update(User user,RedirectAttributes attributes){
        /**
         * @title: update
         * Create By feiyu
         * @description: 修改用户信息
         * @params:  * @param user
         * @Date: 2016/11/7
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/user/showUser");
        attributes.addFlashAttribute("flag",1);
        try {
            boolean is = userService.update(user);
            if (is){
                attributes.addFlashAttribute("msg","修改博主信息成功！");
                return mv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        attributes.addFlashAttribute("msg","修改博主信息失败！");
        return mv;
    }

    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public ModelAndView updatePwd(String userName, String password, String rePwd, RedirectAttributes attributes){
        /**
         * @title: updatePwd
         * Create By feiyu
         * @description: 修改博主密码
         * @params:  * @param password
         * @Date: 2016/11/7
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        attributes.addFlashAttribute("flag",1);
        try {
            boolean is = userService.updatePwd(userName,password,rePwd);
            if (is){
                attributes.addFlashAttribute("msg","修改密码成功！");
                return mv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        attributes.addFlashAttribute("msg","修改密码失败！");
        mv.setViewName("redirect:/user/showUser");
        return mv;
    }

    @RequestMapping(value = "/updateImage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateImage(HttpServletRequest request){
        /**
         * @title: updateImage
         * Create By feiyu
         * @description: 修改博主头像
         * @params:  * @param request
         * @param response
         * @Date: 2016/11/7
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */
        Map<String,Object> map = new HashMap<String,Object>();
        String DirectoryName = "upload/";
        try{
            map = Upload.uploadFile(request,DirectoryName);
        }catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
