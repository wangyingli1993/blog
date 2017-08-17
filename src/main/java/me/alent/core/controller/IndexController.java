package me.alent.core.controller;

import me.alent.common.util.PageUtil;
import me.alent.core.po.Blog;
import me.alent.core.service.BlogService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页
 * Created by Alent on 2017/7/22.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private BlogService blogService;

    /**
     * 主页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(Integer page, Integer typeId, HttpServletRequest request) {
        if(StringUtils.isEmpty(page)){
            page = 1;
        }
        // map中封装起始页和每页的记录
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", 10);
        map.put("start", (page-1)*10);
        map.put("typeId", typeId);
        List<Blog> blogList = blogService.listBlogByMap(map);

        for(Blog blog : blogList) {
            List<String> imgList = new ArrayList<String>();
            blog.setImgList(imgList);
            String blogInfo = blog.getContent(); //获取博客内容
            Document doc = Jsoup.parse(blogInfo); //将博客内容(网页中也就是一些html)转为jsoup的Document
            Elements jpgs = doc.select("img[src$=.jpg]");//获取<img>标签中所有后缀是.jpg的元素
            for(int i = 0; i < jpgs.size(); i++) {
                Element jpg = jpgs.get(i); //获取到单个元素
                imgList.add(jpg.toString()); //把图片信息存到imageList中
                if(i == 2) {
                    break; //只存三张图片信息
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        // 分页
        StringBuilder param = new StringBuilder();
        //拼接参数，主要对于点击文章分类或者日期分类后，查出来的分页，要拼接具体的参数
        if(!StringUtils.isEmpty(typeId)) {
            param.append("typeId=" + typeId + "&");
        }
        modelAndView.addObject("pageCode", PageUtil.genPagination( //调用代码生成的工具类生成前台显示
                request.getContextPath() + "/index.html", //还是请求该controller的index方法
                blogService.getBlogTotal(map),
                page, 10,
                param.toString()));
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("commonPage", "/foreground/blog/blogList.jsp");
        modelAndView.addObject("title", "博客主页 - 王颖利的博客");
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
