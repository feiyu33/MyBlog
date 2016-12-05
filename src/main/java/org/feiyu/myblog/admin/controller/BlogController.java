package org.feiyu.myblog.admin.controller;/**
 * Created by feiyu on 2016/11/1.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.entity.DictEntity;
import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.admin.po.BlogPO;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.admin.service.BlogService;
import org.feiyu.myblog.admin.service.DictEntityService;
import org.feiyu.myblog.admin.service.UserService;
import org.feiyu.myblog.common.po.PageWrap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "toWrite",method = RequestMethod.GET)
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

    @RequestMapping(value = "showAdmin", method = RequestMethod.GET)
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
            PageWrap<BlogPO> blogPageWrap = blogService.getListByPage(1,"new");
            mv.addObject("blogPageWrap",blogPageWrap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    @RequestMapping(value = "publish", method = RequestMethod.POST)
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

    @RequestMapping(value = "showDetails",method = RequestMethod.GET)
    public ModelAndView showDetails(String bid){
        /**
         * @title: showDetails
         * Create By feiyu
         * @description: 根据博文id展示博文详情
         * @params:  * @param bid
         * @Date: 2016/11/6
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("showDetails");
            BlogPO blogPO = blogService.getListById(bid);
            mv.addObject("blogPO",blogPO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(String bid){
        /**
         * @title: delete
         * Create By feiyu
         * @description: 删除博文
         * @params:  * @param bid
         * @Date: 2016/11/8
         * @return: java.lang.String
         */
        try {
            boolean is = blogService.delete(bid);
            if (is){
                return "redirect:/blog/showAdmin";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("删除博文失败！"+e.getMessage());
        }
        return "redirect:/blog/showAdmin";
    }

    @RequestMapping(value = "turnPage", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> turnPage(int currentPage,String flag){
        /**
         * @title: turnPage
         * Create By feiyu
         * @description: 获取上、下一页博文信息
         * @params:  * @param currentPage
         * @Date: 2016/11/9
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            PageWrap<BlogPO> blogPOPageWrap;
            if(!"new".equals(flag) && !"hot".equals(flag) && flag != null && flag != ""){
                blogPOPageWrap = blogService.getListByClassification(flag,currentPage);
            }else{
                blogPOPageWrap = blogService.getListByPage(currentPage,flag);

            }
            map.put("blogPOs",blogPOPageWrap);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("查看下一页博文信息失败"+e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "toEditor", method = RequestMethod.GET)
    public ModelAndView toEditor(String bid){
        /**
         * @title: toEditor
         * Create By feiyu
         * @description: 到编辑页面
         * @params:  * @param bid
         * @Date: 2016/11/15
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        try {
            Blog blog = blogService.getById(bid);
            List<DictEntity> classifications = dictEntityService.getListByType("classification");
            mv.addObject("classifications",classifications);
            mv.addObject("blog",blog);
            mv.setViewName("editorBlog");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("获取博文信息失败"+e.getMessage());
        }
        return mv;
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ModelAndView update(Blog blog,@RequestParam("isDraft")String isDraft){
        /**
         * @title: update
         * Create By feiyu
         * @description: 修改博文信息
         * @params:  * @param blog
         * @Date: 2016/11/16
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        try {
            boolean is = blogService.update(blog,Integer.parseInt(isDraft));
            if(is){
               mv.setViewName("redirect:/blog/showAdmin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "byKeyword",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getListByKeyword(String keyword){
        /**
         * @title: getListByKeyword
         * Create By feiyu
         * @description: 关键字搜索
         * @params:  * @param keyword
         * @param currentPage
         * @Date: 2016/11/16
         * @return: org.springframework.web.servlet.ModelAndView
         */
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            PageWrap<BlogPO> blogPOs = blogService.getListByKeyword(keyword);
            map.put("blogPOs",blogPOs.getData());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("关键字查询错误"+e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "toDrafts",method = RequestMethod.GET)
    public ModelAndView toDrafts(int currentPage){
        /**
         * @title: toDrafts
         * Create By feiyu
         * @description: 去草稿箱页面
         * @params:  * @param
         * @Date: 2016/11/18
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        try {
            PageWrap<BlogPO> blogPOPageWrap = blogService.getListByPage(currentPage,"");
            mv.addObject("blogPageWrap",blogPOPageWrap);
            mv.setViewName("drafts");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("获取草稿箱信息失败"+e.getMessage());
        }
        return mv;
    }
}
