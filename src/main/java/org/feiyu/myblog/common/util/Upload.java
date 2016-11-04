package org.feiyu.myblog.common.util;/**
 * Created by feiyu on 2016/10/23.
 */

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author feiyu
 * @version 1.0
 * @itle: Upload
 * @description 文件上传工具类
 * @create 2016/10/23
 */
public class Upload {

    public static Map<String,Object> uploadFile(HttpServletRequest request, String filePaths) throws IllegalStateException, IOException {
        /**
         * @title: uploadFile
         * Create By feiyu
         * @description: 文件上传方法
         * @params:  * @param request
         * @param filePaths
         * @Date: 2016/10/23
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */
        Map<String,Object> map = new HashMap<String, Object>();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        String id = IdGen.uuId();
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator<String> iter=multiRequest.getFileNames();
            while(iter.hasNext()){
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null && file.getSize() > 0){
                    String realPath=request.getSession().getServletContext().getRealPath("/");
                    File filePath = new File(realPath+filePaths);
                    if(!filePath.exists()){
                        filePath.mkdirs();
                    }
                    String path = filePath+"/"+file.getOriginalFilename();
                    String fileType = "."+path.substring(path.lastIndexOf(".")+1);
                    File oldfile = new File(path);
                    File newfile = new File(filePath+"/"+id+fileType);
                    oldfile.renameTo(newfile);
                    //上传
                    file.transferTo(newfile);
                    map.put("id", id);
                    map.put("fileName",id+fileType);
                    map.put("file", file);
                    map.put("path", path);
                    map.put("fileType", fileType);
                }
            }
        }
        return map;
    }
    public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        /**
         * @title: ckeditor
         * Create By feiyu
         * @description: 文件上传功能，回调，传回图片路径，实现预览效果。
         * @params:  * @param request
         * @param response
         * @param DirectoryName 文件上传目录
         * @Date: 2016/10/24
         * @return: void
         */
        Map<String,Object> map = uploadFile(request, DirectoryName);
        String fileName = (String)map.get("fileName");
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        String imageContextPath = request.getContextPath() + "/" + DirectoryName + fileName;
        response.setContentType("text/html;charset=UTF-8");
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
        out.println("</script>");
        out.flush();
        out.close();
    }
}
