package com.berry.appmonitor.module.mo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:15
 * fileName：UpdateAppInfoMo
 * Use：
 */
@Data
public class CreateAppInfoMo {

    /**
     * 应用名称
     */
    @NotBlank
    private String name;

    /**
     * 所属项目id
     */
    private String projectId;

    /**
     * git仓库地址
     */
    @NotBlank
    private String gitUrl;

    /**
     * 应用描述
     */
    @NotBlank
    private String description;
}
