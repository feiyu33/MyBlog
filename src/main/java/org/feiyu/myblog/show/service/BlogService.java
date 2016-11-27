package org.feiyu.myblog.show.service;/**
 * Created by feiyu on 2016/11/22.
 */

import org.feiyu.myblog.admin.entity.Blog;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: BlogService
 * @description 展示模块博文业务逻辑层接口
 * @create 2016/11/22
 */
public interface BlogService {

    List<Blog> getReadingList() throws Exception;

    List<Blog> getTopRanking() throws  Exception;

}
