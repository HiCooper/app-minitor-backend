package com.berry.appmonitor.security.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.security.dao.entity.Role;
import com.berry.appmonitor.security.dao.mapper.RoleMapper;
import com.berry.appmonitor.security.dao.service.IRoleDaoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HiCooper
 * @since 2018-12-02
 */
@Service
public class RoleDaoServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleDaoService {
}
