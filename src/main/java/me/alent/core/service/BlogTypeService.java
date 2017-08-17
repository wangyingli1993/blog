package me.alent.core.service;

import me.alent.core.po.BlogType;

import java.util.List;

/**
 * Created by Alent on 2017/7/13.
 */
public interface BlogTypeService {
    /**
     * 添加
     * @param blogType
     */
    Integer saveBlogType(BlogType blogType);

    /**
     * 删除
     * @param ids
     */
    Integer deleteBlogTypeById(Integer[] ids);

    /**
     * 更新
     * @param blogType
     */
    Integer updateBlogTypeById(BlogType blogType, Integer id);

    /**
     * 分页查询博客类型, 不使用@Param注解，参数只能有一个
     * @param start
     * @param size
     * @return
     */
    List<BlogType> listBlogType(Integer start, Integer size);

    /**
     * 查询所有类型
     * @return
     */
    List<BlogType> listBlog();

    /**
     * 博客类型总数
     * @return
     */
    Long getBlogTypeTotal();
}
