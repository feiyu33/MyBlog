package org.feiyu.myblog.admin.interceptor;/**
 * Created by feiyu on 2016/11/6.
 */

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author feiyu
 * @version 1.0
 * @title: LoginInterceptor
 * @description 登录拦截器
 * @create 2016/11/6
 */
public class LoginInterceptor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String userName = (String) session.getAttribute("name");
        if("".equals(userName) || userName == null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/user/toLogin");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
