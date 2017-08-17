package me.alent.core.service.impl;

import me.alent.core.mapper.LinkMapper;
import me.alent.core.po.Link;
import me.alent.core.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Alent on 2017/7/20.
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Resource
    private LinkMapper linkMapper;

    @Override
    public List<Link> listLinkByMap(Map<String, Object> map) {
        return linkMapper.listLinkByMap(map);
    }

    @Override
    public List<Link> listLink() {
        return linkMapper.listLink();
    }

    @Override
    public Long getLinkTotal() {
        return linkMapper.getLinkTotal();
    }

    @Override
    public Integer deleteLinkByIds(Integer[] ids) {
        return linkMapper.deleteLinkByIds(ids);
    }

    @Override
    public Integer updateLinkById(Integer id, Link link) {
        return linkMapper.updateLinkById(link);
    }

    @Override
    public Integer saveLink(Link link) {
        return linkMapper.saveLink(link);
    }
}
