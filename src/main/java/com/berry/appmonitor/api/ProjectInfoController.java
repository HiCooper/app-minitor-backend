package com.berry.appmonitor.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.common.Result;
import com.berry.appmonitor.common.ResultFactory;
import com.berry.appmonitor.dao.entity.ProjectInfo;
import com.berry.appmonitor.module.mo.CreateAppInfoMo;
import com.berry.appmonitor.module.mo.CreateProjectMo;
import com.berry.appmonitor.module.mo.UpdateProjectInfoMo;
import com.berry.appmonitor.service.IProjectService;
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
@RequestMapping("/ajax/project")
@Api(tags = "项目管理")
public class ProjectInfoController {

    private final IProjectService projectService;

    public ProjectInfoController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation(value = "分页查询", httpMethod = "GET")
    @GetMapping("page")
    public Result pageList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                  @RequestParam(value = "keyword", required = false) String keyword) {
        IPage<ProjectInfo> page = projectService.pageListProject(pageNum, pageSize, keyword);
        return ResultFactory.wrapper(page);

    }

    @ApiOperation(value = "添加项目", httpMethod = "POST")
    @PostMapping("create")
    public Result createProject(@Validated @RequestBody CreateProjectMo createProjectMo) {
        return ResultFactory.wrapper(projectService.createProject(createProjectMo));
    }

    @GetMapping("list_base")
    public Result listAllProject(){
        return ResultFactory.wrapper(projectService.listAllProject());
    }

    @ApiOperation(value = "详情查询", httpMethod = "GET")
    @GetMapping("detail")
    public Result detailProject(@RequestParam(value = "id") Long id) {
        ProjectInfo projectInfo = projectService.detailProjectById(id);
        return ResultFactory.wrapper(projectInfo);
    }

    @ApiOperation(value = "编辑修改", httpMethod = "POST")
    @PostMapping("update")
    public Result updateProject(@Validated @RequestBody UpdateProjectInfoMo updateProjectInfoMo) {
        boolean result = projectService.updateProject(updateProjectInfoMo);
        return ResultFactory.wrapper(result);
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping("delete")
    public Result deleteProject(@RequestParam(value = "id") Long id) {
        boolean result = projectService.deleteProjectById(id);
        return ResultFactory.wrapper(result);
    }

}
