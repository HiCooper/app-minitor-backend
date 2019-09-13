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
    /**
     * 运行状态，这里暂给 succss，
     * 所有状态：['default', 'processing', 'success', 'error'];
     * 分别对应：['已关闭', '启动中', '运行中', '异常'];
     */
    private String state = "success";
}
