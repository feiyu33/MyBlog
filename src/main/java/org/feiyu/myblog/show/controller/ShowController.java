package org.feiyu.myblog.show.controller;/**
 * Created by feiyu on 2016/11/18.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.entity.Comments;
import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.admin.po.BlogPO;
import org.feiyu.myblog.admin.po.ClassificationPO;
import org.feiyu.myblog.admin.service.BlogService;
import org.feiyu.myblog.admin.service.CommentsService;
import org.feiyu.myblog.admin.service.DictEntityService;
import org.feiyu.myblog.admin.service.UserService;
import org.feiyu.myblog.common.po.PageWrap;
import org.feiyu.myblog.show.service.VisitsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feiyu
 * @version 1.0
 * @title: ShowController
 * @description 展示博客信息视图控制层
 * @create 2016/11/18
 */
@Controller
@SessionAttributes({"user","classificationPOs"})
@RequestMapping("show")
public class ShowController {

    private Log log = LogFactory.getLog(ShowController.class);

    @Resource
    private UserService userService;
    @Resource
    private BlogService blogService;
    @Resource
    private DictEntityService dictEntityService;
    @Resource
    private VisitsService showVisits;
    @Resource
    private org.feiyu.myblog.show.service.BlogService showBlog;
    @Resource
    private CommentsService commentsService;


    @RequestMapping(value = "blogs",method = RequestMethod.GET)
    public String blogs(){
        /**
         * @title: blogs
         * Create By feiyu
         * @description: 初次访问博客
         * @params:  * @param
         * @Date: 2016/11/26
         * @return: org.springframework.web.servlet.ModelAndView
         */
        try {
            boolean is = showVisits.upDateVisits();
            if(is){
                return "redirect:/show/main";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("更新访问次数失败"+e.getMessage());
        }
        return "";
    }
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public ModelAndView main(){
        /**
         * @title: main
         * Create By feiyu
         * @description: 博客首页展示
         * @params:  * @param
         * @Date: 2016/11/18
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("showMain");
        try {
            //获取用户信息
            User user = userService.getUserInfo();
            mv.addObject("user",user);
            //获取博文分类
            List<ClassificationPO> classificationPOs = blogService.getCountsByClassification();
            mv.addObject("classificationPOs",classificationPOs);
            //获取最新博文
            PageWrap<BlogPO> blogPageWrap = blogService.getListByPage(1,"new");
            mv.addObject("blogPageWrap",blogPageWrap);
            //获取浏览次数
            Map<String,Object> map = showVisits.getVisits();
            mv.addObject("historyVisits",map.get("historyVisits"));
            mv.addObject("visitCounts",map.get("visitCounts"));
            //获取阅读排行数据
            List<Blog> readBlogs = showBlog.getReadingList();
            mv.addObject("readBlogs",readBlogs);
            //获取热门排行
            List<Blog> rankBlogs = showBlog.getTopRanking();
            mv.addObject("rankBlogs",rankBlogs);
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
            mv.setViewName("details");
            //获取博文及评论信息
            BlogPO blogPO = blogService.getListById(bid);
            mv.addObject("blogPO",blogPO);
            //添加博文阅读量
            blogService.addReadCounts(bid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "comment",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> comment(Comments comments){
        /**
         * @title: comment
         * Create By feiyu
         * @description: 用户评论
         * @params:  * @param comments
         * @Date: 2016/11/26
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            boolean is = commentsService.add(comments);
            if(is){
                List<Comments> commentses = commentsService.getListByBlogId(comments.getBlogId());
                map.put("commentses",commentses);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("评论失败"+e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "thumbUp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> thumbUp(String bid){
        /**
         * @title: thumbUp
         * Create By feiyu
         * @description: 点赞
         * @params:  * @param bid
         * @Date: 2016/11/26
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            boolean is = blogService.addThumbUpCounts(bid);
            if(is){
                int thumbUpNumber = blogService.getById(bid).getThumbUpNumber();
                map.put("thumbUpNumber",thumbUpNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("点赞失败"+e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "searchByKey",method = RequestMethod.POST)
    public ModelAndView searchByKey(String key){
        /**
         * @title: searchByKey
         * Create By feiyu
         * @description: 关键字查询
         * @params:  * @param key
         * @Date: 2016/11/27
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view");
        try {
            PageWrap<BlogPO> blogPOs = blogService.getListByKeyword(key);
            mv.addObject("blogPageWrap",blogPOs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "classification",method = RequestMethod.GET)
    public ModelAndView getListByClassification(String classification,int currentPage){
        /**
         * @title: getListByClassification
         * Create By feiyu
         * @description: 根据分类查询博文列表
         * @params:  * @param classification
         * @param currentPage
         * @Date: 2016/11/27
         * @return: org.springframework.web.servlet.ModelAndView
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view");
        try {
            PageWrap<BlogPO> blogPOPageWrap = blogService.getListByClassification(classification,currentPage);
            mv.addObject("blogPageWrap",blogPOPageWrap);
            mv.addObject("classification",classification);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("根据分类查询博文列表失败"+e.getMessage());
        }
        return mv;
    }
}
