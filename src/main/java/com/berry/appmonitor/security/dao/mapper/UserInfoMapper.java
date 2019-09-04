package com.berry.appmonitor.security.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.berry.appmonitor.security.dao.entity.RoleInfo;
import com.berry.appmonitor.security.dao.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author HiCooper
 * @since 2018-12-02
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 根据用户id获取角色
     *
     * @param userId 用户id
     * @return
     */
    Set<RoleInfo> getRolesByUserId(@Param("userId") String userId);
}
