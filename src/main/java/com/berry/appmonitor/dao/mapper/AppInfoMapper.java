package com.berry.appmonitor.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.dao.entity.AppInfo;
import com.berry.appmonitor.module.vo.AppInfoListVo;
import com.berry.appmonitor.module.vo.AppInoDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-01
 */
public interface AppInfoMapper extends BaseMapper<AppInfo> {

    List<AppInfoListVo> pageList(IPage<AppInfoListVo> page,
                                 @Param("ownerId") String ownerId,
                                 @Param("keyword") String keyword);

    AppInoDetailVo detailAppById(@Param("id") Long id, @Param("ownerId") String ownerId);
}
