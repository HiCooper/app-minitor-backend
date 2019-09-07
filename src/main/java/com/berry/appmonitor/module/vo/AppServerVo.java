package com.berry.appmonitor.module.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-07 09:55
 * fileName：AppServerVo
 * Use：
 */
@Data
public class AppServerVo {

    private String name;
    private String ip;
    private String serverPort;
    private String state;
}
