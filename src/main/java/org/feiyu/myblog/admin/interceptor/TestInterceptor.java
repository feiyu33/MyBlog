package org.feiyu.myblog.admin.interceptor;/**
 * Created by feiyu on 2016/10/19.
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: TestInterceptor</p>
 * <p>description 拦截器测试类</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/19
 */
public class TestInterceptor implements HandlerInterceptor {
    public boolean preHandle(javax.servlet.http.HttpServletRequest httpServletRequest,
                             javax.servlet.http.HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
    //返回值：表示是否将当前请求拦截下来 false请求终止 true请求继续
    //Object o 表示被拦截的请求的目标对象
        System.out.println("执行到方法preHandle了");
        return true;
    }

    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest,
                           javax.servlet.http.HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        //可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法
        System.out.println("执行到方法postHandle了");
    }

    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest,
                                javax.servlet.http.HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println("执行到方法afterCompletion了");
    }
}
