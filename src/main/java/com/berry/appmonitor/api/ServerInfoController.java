package com.berry.appmonitor.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.common.Result;
import com.berry.appmonitor.common.ResultFactory;
import com.berry.appmonitor.dao.entity.ServerInfo;
import com.berry.appmonitor.module.mo.CreateServerMo;
import com.berry.appmonitor.module.mo.UpdateServerInfoMo;
import com.berry.appmonitor.service.IServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author HiCooper
 * @since 2019-09-02
 */
@RestController
@RequestMapping("/ajax/server")
@Api(tags = "服务器管理")
public class ServerInfoController {

    private final IServerService serverService;

    public ServerInfoController(IServerService serverService) {
        this.serverService = serverService;
    }

    @ApiOperation(value = "分页查询", httpMethod = "GET")
    @GetMapping("page")
    public Result pageListServer(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "keyword", required = false) String keyword) {
        IPage<ServerInfo> page = serverService.pageListServer(pageNum, pageSize, keyword);
        return ResultFactory.wrapper(page);

    }


    @ApiOperation(value = "添加应用", httpMethod = "POST")
    @PostMapping("create")
    public Result createServer(@Validated @RequestBody CreateServerMo createServerMo) {
        return ResultFactory.wrapper(serverService.createServer(createServerMo));
    }

    @ApiOperation(value = "详情查询", httpMethod = "GET")
    @GetMapping("detail")
    public Result detailServer(@RequestParam(value = "id") Long id) {
        ServerInfo serverInfo = serverService.detailServerById(id);
        return ResultFactory.wrapper(serverInfo);
    }

    @ApiOperation(value = "编辑修改", httpMethod = "POST")
    @PostMapping("update")
    public Result updateServer(@Validated @RequestBody UpdateServerInfoMo updateServerInfoMo) {
        boolean result = serverService.updateServer(updateServerInfoMo);
        return ResultFactory.wrapper(result);
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping("delete")
    public Result deleteServer(@RequestParam(value = "id") Long id) {
        boolean result = serverService.deleteServerById(id);
        return ResultFactory.wrapper(result);
    }

}
