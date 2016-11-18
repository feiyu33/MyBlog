package org.feiyu.myblog.common.service;/**
 * Created by feiyu on 2016/11/9.
 */

import org.feiyu.myblog.admin.entity.Blog;
import org.feiyu.myblog.admin.po.BlogPO;

import java.util.List;

/**
 * @author feiyu
 * @version 1.0
 * @Title: PackListService
 * @description 包装业务实体类集合
 * @create 2016/11/9
 */
public interface PackListService {

    List<BlogPO> packBlogPOList(List<Blog> blogs) throws Exception;
}
