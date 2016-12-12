package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/23.
 */

import java.security.MessageDigest;

/**
 * @author feiyu
 * @version 1.0
 * @itle: MD5Util
 * @description MD5加密工具类
 * @create 2016/10/23
 */
public class MD5Util {

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] b) {
        /**
         * @title: byteArrayToHexString
         * Create By feiyu
         * @description: 转换字节数组为16进制字串
         * @params:  * @param b
         * @Date: 2016/10/23
         * @return: java.lang.String 16进制字串
         */
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        /**
         * @title: byteToHexString
         * Create By feiyu
         * @description: 转换byte到16进制
         * @params:  * @param b 要转换的byte
         * @Date: 2016/10/23
         * @return: java.lang.String 16进制格式
         */
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin) {
        /**
         * @title: MD5Encode
         * Create By feiyu
         * @description: MD5编码
         * @params:  * @param origin
         * @param ecod
         * @Date: 2016/10/23
         * @return: java.lang.String 经过MD5加密之后的结果
         */
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(origin.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
    public static void main(String[] args){
        System.out.println(MD5Util.MD5Encode("feiyu033"));
    }
}
