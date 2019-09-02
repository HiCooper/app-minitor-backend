package com.berry.appmonitor.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ServerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * ip
     */
    private String ip;

    /**
     * 公钥登陆状态
     */
    private Boolean publicKeyLogin;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
