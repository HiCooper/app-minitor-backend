package com.berry.appmonitor.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.common.Result;
import com.berry.appmonitor.common.ResultFactory;
import com.berry.appmonitor.dao.entity.AppInfo;
import com.berry.appmonitor.module.mo.UpdateAppInfoMo;
import com.berry.appmonitor.module.vo.AppInfoListVo;
import com.berry.appmonitor.service.IAppService;
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
 * @since 2019-09-01
 */
@RestController
@RequestMapping("/ajax/app")
@Api(tags = "应用管理")
public class AppInfoController {

    private final IAppService appService;

    public AppInfoController(IAppService appService) {
        this.appService = appService;
    }

    @ApiOperation(value = "分页查询", httpMethod = "GET")
    @GetMapping("page")
    public Result pageListApp(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "keyword", required = false) String keyword
    ) {
        IPage<AppInfoListVo> page = appService.pageListApp(pageNum, pageSize, keyword);
        return ResultFactory.wrapper(page);

    }

    @ApiOperation(value = "详情查询", httpMethod = "GET")
    @GetMapping("detail")
    public Result detailApp(@RequestParam(value = "id") Long id) {
        AppInfo appInfo = appService.detailAppById(id);
        return ResultFactory.wrapper(appInfo);
    }

    @ApiOperation(value = "编辑修改", httpMethod = "POST")
    @PostMapping("update")
    public Result updateApp(@Validated @RequestBody UpdateAppInfoMo updateAppInfoMo) {
        boolean result = appService.updateApp(updateAppInfoMo);
        return ResultFactory.wrapper(result);
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping("delete")
    public Result deleteApp(@RequestParam(value = "id") Long id) {
        boolean result = appService.deleteAppById(id);
        return ResultFactory.wrapper(result);
    }

}
