package me.alent.core.service.impl;

import me.alent.core.mapper.BlogMapper;
import me.alent.core.po.Blog;
import me.alent.core.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Alent on 2017/3/28.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public Integer saveBlog(Blog blog) throws Exception {
        return blogMapper.saveBlog(blog);
    }
}
