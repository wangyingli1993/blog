package me.alent.core.mapper;

import me.alent.core.po.Blogger;

/**
 * Created by Alent on 2017/7/24.
 */
public interface BloggerMapper {

    //通过用户名查询博主
    public Blogger getBloggerByUserName(String userName);

    //获取博主信息
    public Blogger getBlogger();

    // 更新博主个人信息
    public Integer updateBlogger(Blogger blogger);
}
