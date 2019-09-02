package com.berry.appmonitor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Properties for whole project.
 * <p>
 * 自定义配置参数建议定义到此，便于管理，不至于混乱
 *
 * @author xueancao
 */
@Component
@ConfigurationProperties(prefix = "global")
@Data
public class GlobalProperties {

    /**
     * 工作区目录
     */
    private String workSpace;

    private final Mail mail = new Mail();

    public static class Mail {

        private boolean enabled;

        private String from;

        private String baseUrl;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }
}
