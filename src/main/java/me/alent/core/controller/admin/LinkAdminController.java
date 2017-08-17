package me.alent.core.controller.admin;

import me.alent.common.util.ResponseUtil;
import me.alent.core.po.Link;
import me.alent.core.po.PaginationBean;
import me.alent.core.service.LinkService;
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
@RequestMapping("/admin/link")
public class LinkAdminController {

    @Resource
    private LinkService linkService;

    /**
     *  分页显示链接信息
     * @param page 第几页
     * @param rows 每页显示行
     * @return
     */
    @RequestMapping("/listLink")
    public  @ResponseBody
    PaginationBean<Link> listLink(Integer page, Integer rows) throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("pageSize", rows);
        map.put("start", (page-1)*rows);
        List<Link> linkList = linkService.listLinkByMap(map);
        Long total = linkService.getLinkTotal();

        PaginationBean<Link> result = new PaginationBean<Link>();
        result.setRows(linkList);
        result.setTotal(total);
        return result;
    }

   /**
     * 删除链接
     * @param ids
     * @param response
     */
    @RequestMapping("/delete")
    public void deleteComments(String ids, HttpServletResponse response) {
        String[] str = ids.split(",");
        Integer[] linkIds = new Integer[str.length];
        for(int i=0; i<str.length; i++) {
            linkIds[i] = Integer.parseInt(str[i]);
        }
        String result = null;
        if(linkService.deleteLinkByIds(linkIds) != null) {
            result = "{\"success\":1}";
        } else {
            result = "{\"success\":0}";
        }
        ResponseUtil.renderJson(response, result);
    }

    /**
     * 保存或修改链接
     * @param link
     * @param response
     */
    @RequestMapping("/save")
    public void save(Link link, HttpServletResponse response) {
        Integer num = null;
        if(link.getId() != null) {
            num = linkService.updateLinkById(link.getId(), link);
        }else {
            num = linkService.saveLink(link);
        }
        String result = null;
        if(num != null) {
            result = "{\"success\":1}";
        } else {
            result = "{\"success\":0}";
        }
        ResponseUtil.renderJson(response, result);
    }
}
