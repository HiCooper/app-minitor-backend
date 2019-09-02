package com.berry.appmonitor.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.berry.appmonitor.common.Result;
import com.berry.appmonitor.common.ResultFactory;
import com.berry.appmonitor.dao.entity.ProjectInfo;
import com.berry.appmonitor.module.mo.UpdateProjectInfoMo;
import com.berry.appmonitor.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/project")
@Api(tags = "项目管理")
public class ProjectInfoController {

    private final IProjectService pageListProject;

    public ProjectInfoController(IProjectService pageListProject) {
        this.pageListProject = pageListProject;
    }

    @ApiOperation(value = "分页查询", httpMethod = "GET")
    @GetMapping("page")
    public Result pageListProject(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                  @RequestParam(value = "keyword", defaultValue = "1") String keyword
    ) {
        IPage<ProjectInfo> page = pageListProject.pageListProject(pageNum, pageSize, keyword);
        return ResultFactory.wrapper(page);

    }

    @ApiOperation(value = "详情查询", httpMethod = "GET")
    @GetMapping("detail")
    public Result detailProject(@RequestParam(value = "id") Long id) {
        ProjectInfo projectInfo = pageListProject.detailProjectById(id);
        return ResultFactory.wrapper(projectInfo);
    }

    @ApiOperation(value = "编辑修改", httpMethod = "POST")
    @PostMapping("update")
    public Result updateProject(@Validated @RequestBody UpdateProjectInfoMo updateProjectInfoMo) {
        boolean result = pageListProject.updateProject(updateProjectInfoMo);
        return ResultFactory.wrapper(result);
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping("delete")
    public Result deleteProject(@RequestParam(value = "id") Long id) {
        boolean result = pageListProject.deleteProjectById(id);
        return ResultFactory.wrapper(result);
    }

}
