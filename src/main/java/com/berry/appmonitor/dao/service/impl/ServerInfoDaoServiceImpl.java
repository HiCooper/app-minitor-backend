package com.berry.appmonitor.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.dao.entity.ServerInfo;
import com.berry.appmonitor.dao.mapper.ServerInfoMapper;
import com.berry.appmonitor.dao.service.IServerInfoDaoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-02
 */
@Service
public class ServerInfoDaoServiceImpl extends ServiceImpl<ServerInfoMapper, ServerInfo> implements IServerInfoDaoService {

}
