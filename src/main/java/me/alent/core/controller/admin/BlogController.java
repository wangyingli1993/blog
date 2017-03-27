package me.alent.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 编辑博客
 * 对博客进行增删改查
 * Created by Alent on 2017/3/27.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping(value ="/edit/{id}" )
    public String edit(@PathVariable("id") Integer id) {

        if (id == null) {

        }
        return "back-page/edit";
    }
}
