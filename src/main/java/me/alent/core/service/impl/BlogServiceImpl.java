package me.alent.core.service.impl;

import me.alent.core.mapper.BlogMapper;
import me.alent.core.po.Blog;
import me.alent.core.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/12.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;
    @Override
    public List<Blog> listBlogByMap(Map<String, Object> map) {
        return blogMapper.listBlogByMap(map);
    }

    @Override
    public Long getBlogTotal(Map<String, Object> map) {
        return blogMapper.getBlogTotal(map);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogMapper.getBlogById(id);
    }


    @Override
    public Integer saveBlog(Blog blog) {
        return blogMapper.saveBlog(blog);
    }

    @Override
    public Integer deleteBlogByIds(Integer[] ids) {
        return blogMapper.deleteBlogByIds(ids);
    }

    @Override
    public Integer updateBlogById(Blog blog, Integer id) {
        blog.setId(id);
        return blogMapper.updateBlogById(blog);
    }
}
