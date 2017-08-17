package me.alent.core.service.impl;

import me.alent.core.mapper.BlogTypeMapper;
import me.alent.core.po.BlogType;
import me.alent.core.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alent on 2017/7/13.
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeMapper blogTypeMapper;

    @Override
    public Integer saveBlogType(BlogType blogType) {
        return blogTypeMapper.saveBlogType(blogType);
    }

    @Override
    public Integer deleteBlogTypeById(Integer[] ids) {
        return blogTypeMapper.deleteBlogTypeById(ids);
    }

    @Override
    public Integer updateBlogTypeById(BlogType blogType, Integer id) {
        blogType.setId(id);
        return blogTypeMapper.updateBlogTypeById(blogType);
    }

    @Override
    public List<BlogType> listBlogType(Integer start, Integer size) {
        return blogTypeMapper.listBlogType(start, size);
    }

    @Override
    public List<BlogType> listBlog() {
        return blogTypeMapper.listBlog();
    }

    @Override
    public Long getBlogTypeTotal() {
        return blogTypeMapper.getBlogTypeTotal();
    }
}
