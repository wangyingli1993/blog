package me.alent.core.controller.admin;

import me.alent.common.util.ResponseUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 上传图片
 * Created by Alent on 2017/3/27.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload-img", method = RequestMethod.POST)
    public void uploadImg(HttpServletRequest request, HttpServletResponse response, @RequestParam
            (value = "editormd-image-file", required = false) MultipartFile attach) {

        //获取文件扩展名
        String extension = FilenameUtils.getExtension(attach.getOriginalFilename());

        //按日期分目录存储
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dir = format.format(new Date());
        String realPath = request.getServletContext().getRealPath("/upload/" + dir);

        //判断目录是否存在
        File dirPath = new File(realPath);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
        String filePath = UUID.randomUUID().toString() + "." + extension;
        //最终文件上传路径
        String uploadPath = realPath + File.separator + filePath;
        // 注意：url请求路径是/ ，不是win系统的\
        String returnUrl = request.getContextPath() + "/upload/" + dir + "/" + filePath;
        try {
            FileUtils.copyInputStreamToFile(attach.getInputStream(), new File(uploadPath));
            String msg = "{\"success\":1, \"message\":\"上传成功！\", \"url\":\"" + returnUrl + "\"}";

            ResponseUtil.renderJson(response, msg );
        } catch (IOException e) {
            ResponseUtil.renderJson(response, "{\"success\":1" );
            e.printStackTrace();
        }
    }
}




