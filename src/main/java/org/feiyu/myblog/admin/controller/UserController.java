package org.feiyu.myblog.admin.controller;
/**
 * Created by feiyu on 2016/10/23.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.feiyu.myblog.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
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
        attributes.addFlashAttribute("msg","User password error, please input again!");
        return "redirect:/user/toLogin"; 
    }
}
