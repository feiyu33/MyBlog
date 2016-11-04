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

    public static String conversionSql(String sql){
        /**
         * @title: Encode
         * Create By feiyu
         * @description: 插入SQL时替换字符
         * @params:  * @param str
         * @Date: 2016/10/24
         * @return: java.lang.String
         */
        sql = sql.replace("'", "''");
        sql = sql.replace("\"", "&quot;");
        sql = sql.replace("<", "&lt;");
        sql = sql.replace(">", "&gt;");
        sql = sql.replace("\n", "<br>");
        sql = sql.replace("“", "&ldquo;");
        sql = sql.replace("”", "&rdquo;");
        return sql;
    }

    public static String conversionHtml(String str) {
        /**
         * @title: conversionHtml
         * Create By feiyu
         * @description: 取SQL值时还原字符
         * @params:  * @param str
         * @Date: 2016/10/24
         * @return: java.lang.String
         */
        str = str.replace("&rdquo;", "”");
        str = str.replace("&ldquo;", "“");
        str = str.replace("<br>", "\n");
        str = str.replace("&gt;", ">");
        str = str.replace("&lt;", "<");
        str = str.replace("&quot;", "\"");
        str = str.replace("''", "'");

        return str;
    }
}
