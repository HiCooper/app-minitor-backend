package com.berry.appmonitor.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.berry.appmonitor.dao.entity.ProjectInfo;
import com.berry.appmonitor.module.vo.ProjectOptionVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-02
 */
public interface ProjectInfoMapper extends BaseMapper<ProjectInfo> {

    @Select("select id, name from project_info where owner_id = #{userId}")
    List<ProjectOptionVo> listAllProject(@Param("userId") String userId);
}
