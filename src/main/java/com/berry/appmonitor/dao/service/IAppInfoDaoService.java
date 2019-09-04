package com.berry.appmonitor.dao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.berry.appmonitor.dao.entity.AppInfo;
import com.berry.appmonitor.module.vo.AppInfoListVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-01
 */
public interface IAppInfoDaoService extends IService<AppInfo> {

    List<AppInfoListVo> pageList(IPage<AppInfoListVo> page, String id, String keyword);
}
