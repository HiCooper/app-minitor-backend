package com.berry.appmonitor.security.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.security.dao.entity.RoleInfo;
import com.berry.appmonitor.security.dao.mapper.RoleInfoMapper;
import com.berry.appmonitor.security.dao.service.IRoleInfoDaoService;
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
public class RoleInfoDaoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements IRoleInfoDaoService {
}
