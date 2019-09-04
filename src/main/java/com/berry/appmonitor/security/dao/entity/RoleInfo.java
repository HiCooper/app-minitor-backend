package com.berry.appmonitor.security.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author HiCooper
 * @since 2018-12-02
 */
@Data
@TableName("role_info")
public class RoleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String description;


}
