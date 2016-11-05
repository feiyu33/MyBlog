package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/11/5.
 */

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @title: JstlUtil
 * @description 自定义标签解析时间工具类
 * @create 2016/11/5
 */
public class JstlUtil {
    public static String formatDate(Date date,String pattern){
        return DateFormatUtils.format(date,pattern);
    }
}
