package com.shen.oss.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbPermission)实体类
 *
 * @author makejava
 * @since 2021-08-10 14:01:22
 */
public class TbPermission implements Serializable {
    private static final long serialVersionUID = -41399679415259311L;
    /**
    * 主键ID
    */
    private Long id;
    /**
    * 用户ID
    */
    private Long parentId;
    /**
    * 权限名字
    */
    private String name;
    /**
    * 权限名字
    */
    private String ename;
    /**
    * 请求路径
    */
    private String url;
    /**
    * 描述
    */
    private String description;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
