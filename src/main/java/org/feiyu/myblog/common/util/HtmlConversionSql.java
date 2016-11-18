package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/24.
 */

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
}
