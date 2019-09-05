package com.berry.appmonitor.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.berry.appmonitor.dao.entity.ProjectInfo;
import com.berry.appmonitor.module.vo.ProjectOptionVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-02
 */
public interface IProjectInfoDaoService extends IService<ProjectInfo> {

    List<ProjectOptionVo> listAllProject(String id);
}
