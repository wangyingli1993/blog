package me.alent.core.mapper;

import me.alent.core.po.Blog;
import org.springframework.stereotype.Component;

/**
 * @author Alent
 * @since 21:14 2017/3/25
 */

@Component
public interface BlogMapper {

    Integer saveBlog(Blog blog) throws Exception;
}
