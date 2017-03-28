package me.alent.core.controller.admin;

import me.alent.core.exception.CustomException;
import me.alent.core.po.Blog;
import me.alent.core.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 编辑博客
 * 对博客进行增删改查
 * Created by Alent on 2017/3/27.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping(value = "/index")
    public String index() {

        return "back-page/index";
    }

    @RequestMapping(value ="/edit/{id}" )
    public String edit(@PathVariable("id") Integer id) {

        if (id == null) {

        }
        return "back-page/edit";
    }

    @Resource
    private BlogService blogService;
    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String save(Blog blog) throws Exception {
        if (StringUtils.isEmpty(blog.getTitle())) {
            throw new CustomException("博客标题不能为空！");
        }
        blog.setCreateTime(new Date());
        blog.setUserId(1);
        blogService.saveBlog(blog);
        return "redirect:index";
    }
}
