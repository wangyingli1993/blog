package me.alent.core.mapper;

import me.alent.core.po.Link;

import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/20.
 */
public interface LinkMapper {
    /**
     * 分页查询链接
     * @param map
     * @return
     */
    List<Link> listLinkByMap(Map<String, Object> map);

    /**
     * 查询所有连接
     * @return
     */
    List<Link> listLink();

    /**
     * 查询链接总数
     * @return
     */
    Long getLinkTotal();

    /**
     * 删除链接
     * @param ids
     * @return
     */
    Integer deleteLinkByIds(Integer[] ids);

    /**
     * 更新链接
     * @return
     */
    Integer updateLinkById(Link link);

    /**
     * 添加链接
     * @param link
     * @return
     */
    Integer saveLink(Link link);
}
