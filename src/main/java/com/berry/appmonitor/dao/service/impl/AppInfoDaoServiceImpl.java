package com.berry.appmonitor.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.dao.entity.AppInfo;
import com.berry.appmonitor.dao.mapper.AppInfoMapper;
import com.berry.appmonitor.dao.service.IAppInfoDaoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-01
 */
@Service
public class AppInfoDaoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements IAppInfoDaoService {

}
