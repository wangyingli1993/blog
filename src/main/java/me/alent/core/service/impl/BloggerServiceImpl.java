package me.alent.core.service.impl;

import me.alent.core.mapper.BloggerMapper;
import me.alent.core.po.Blogger;
import me.alent.core.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Alent on 2017/7/24.
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
    @Resource
    private BloggerMapper bloggerMapper;

    @Override
    public Blogger getBloggerByUserName(String userName) {
        return bloggerMapper.getBloggerByUserName(userName);
    }

    @Override
    public Blogger getBlogger() {
        return bloggerMapper.getBlogger();
    }

    @Override
    public Integer updateBlogger(Blogger blogger) {
        return bloggerMapper.updateBlogger(blogger);
    }
}
