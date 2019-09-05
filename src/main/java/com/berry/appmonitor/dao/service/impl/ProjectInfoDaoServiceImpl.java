package com.berry.appmonitor.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.dao.entity.ProjectInfo;
import com.berry.appmonitor.dao.mapper.ProjectInfoMapper;
import com.berry.appmonitor.dao.service.IProjectInfoDaoService;
import com.berry.appmonitor.module.vo.ProjectOptionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-02
 */
@Service
public class ProjectInfoDaoServiceImpl extends ServiceImpl<ProjectInfoMapper, ProjectInfo> implements IProjectInfoDaoService {


    @Resource
    private ProjectInfoMapper mapper;

    @Override
    public List<ProjectOptionVo> listAllProject(String userId) {
        return mapper.listAllProject(userId);
    }
}
