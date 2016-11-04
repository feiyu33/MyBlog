package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/19.
 */

import sun.rmi.rmic.iiop.IDLGenerator;

import java.util.UUID;

/**
 * <p>Title: IdGen</p>
 * <p>description 生成id</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/19
 */
public class IdGen {

    public static String uuId(){
        /**
         * @title: uuId
         * Create By feiyu
         * @description:使用UUID生成id
         * @params:  * @param
         * @Date: 2016/10/20
         * @return: java.lang.String
         */
        return UUID.randomUUID().toString().replace("-","");
    }
}
