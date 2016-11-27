package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/24.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author feiyu
 * @version 1.0
 * @title: HtmlConversionSql
 * @description html及sql符号转化工具类
 * @create 2016/10/24
 */
public class HtmlConversionSql {

    public static String conversionSql(String html){
        /**
         * @title: Encode
         * Create By feiyu
         * @description: 插入SQL时替换字符
         * @params:  * @param str
         * @Date: 2016/10/24
         * @return: java.lang.String
         */
        html = html.replace("'", "''");
        html = html.replace("\"", "&quot;");
        html = html.replace("<", "&lt;");
        html = html.replace(">", "&gt;");
        html = html.replace("\n", "<br>");
        html = html.replace("“", "&ldquo;");
        html = html.replace("”", "&rdquo;");
        return html;
    }

    public static String conversionHtml(String sql) {
        /**
         * @title: conversionHtml
         * Create By feiyu
         * @description: 取SQL值时还原字符
         * @params:  * @param str
         * @Date: 2016/10/24
         * @return: java.lang.String
         */
        sql = sql.replace("&rdquo;", "”");
        sql = sql.replace("&ldquo;", "“");
        sql = sql.replace("<br>", " ");
        sql = sql.replace("&gt;", ">");
        sql = sql.replace("&lt;", "<");
        sql = sql.replace("&quot;", "'\'");
        sql = sql.replace("''", "'");
        return sql;
    }

    public static Set<String> getImgStr(String htmlStr) {
        /**
         * @title: getImgStr
         * Create By feiyu
         * @description: 得到网页中图片的地址
         * @params:  * @param htmlStr
         * @Date: 2016/11/21
         * @return: java.util.Set<java.lang.String>
         */
        Set<String> pics = new HashSet<String>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        //     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile
                (regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }
}
