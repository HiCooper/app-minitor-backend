package com.berry.appmonitor.module.mo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:15
 * fileName：UpdateAppInfoMo
 * Use：
 */
@Data
public class UpdateAppInfoMo {

    @NotNull
    private Long id;

    /**
     * 应用名称
     */
    private String name;

    /**
     * 所属项目id
     */
    private Long projectId;

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
}
