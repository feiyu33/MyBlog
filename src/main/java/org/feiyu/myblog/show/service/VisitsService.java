package org.feiyu.myblog.show.service;/**
 * Created by feiyu on 2016/11/22.
 */

import java.util.Map;

/**
 * @author feiyu
 * @version 1.0
 * @Title: VisitsService
 * @description 展示模块浏览次数业务逻辑层接口
 * @create 2016/11/22
 */
public interface VisitsService {

    Map<String,Object> getVisits()throws Exception;

    Boolean upDateVisits() throws Exception;
}
