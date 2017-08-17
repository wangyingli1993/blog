package me.alent.core.service.impl;

import me.alent.core.mapper.CommentMapper;
import me.alent.core.po.Comment;
import me.alent.core.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/20.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public List<Comment> listCommentByMap(Map<String, Object> map) {
        return commentMapper.listCommentByMap(map);
    }

    @Override
    public Long getCommentTotal() {
        return commentMapper.getCommentTotal();
    }

    @Override
    public Integer deleteCommentByIds(Integer[] ids) {
        return commentMapper.deleteCommentByIds(ids);
    }

    @Override
    public Integer updateCommentByIds(Map<String, Object> map) {
        return commentMapper.updateCommentByIds(map);
    }

}
