package com.berry.appmonitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.berry.appmonitor.common.ResultCode;
import com.berry.appmonitor.common.exceptions.BaseException;
import com.berry.appmonitor.common.utils.StringUtils;
import com.berry.appmonitor.dao.entity.ServerInfo;
import com.berry.appmonitor.dao.service.IServerInfoDaoService;
import com.berry.appmonitor.module.mo.CreateServerMo;
import com.berry.appmonitor.module.mo.UpdateServerInfoMo;
import com.berry.appmonitor.service.IServerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:42
 * fileName：ServerServiceImpl
 * Use：
 */
@Service
public class ServerServiceImpl implements IServerService {

    private final IServerInfoDaoService serverInfoDaoService;

    public ServerServiceImpl(IServerInfoDaoService serverInfoDaoService) {
        this.serverInfoDaoService = serverInfoDaoService;
    }


    @Override
    public IPage<ServerInfo> pageListServer(Integer pageNum, Integer pageSize, String keyword) {
        IPage<ServerInfo> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ServerInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            queryWrapper
                    .like("name", keyword)
                    .or()
                    .like("ip", keyword);
        }
        serverInfoDaoService.page(page, queryWrapper);
        return page;
    }

    @Override
    public boolean createServer(CreateServerMo createServerMo) {
        int count = serverInfoDaoService.count(new QueryWrapper<ServerInfo>()
                .eq("name", createServerMo.getName())
                .or()
                .eq("ip", createServerMo.getIp()));
        if (count > 0) {
            throw new BaseException("403", "服务器名称或ip已存在");
        }
        ServerInfo serverInfo = new ServerInfo();
        BeanUtils.copyProperties(createServerMo, serverInfo);
        return serverInfoDaoService.save(serverInfo);
    }

    @Override
    public ServerInfo detailServerById(Long id) {
        return serverInfoDaoService.getById(id);
    }

    @Override
    public boolean updateServer(UpdateServerInfoMo updateServerInfoMo) {
        ServerInfo serverInfo = serverInfoDaoService.getById(updateServerInfoMo.getId());
        if (serverInfo == null) {
            throw new BaseException(ResultCode.DATA_NOT_EXIST);
        }
        BeanUtils.copyProperties(updateServerInfoMo, serverInfo);
        return serverInfoDaoService.updateById(serverInfo);
    }

    @Override
    public boolean deleteServerById(Long id) {
        ServerInfo serverInfo = serverInfoDaoService.getById(id);
        if (serverInfo == null) {
            throw new BaseException(ResultCode.DATA_NOT_EXIST);
        }
        return serverInfoDaoService.removeById(id);
    }
}
