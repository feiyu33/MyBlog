package org.feiyu.myblog.common.controller;/**
 * Created by feiyu on 2016/10/18.
 */

import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;
import org.feiyu.myblog.common.util.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


/**
 * <p>Title: FileController</p>
 * <p>description 文件处理视图类</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/18
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static Logger log = Logger.getLogger(FileController.class);

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public void uploadImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
    /**
     * @title: uploadImg
     * Create By feiyu
     * @description: 图片上传
     * @params:  * @param file
     * @Date: 2016/10/19
     * @return: void
     */
        String DirectoryName = "upload/";
        try{
            Upload.ckeditor(request,response,DirectoryName);
        }catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
