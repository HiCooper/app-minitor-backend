package com.berry.appmonitor.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.berry.appmonitor.dao.entity.BuildHistory;
import com.berry.appmonitor.dao.mapper.BuildHistoryMapper;
import com.berry.appmonitor.dao.service.IBuildHistoryDaoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-06
 */
@Service
public class BuildHistoryDaoServiceImpl extends ServiceImpl<BuildHistoryMapper, BuildHistory> implements IBuildHistoryDaoService {

}
