package com.berry.appmonitor.common.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Application constants.
 */
public final class Constants {

    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_LANGUAGE = "en";
    /**
     * 心跳检查url
     */
    public static final String HEALTH_CHECK_URL = "/actuator/health";

    /**
     * 错误状态响应
     */
    public static final String ERROR_STATE_URL = "/error";

    public static final List<String> WRITE_LIST = new ArrayList<>();

    // 过滤器，拦截器白名单
    static {
        WRITE_LIST.add("/swagger.+");
        WRITE_LIST.add("/csrf");
        WRITE_LIST.add("/v2/ajax-docs");
        WRITE_LIST.add("/webjars/.+");
        WRITE_LIST.add(HEALTH_CHECK_URL);
        WRITE_LIST.add(ERROR_STATE_URL);
    }

    private Constants() {
    }
}
