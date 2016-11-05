package org.feiyu.myblog.admin.controller;/**
 * Created by feiyu on 2016/11/1.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.entity.DictEntity;
import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.admin.service.BlogService;
import org.feiyu.myblog.admin.service.DictEntityService;
import org.feiyu.myblog.admin.service.UserService;
import org.feiyu.myblog.common.po.PageWrap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Resource
    private BlogService blogService;
    @Resource
    private DictEntityService dictEntityService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/toWrite",method = RequestMethod.GET)
    public ModelAndView toWritePage(){
        /**
         * @title: toWritePage
         * Create By feiyu
         * @description: 去博文书写页面
         * @params:  * @param
         * @Date: 2016/11/1
         * @return: java.lang.String
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("writeBlog");
        //添加分类
        List<DictEntity> classifications = dictEntityService.getListByType("classification");
        mv.addObject("classifications",classifications);
        return mv;
    }

    @RequestMapping(value = "/showAdmin", method = RequestMethod.GET)
    public ModelAndView showAdmin(){
        /**
         * @title: showMain
         * Create By feiyu
         * @description: 显示博主后台信息
         * @params:  * @param
         * @Date: 2016/11/4
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin");
        try {
            //获取用户信息
            User user = userService.getUserInfo();
            mv.addObject("user",user);
            //获取草稿箱
            int draftCounts = blogService.getDraftCounts();
            mv.addObject("draftCounts",draftCounts);
            //获取博文分类和对应的篇数
            List<ClassificationPO> classificationPOs = blogService.getCountsByClassification();
            mv.addObject("classificationPOs",classificationPOs);
            //获取最新博文
            PageWrap<Blog> blogPageWrap = blogService.getListByPage(1);
            mv.addObject("blogPageWrap",blogPageWrap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ModelAndView publish(Blog blog, @RequestParam("isDraft")String isDraft){
        /**
         * @title: publish
         * Create By feiyu
         * @description: 发布博文或存为草稿
         * @params:  * @param blog
         * @Date: 2016/11/4
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();

        try {
            boolean is = blogService.addOrDraft(blog,Integer.parseInt(isDraft));
            if(is){
                mv.setViewName("redirect:/blog/showAdmin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
