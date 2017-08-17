package me.alent.core.controller.admin;

import me.alent.common.util.ResponseUtil;
import me.alent.core.po.Blog;
import me.alent.core.po.BlogType;
import me.alent.core.po.PaginationBean;
import me.alent.core.service.BlogService;
import me.alent.core.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/12.
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
    @Resource
    private BlogService blogService;

    /**
     *  分页显示blog信息
     * @param page 第几页
     * @param rows 每页显示行
     * @param blog
     * @return
     */
    @RequestMapping("/listBlog")
    public  @ResponseBody PaginationBean<Blog> listBlog(Integer page, Integer rows, Blog blog, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("title", blog.getTitle());
        map.put("pageSize", rows);
        map.put("start", (page-1)*rows);
        List<Blog> blogList = blogService.listBlogByMap(map);

        Long total = blogService.getBlogTotal(map);

        /*JSONObject result = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONArray jsonArray = JSONArray.fromObject(blogList, jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.renderJson(response, result.toString());*/
        PaginationBean<Blog> result = new PaginationBean<Blog>();
        result.setRows(blogList);
        result.setTotal(total);
        return result;
    }

    /**
     * 删除博客
     * @param ids
     * @param response
     */
    @RequestMapping("/delete")
    public void deleteBlog(String ids, HttpServletResponse response) {
        String[] str = ids.split(",");
        Integer[] blogIds = new Integer[str.length];
        for(int i=0; i<str.length; i++) {
            blogIds[i] = Integer.parseInt(str[i]);
        }
        String result = null;
        if(blogService.deleteBlogByIds(blogIds) != null) {
            result = "{\"success\":1}";
        } else {
            result = "{\"success\":0}";
        }
        ResponseUtil.renderJson(response, result);
    }

    /**
     * 保存或更新博客
     * @param blog
     * @param response
     */
    @RequestMapping("/save")
    public void saveBlog(Blog blog, HttpServletResponse response) {
        Integer num = null;
        if(blog.getId() != null) {
            num = blogService.updateBlogById(blog, blog.getId());
        }else {
            blog.setReleaseDate(new Date());
            num = blogService.saveBlog(blog);
        }
        String result = null;
        if(num != null) {
            result = "{\"success\":1}";
        } else {
            result = "{\"success\":0}";
        }
        ResponseUtil.renderJson(response, result);
    }

    @Resource
    private BlogTypeService blogTypeService;
    @RequestMapping("/edit")
    public String edit(Model model) {
        List<BlogType> listBlogType = blogTypeService.listBlogType(null, null);
        model.addAttribute("blogTypeList", listBlogType);
        return "admin/writeBlog";
    }

    @RequestMapping("/test")
    public @ResponseBody Blog testJson() {
        Blog blog = new Blog();
        blog.setTitle("java");
        blog.setId(10);
        return blog;
    }
}
