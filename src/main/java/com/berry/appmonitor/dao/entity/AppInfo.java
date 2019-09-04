package com.berry.appmonitor.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("app_info")
public class AppInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 所属项目id
     */
    private String projectId;

    /**
     * git仓库地址
     */
    private String gitUrl;

    /**
     * 应用描述
     */
    private String description;

    /**
     * 构建脚本
     */
    private String buildSh;

    /**
     * 自定义运行目录
     */
    private String runPath;

    /**
     * 所有者
     */
    private String ownerId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
