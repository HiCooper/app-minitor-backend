package com.berry.appmonitor.security.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.berry.appmonitor.security.dao.entity.RoleInfo;
import com.berry.appmonitor.security.dao.entity.UserInfo;

import java.util.Optional;
import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author HiCooper
 * @since 2018-12-02
 */
public interface IUserInfoDaoService extends IService<UserInfo> {

    /**
     * 根据用户名获取用户
     *
     * @param lowercaseLogin
     * @return
     */
    Optional<UserInfo> findOneByUsername(String lowercaseLogin);

    /**
     * 根据用户id获取角色列表
     *
     * @param userId
     * @return
     */
    Set<RoleInfo> findRoleListByUserId(String userId);
}
