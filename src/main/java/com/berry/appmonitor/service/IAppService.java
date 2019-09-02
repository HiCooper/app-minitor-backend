package com.berry.appmonitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.dao.entity.AppInfo;
import com.berry.appmonitor.module.mo.UpdateAppInfoMo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:01
 * fileName：IAppService
 * Use：
 */
public interface IAppService {
    /**
     * 分页查询 app 列表
     *
     * @param pageNum  当前页码
     * @param pageSize 分页大小
     * @param keyword  搜索关键字
     * @return
     */
    IPage<AppInfo> pageListApp(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 查询 app 详情
     *
     * @param id app 主键id
     * @return
     */
    AppInfo detailAppById(Long id);

    /**
     * 更新 app 信息
     *
     * @param updateAppInfoMo 请求对象
     * @return
     */
    boolean updateApp(UpdateAppInfoMo updateAppInfoMo);

    /**
     * 根据主键id 删除 app
     *
     * @param id 主键id
     * @return
     */
    boolean deleteAppById(Long id);
}
