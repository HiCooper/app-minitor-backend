package com.berry.appmonitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.berry.appmonitor.common.ResultCode;
import com.berry.appmonitor.common.exceptions.BaseException;
import com.berry.appmonitor.common.utils.StringUtils;
import com.berry.appmonitor.dao.entity.ProjectInfo;
import com.berry.appmonitor.dao.service.IProjectInfoDaoService;
import com.berry.appmonitor.module.mo.CreateProjectMo;
import com.berry.appmonitor.module.mo.UpdateProjectInfoMo;
import com.berry.appmonitor.security.SecurityUtils;
import com.berry.appmonitor.security.dto.UserInfoDTO;
import com.berry.appmonitor.service.IProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:33
 * fileName：ProjectServiceImpl
 * Use：
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectInfoDaoService projectInfoDaoService;

    public ProjectServiceImpl(IProjectInfoDaoService projectInfoDaoService) {
        this.projectInfoDaoService = projectInfoDaoService;
    }

    @Override
    public IPage<ProjectInfo> pageListProject(Integer pageNum, Integer pageSize, String keyword) {
        UserInfoDTO currentUser = SecurityUtils.getCurrentUser();
        IPage<ProjectInfo> page = new Page<>(pageNum, pageSize);
        QueryWrapper<ProjectInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("owner_id", currentUser.getId());
        if (StringUtils.isNotBlank(keyword)) {
            queryWrapper.like("name", keyword);
        }
        projectInfoDaoService.page(page, queryWrapper);
        return page;
    }

    @Override
    public boolean createProject(CreateProjectMo createProjectMo) {
        // 1.项目名不能重复
        ProjectInfo projectInfo = projectInfoDaoService.getOne(new QueryWrapper<ProjectInfo>().eq("name", createProjectMo.getName()));
        if (projectInfo != null) {
            throw new BaseException("403", "项目名已经存在");
        }
        projectInfo = new ProjectInfo();
        BeanUtils.copyProperties(createProjectMo, projectInfo);
        UserInfoDTO currentUser = SecurityUtils.getCurrentUser();
        projectInfo.setOwnerId(currentUser.getId());
        return projectInfoDaoService.save(projectInfo);
    }

    @Override
    public ProjectInfo detailProjectById(Long id) {
        return projectInfoDaoService.getById(id);
    }

    @Override
    public boolean updateProject(UpdateProjectInfoMo updateProjectInfoMo) {
        // 验证当前用户是否拥有该项目
        UserInfoDTO currentUser = SecurityUtils.getCurrentUser();
        ProjectInfo projectInfo = projectInfoDaoService.getOne(new QueryWrapper<ProjectInfo>()
                .eq("owner_id", currentUser.getId())
                .eq("id", updateProjectInfoMo.getId()));
        if (projectInfo == null) {
            throw new BaseException(ResultCode.DATA_NOT_EXIST);
        }
        BeanUtils.copyProperties(updateProjectInfoMo, projectInfo);
        return projectInfoDaoService.updateById(projectInfo);
    }

    @Override
    public boolean deleteProjectById(Long id) {
        // 验证当前用户是否拥有该app
        UserInfoDTO currentUser = SecurityUtils.getCurrentUser();
        ProjectInfo projectInfo = projectInfoDaoService.getOne(new QueryWrapper<ProjectInfo>()
                .eq("owner_id", currentUser.getId())
                .eq("id", id));
        if (projectInfo == null) {
            throw new BaseException(ResultCode.DATA_NOT_EXIST);
        }
        return projectInfoDaoService.removeById(id);
    }
}
