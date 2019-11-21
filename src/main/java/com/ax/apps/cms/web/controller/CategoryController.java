package com.ax.apps.cms.web.controller;

import com.ax.apps.cms.bean.Category;
import com.ax.apps.cms.service.ICategoryService;
import com.ax.apps.cms.utils.Message;
import com.ax.apps.cms.utils.MessageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "查询所有")
    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success("查询成功",categoryService.findAll());
    }


    @ApiOperation(value = "保存或者更新",notes = "有id更新,没id保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "名称",paramType = "query",required = true),
            @ApiImplicitParam(name = "description",value = "描述",paramType = "query"),
            @ApiImplicitParam(name = "no",value = "序号",paramType = "query"),
            @ApiImplicitParam(name = "parentId",value = "父栏目的id",paramType = "query")
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Long id,
                             @NotNull String name,
                             String description,
                             Integer no,
                             Long parentId){

        categoryService.saveOrUpdate(new Category(id,name,description,no,parentId));
        return MessageUtil.success("更新成功");

    }

    @ApiOperation("根据id删除")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",value = "主键",paramType ="query",required = true))
    @GetMapping("deleteById")
    public Message deleteById(@NotNull long id){
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("批量删除")
    @PostMapping("batchDelete")
    public Message batchDelete(long[] ids){
        categoryService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }


}
