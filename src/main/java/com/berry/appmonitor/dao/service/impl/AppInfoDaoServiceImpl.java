package com.berry.appmonitor.dao.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.dao.entity.AppInfo;
import com.berry.appmonitor.dao.mapper.AppInfoMapper;
import com.berry.appmonitor.dao.service.IAppInfoDaoService;
import com.berry.appmonitor.module.vo.AppInfoListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private AppInfoMapper mapper;

    @Override
    public List<AppInfoListVo> pageList(IPage<AppInfoListVo> page, Long ownerId, String keyword) {
        return mapper.pageList(page, ownerId, keyword);
    }
}
