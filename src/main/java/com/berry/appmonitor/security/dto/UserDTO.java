package com.berry.appmonitor.security.dto;

import com.berry.appmonitor.security.dao.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2018-12-02 23:27
 * fileName：UserDTO
 * Use：
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 激活状态
     */
    private Boolean activated;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 上次修改时间
     */
    private LocalDateTime updateTime;

    @JsonIgnore
    private Set<Role> roleSet;
}
