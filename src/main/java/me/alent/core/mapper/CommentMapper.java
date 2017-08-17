package me.alent.core.mapper;

import me.alent.core.po.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/20.
 */
public interface CommentMapper {

    /**
     * 分页查询评论
     * @param map
     * @return
     */
    List<Comment> listCommentByMap(Map<String, Object> map);

    /**
     * 查询评论总数
     * @return
     */
    Long getCommentTotal();

    /**
     * 删除评论
     * @param ids
     * @return
     */
    Integer deleteCommentByIds(Integer[] ids);

    /**
     * 更新评论状态
     * @param map
     * @return
     */
    Integer updateCommentByIds(Map<String, Object> map);
}
