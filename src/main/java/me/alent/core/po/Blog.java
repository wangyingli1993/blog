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
    private String contentMarkdown;
    private String contentHtml;
    private Date createTime;
    private Date publishTime;
    private Boolean state;
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

    public Date getCreateTime() {
        return createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean isState() {
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

    public String getContentMarkdown() {
        return contentMarkdown;
    }

    public void setContentMarkdown(String contentMarkdown) {
        this.contentMarkdown = contentMarkdown;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", contentMarkdown='" + contentMarkdown + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                ", createTime=" + createTime +
                ", publishTime=" + publishTime +
                ", state=" + state +
                ", readNum=" + readNum +
                '}';
    }
}
