package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/23.
 */


import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * @author feiyu
 * @version 1.0
 * @itle: DownLoad
 * @description 文件下载工具类
 * @create 2016/10/23
 */
public class DownLoad {

    public static void download(String path, HttpServletResponse response) throws IOException {
        String filename = path.substring(path.lastIndexOf("\\")+1);
       // response.setHeader("content-disposition", "attachment;filename="+new URLEncoder().encode(filename));
        //服务器通过这个头，告诉浏览器以下载方式打开数据
        FileInputStream in = new FileInputStream(path);
        int len = 0;
        byte buffer[]=new byte[1024];
        OutputStream out = response.getOutputStream();

        //通过流的方式下载文件
        while((len = in.read(buffer))>0){
            out.write(buffer, 0, len);
        }
        in.close();
    }
}
