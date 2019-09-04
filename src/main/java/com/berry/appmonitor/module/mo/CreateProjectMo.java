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
public class CreateProjectMo {

    /**
     * 项目名称
     */
    @NotBlank
    private String name;

    /**
     * 项目主页
     */
    private String homeUrl;

    /**
     * 项目描述
     */
    @NotBlank
    private String description;
}
