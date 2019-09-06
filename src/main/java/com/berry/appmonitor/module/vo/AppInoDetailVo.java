package com.berry.appmonitor.module.vo;

import com.berry.appmonitor.dao.entity.BuildHistory;
import lombok.Data;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-06 22:53
 * fileName：AppInoDetailVo
 * Use：
 */
@Data
public class AppInoDetailVo {

    private String id;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 所属项目id
     */
    private String projectName;

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
    private String username;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    // -----------  构建历史信息 ------------------

    List<BuildHistory> buildHistoryList = Collections.emptyList();
}
