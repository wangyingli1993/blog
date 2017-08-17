package me.alent.core.controller;

import me.alent.core.po.Blog;
import me.alent.core.service.BlogService;
import me.alent.core.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alent on 2017/7/22.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private CommentService commentService;

    /**
     * 博客详情
     * @param id
     * @return
     */
    @RequestMapping("/articles/{id}")
    public ModelAndView article(@PathVariable("id") Integer id, HttpServletRequest request) {
        Blog blog = blogService.getBlogById(id);
        ModelAndView modelAndView = new ModelAndView();
        String keyWords = blog.getKeyWord();
        if(!StringUtils.isEmpty(keyWords)) {
            modelAndView.addObject("keyWords", Arrays.asList(keyWords.split(" ")));
        }
        blog.setClickHit(blog.getClickHit()+1); // 博客点击次数加1
        blogService.updateBlogById(blog, blog.getId());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("blogId", blog.getId());
        map.put("state", 1); // 查询审核通过的评论
        modelAndView.addObject("commentList", commentService.listCommentByMap(map));
        modelAndView.addObject("pageCode", this.genUpAndDownPageCode(blogService.getBlogById(id+1),blogService.getBlogById(id-1),request.getServletContext().getContextPath()));
        modelAndView.addObject("blogItem", blog);
        modelAndView.addObject("commonPage", "/foreground/blog/blogDetail.jsp");
        modelAndView.setViewName("main");
        return modelAndView;
        
    }

    /**
     * 获取下一篇博客和下一篇博客代码
     * @param lastBlog
     * @param nextBlog
     * @return
     */
    private String genUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
        StringBuffer pageCode=new StringBuffer();
        if(lastBlog==null || lastBlog.getId()==null){
            pageCode.append("<p>上一篇：没有了</p>");
        }else{
            pageCode.append("<p>上一篇：<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
        }
        if(nextBlog==null || nextBlog.getId()==null){
            pageCode.append("<p>下一篇：没有了</p>");
        }else{
            pageCode.append("<p>下一篇：<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
        }
        return pageCode.toString();
    }

    /**
     * 获取上一页，下一页代码 查询博客用到
     * @param page 当前页
     * @param totalNum 总记录数
     * @param q 查询关键字
     * @param pageSize 每页大小
     * @param projectContext
     * @return
     */
    private String genUpAndDownPageCode(Integer page,Integer totalNum,String q,Integer pageSize,String projectContext){
        long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        StringBuffer pageCode=new StringBuffer();
        if(totalPage==0){
            return "";
        }else{
            pageCode.append("<nav>");
            pageCode.append("<ul class='pager' >");
            if(page>1){
                pageCode.append("<li><a href='"+projectContext+"/blog/q.html?page="+(page-1)+"&q="+q+"'>上一页</a></li>");
            }else{
                pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
            }
            if(page<totalPage){
                pageCode.append("<li><a href='"+projectContext+"/blog/q.html?page="+(page+1)+"&q="+q+"'>下一页</a></li>");
            }else{
                pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
            }
            pageCode.append("</ul>");
            pageCode.append("</nav>");
        }
        return pageCode.toString();
    }
}
