package com.berry.appmonitor.security.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.security.dao.entity.RoleInfo;
import com.berry.appmonitor.security.dao.entity.UserInfo;
import com.berry.appmonitor.security.dao.mapper.UserInfoMapper;
import com.berry.appmonitor.security.dao.service.IUserInfoDaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HiCooper
 * @since 2018-12-02
 */
@Service
public class UserInfoDaoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoDaoService {

    @Resource
    private UserInfoMapper userMapper;

    @Override
    public Optional<UserInfo> findOneByUsername(String lowercaseLogin) {
        return Optional.ofNullable(userMapper.selectOne(new QueryWrapper<UserInfo>().eq("username", lowercaseLogin)));
    }

    @Override
    public Set<RoleInfo> findRoleListByUserId(String userId) {
        return userMapper.getRolesByUserId(userId);
    }
}
