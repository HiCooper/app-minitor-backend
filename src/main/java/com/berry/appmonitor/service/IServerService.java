package com.berry.appmonitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.dao.entity.ServerInfo;
import com.berry.appmonitor.module.mo.CreateServerMo;
import com.berry.appmonitor.module.mo.UpdateServerInfoMo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Berry_Cooper.
 * @date 2019-09-02 22:42
 * fileName：IServerService
 * Use：
 */
public interface IServerService {

    /**
     * 分页查询 列表
     *
     * @param pageNum  当前页码
     * @param pageSize 分页大小
     * @param keyword  搜索关键字
     * @return
     */
    IPage<ServerInfo> pageListServer(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 查询 详情
     *
     * @param id 主键id
     * @return
     */
    ServerInfo detailServerById(Long id);

    /**
     * 更新 信息
     *
     * @param updateServerInfoMo 请求对象
     * @return
     */
    boolean updateServer(UpdateServerInfoMo updateServerInfoMo);

    /**
     * 根据主键id 删除
     *
     * @param id 主键id
     * @return
     */
    boolean deleteServerById(Long id);

    /**
     * 添加服务器
     *
     * @param createServerMo
     * @return
     */
    boolean createServer(CreateServerMo createServerMo);
}
