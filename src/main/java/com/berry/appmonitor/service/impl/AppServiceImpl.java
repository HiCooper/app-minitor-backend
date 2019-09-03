package com.berry.appmonitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.berry.appmonitor.common.ResultCode;
import com.berry.appmonitor.common.exceptions.BaseException;
import com.berry.appmonitor.dao.entity.AppInfo;
import com.berry.appmonitor.dao.service.IAppInfoDaoService;
import com.berry.appmonitor.module.mo.UpdateAppInfoMo;
import com.berry.appmonitor.module.vo.AppInfoListVo;
import com.berry.appmonitor.security.SecurityUtils;
import com.berry.appmonitor.security.dto.UserInfoDTO;
import com.berry.appmonitor.service.IAppService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:02
 * fileName：AppServiceImpl
 * Use：
 */
@Service
public class AppServiceImpl implements IAppService {

    private final IAppInfoDaoService appInfoDaoService;

    public AppServiceImpl(IAppInfoDaoService appInfoDaoService) {
        this.appInfoDaoService = appInfoDaoService;
    }

    @Override
    public IPage<AppInfoListVo> pageListApp(Integer pageNum, Integer pageSize, String keyword) {
        UserInfoDTO currentUser = SecurityUtils.getCurrentUser();
        IPage<AppInfoListVo> page = new Page<>(pageNum, pageSize);
        List<AppInfoListVo> appInfoListVos = appInfoDaoService.pageList(page, currentUser.getId(), keyword);
        page.setRecords(appInfoListVos);
        return page;
    }

    @Override
    public AppInfo detailAppById(Long id) {
        return appInfoDaoService.getById(id);
    }

    @Override
    public boolean updateApp(UpdateAppInfoMo updateAppInfoMo) {
        // 验证当前用户是否拥有该app
        UserInfoDTO currentUser = SecurityUtils.getCurrentUser();
        AppInfo appInfo = appInfoDaoService.getOne(new QueryWrapper<AppInfo>()
                .eq("owner_id", currentUser.getId())
                .eq("id", updateAppInfoMo.getId()));
        if (appInfo == null) {
            throw new BaseException(ResultCode.DATA_NOT_EXIST);
        }
        BeanUtils.copyProperties(updateAppInfoMo, appInfo);
        return appInfoDaoService.updateById(appInfo);
    }

    @Override
    public boolean deleteAppById(Long id) {
        // 验证当前用户是否拥有该app
        UserInfoDTO currentUser = SecurityUtils.getCurrentUser();
        AppInfo appInfo = appInfoDaoService.getOne(new QueryWrapper<AppInfo>()
                .eq("owner_id", currentUser.getId())
                .eq("id", id));
        if (appInfo == null) {
            throw new BaseException(ResultCode.DATA_NOT_EXIST);
        }
        return appInfoDaoService.removeById(id);
    }
}
