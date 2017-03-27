package me.alent.core.po;

import java.util.Date;

/**
 * 博客类
 * @author Alent
 * @since 21:05 2017/3/25
 */

public class Blog {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private Date createTime;
    private Date publishTime;
    private boolean state;
    private Integer readNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public boolean isState() {
        return state;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", publishTime=" + publishTime +
                ", state=" + state +
                ", readNum=" + readNum +
                '}';
    }
}
