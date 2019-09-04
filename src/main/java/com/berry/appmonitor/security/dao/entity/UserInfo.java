package com.berry.appmonitor.security.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 *
 * </p>
 *
 * @author HiCooper
 * @since 2018-12-02
 */
@Data
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 激活状态
     */
    private boolean activated = false;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上次修改时间
     */
    private Date updateTime;

}
