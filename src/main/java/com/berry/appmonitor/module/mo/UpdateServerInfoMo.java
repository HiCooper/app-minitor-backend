package com.berry.appmonitor.module.mo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:46
 * fileName：UpdateServerInfoMo
 * Use：
 */
@Data
public class UpdateServerInfoMo {

    @NotNull
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * ip
     */
    private String ip;
}
