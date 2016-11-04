package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/19.
 */

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <p>Title: SpringContextHolder</p>
 * <p>description 以静态变量保存Spring ApplicationContext</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/19
 */
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware,DisposableBean{

    private static ApplicationContext applicationContext = null;
    private static Logger log = Logger.getLogger(SpringContextHolder.class);

    public static ApplicationContext getApplicationContext() {
    /**
     * @title: getApplicationContext
     * Create By feiyu
     * @description: 取得储存在静态变量中的ApplicationContext
     * @params:  * @param
     * @Date: 2016/10/19
     * @return: org.springframework.context.ApplicationContext
     */
        return applicationContext;
    }
    public static <T> T getBean(String name){
        /**
         * @title: getBean
         * Create By feiyu
         * @description: 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
         * @params:  * @param name
         * @Date: 2016/10/19
         * @return: T
         */
        return (T)applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        /**
         * @title: getBean
         * Create By feiyu
         * @description: 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
         * @params:  * @param requiredType
         * @Date: 2016/10/19
         * @return: T
         */
        return applicationContext.getBean(requiredType);
    }

    public static void clearHolder() {
        /**
         * @title: clearHolder
         * Create By feiyu
         * @description: 清除SpringContextHolder中的ApplicationContext为Null.
         * @params:  * @param
         * @Date: 2016/10/19
         * @return: void
         */
        if (log.isDebugEnabled()){
            log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        }
        applicationContext = null;
    }
    public void destroy() throws Exception {
        /**
         * @title: destroy
         * Create By feiyu
         * @description: 实现DisposableBean接口, 在Context关闭时清理静态变量.
         * @params:  * @param 
         * @Date: 2016/10/19
         * @return: void
         */
        SpringContextHolder.clearHolder();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        /**
         * @title: setApplicationContext
         * Create By feiyu
         * @description: 实现ApplicationContextAware接口, 注入Context到静态变量中.
         * @params:  * @param applicationContext
         * @Date: 2016/10/19
         * @return: void
         */
        SpringContextHolder.applicationContext = applicationContext;
    }
}
