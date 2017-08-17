package me.alent.core.controller.admin;

import me.alent.common.util.ResponseUtil;
import me.alent.core.po.BlogType;
import me.alent.core.po.PaginationBean;
import me.alent.core.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Alent on 2017/7/13.
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
    @Resource
    private BlogTypeService blogTypeService;

    @RequestMapping("/listBlogType")
    public @ResponseBody PaginationBean<BlogType> listBlogType(Integer rows, Integer page) {
        Long total = blogTypeService.getBlogTypeTotal();
        List<BlogType> listBlogType = blogTypeService.listBlogType(page-1, rows);
        PaginationBean<BlogType> result = new PaginationBean<BlogType>();
        result.setTotal(total);
        result.setRows(listBlogType);
        return result;
    }

    @RequestMapping("/save")
    public void save(BlogType blogType, HttpServletResponse response, Integer id) {
        Integer num = null;
        if(id != null) {
            num = blogTypeService.updateBlogTypeById(blogType, id);
        } else {
            num = blogTypeService.saveBlogType(blogType);
        }
        String result = null;
        if(num != null) {
            //language=JSON
            result = "{\"success\": 1}";
        }else {
            result = "{\"success\": 0}";
        }
        ResponseUtil.renderJson(response, result);
    }

    @RequestMapping("/delete")
    public void delete(HttpServletResponse response, String ids) {
        String[] str = ids.split(",");
        Integer[] idArray = new Integer[str.length];
        for(int i=0; i<str.length; i++) {
            idArray[i] = Integer.parseInt(str[i]);
        }
        Integer num = blogTypeService.deleteBlogTypeById(idArray);
        String result = null;
        if(num != null) {
            //language=JSON
            result = "{\"success\": 1}";
        }else {
            result = "{\"success\": 0}";
        }
        ResponseUtil.renderJson(response, result);
    }

    @RequestMapping("/update")
    public void update(BlogType blogType, Integer id) {
        blogTypeService.updateBlogTypeById(blogType, id);
    }
}
