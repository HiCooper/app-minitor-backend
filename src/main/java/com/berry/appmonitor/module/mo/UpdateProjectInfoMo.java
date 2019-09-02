package com.berry.appmonitor.module.mo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:36
 * fileName：UpdateProjectInfoMo
 * Use：
 */
@Data
public class UpdateProjectInfoMo {

    @NotNull
    private Long id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目描述
     */
    private String description;

}
