package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/23.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author feiyu
 * @version 1.0
 * @itle: TimeUtil
 * @description 时间转化工具类
 * @create 2016/10/23
 */
public class TimeUtil {

    public final static String WEPAY_TIME = "yyyyMMddHHmmss";
    public final static String TERM_TIME = "yyyy-MM-dd";


    public static String getTime(long time,String type){
        SimpleDateFormat sdf = new SimpleDateFormat(type);

        return sdf.format(new Date(time));
    }

    public static String getCurrentTimeSecond(){

        return getTimeSecond(System.currentTimeMillis());
    }

    public static String getTimeSecond(long time){

        return String.valueOf(time / 1000);
    }

    public static long getTime(String time,String match){
        SimpleDateFormat sdf = new SimpleDateFormat(match);
        try {
            return sdf.parse(time).getTime();
        } catch (ParseException e) {

            e.printStackTrace();
        }

        return 0;
    }
}
