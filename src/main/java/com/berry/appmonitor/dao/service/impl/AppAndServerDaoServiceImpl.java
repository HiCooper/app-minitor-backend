package com.berry.appmonitor.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.dao.entity.AppAndServer;
import com.berry.appmonitor.dao.mapper.AppAndServerMapper;
import com.berry.appmonitor.dao.service.IAppAndServerDaoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-07
 */
@Service
public class AppAndServerDaoServiceImpl extends ServiceImpl<AppAndServerMapper, AppAndServer> implements IAppAndServerDaoService {

}
