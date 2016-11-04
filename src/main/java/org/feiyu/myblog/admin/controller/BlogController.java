package org.feiyu.myblog.admin.controller;/**
 * Created by feiyu on 2016/11/1.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author feiyu
 * @version 1.0
 * @title: BlogController
 * @description 博文视图控制层
 * @create 2016/11/1
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    private Log log = LogFactory.getLog(BlogController.class);

    @RequestMapping("/toWrite")
    public String toWritePage(){
        /**
         * @title: toWritePage
         * Create By feiyu
         * @description: 去博文书写页面
         * @params:  * @param
         * @Date: 2016/11/1
         * @return: java.lang.String
         */
        return "writeBlog";
    }
}
