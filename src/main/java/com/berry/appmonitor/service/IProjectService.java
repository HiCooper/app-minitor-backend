package com.berry.appmonitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.dao.entity.ProjectInfo;
import com.berry.appmonitor.module.mo.CreateProjectMo;
import com.berry.appmonitor.module.mo.UpdateProjectInfoMo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:33
 * fileName：IProjectService
 * Use：
 */
public interface IProjectService {
    /**
     * 分页查询 列表
     *
     * @param pageNum  当前页码
     * @param pageSize 分页大小
     * @param keyword  搜索关键字
     * @return
     */
    IPage<ProjectInfo> pageListProject(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 查询 详情
     *
     * @param id 主键id
     * @return
     */
    ProjectInfo detailProjectById(Long id);

    /**
     * 更新 信息
     *
     * @param updateProjectInfoMo 请求对象
     * @return
     */
    boolean updateProject(UpdateProjectInfoMo updateProjectInfoMo);

    /**
     * 根据主键id 删除
     *
     * @param id 主键id
     * @return
     */
    boolean deleteProjectById(Long id);

    /**
     * 项目创建
     * @param createProjectMo
     * @return
     */
    boolean createProject(CreateProjectMo createProjectMo);
}
