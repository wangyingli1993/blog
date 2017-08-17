package me.alent.core.controller.admin;

import me.alent.common.util.ResponseUtil;
import me.alent.core.po.Comment;
import me.alent.core.po.PaginationBean;
import me.alent.core.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/20.
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {

    @Resource
    private CommentService commentService;

    /**
     *  分页显示评论信息
     * @param page 第几页
     * @param rows 每页显示行
     * @return
     */
    @RequestMapping("/listComment")
    public  @ResponseBody
    PaginationBean<Comment> listComment(Integer page, Integer rows) throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("pageSize", rows);
        map.put("start", (page-1)*rows);
        List<Comment> commentList = commentService.listCommentByMap(map);
        Long total = commentService.getCommentTotal();

        PaginationBean<Comment> result = new PaginationBean<Comment>();
        result.setRows(commentList);
        result.setTotal(total);
        return result;
    }

    /**
     * 删除博客
     * @param ids
     * @param response
     */
    @RequestMapping("/deleteComment")
    public void deleteComments(String ids, HttpServletResponse response) {
        String[] str = ids.split(",");
        Integer[] commentIds = new Integer[str.length];
        for(int i=0; i<str.length; i++) {
            commentIds[i] = Integer.parseInt(str[i]);
        }
        String result = null;
        if(commentService.deleteCommentByIds(commentIds) != null) {
            result = "{\"success\":1}";
        } else {
            result = "{\"success\":0}";
        }
        ResponseUtil.renderJson(response, result);
    }

    /**
     * 审核评论
     * @param ids
     * @param response
     */
    @RequestMapping("/review")
    public void reviewComments(String ids, Integer state, HttpServletResponse response) {
        String[] str = ids.split(",");
        Integer[] commentIds = new Integer[str.length];
        for(int i=0; i<str.length; i++) {
            commentIds[i] = Integer.parseInt(str[i]);
        }
        Map<String, Object> map = new HashMap();
        map.put("ids", commentIds);
        map.put("state", state);
        String result = null;
        if(commentService.updateCommentByIds(map) != null) {
            result = "{\"success\":1}";
        } else {
            result = "{\"success\":0}";
        }
        ResponseUtil.renderJson(response, result);
    }
}
