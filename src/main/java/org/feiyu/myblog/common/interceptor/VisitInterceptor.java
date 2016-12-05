package org.feiyu.myblog.common.interceptor;/**
 * Created by feiyu on 2016/12/4.
 */

import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.admin.service.BlogService;
import org.feiyu.myblog.admin.service.UserService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @title: VisitInterceptor
 * @description 访问站点拦截器
 * @create 2016/12/4
 */
public class VisitInterceptor implements HandlerInterceptor{

    @Resource
    private UserService userService;
    @Resource
    private BlogService blogService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取用户信息
        User user = userService.getUserInfo();
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user",user);
        //获取博文分类
        List<ClassificationPO> classificationPOs = blogService.getCountsByClassification();
        session.setAttribute("classificationPOs",classificationPOs);
        return user == null || classificationPOs == null ? false : true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
