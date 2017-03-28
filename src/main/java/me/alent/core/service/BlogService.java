package me.alent.core.service;

import me.alent.core.po.Blog;

/**
 * blog的增删改查操作
 *
 * Created by Alent on 2017/3/28.
 */
public interface BlogService {
    /**
     * 保存博客
     *
     * @param blog
     * @return
     * @throws Exception
     */
    Integer saveBlog(Blog blog) throws Exception;
}
