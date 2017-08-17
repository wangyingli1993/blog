package me.alent.core.mapper;

import me.alent.core.po.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/12.
 */
public interface BlogMapper {



    /**
     *  分页查询博客信息
     * @param map
     * @return
     */
    List<Blog> listBlogByMap(Map<String, Object> map);

    /**
     * 查询博客总数
     * @param map
     * @return
     */
    Long getBlogTotal(Map<String, Object> map);

    /**
     * 根据id查询博客
     * @param id
     * @return
     */
    Blog getBlogById(Integer id);

    /**
     * 添加博客
     * @param blog
     * @return
     */
    Integer saveBlog(Blog blog);

    /**
     * 删除博客
     * @param ids
     * @return
     */
    Integer deleteBlogByIds(Integer[] ids);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    Integer updateBlogById(Blog blog);
}
