package com.ax.apps.cms.web.controller;

import com.ax.apps.cms.bean.Article;
import com.ax.apps.cms.service.IArticleService;
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
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @ApiOperation(value = "查询所有",notes = "这个是查询所有")
    @GetMapping("findAll")
    public Message findAll(){

        return MessageUtil.success("查询成功",articleService.findAll());
    }
    @ApiOperation(value = "级联查询所有",notes = "级联查询出来作者和所属栏目")
    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll(){

        return MessageUtil.success("查询成功",articleService.cascadeFindAll());
    }
    @ApiOperation(value = "根据id查询",notes = "查询的id不能为空")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",value = "主键",paramType = "query", required = true))
    @GetMapping("findById")
    public Message findById(long id){
        return MessageUtil.success("查询成功",articleService.findById(id));
    }
    @ApiOperation(value = "保存或者更新",notes = "id为空时,操作为保存,不为空时,为更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",paramType ="query"),
            @ApiImplicitParam(name = "title",value = "标题",paramType ="query",required = true),
            @ApiImplicitParam(name = "content",value = "内容",paramType ="query",required = true),
            @ApiImplicitParam(name = "source",value = "原内容",paramType ="query"),
            @ApiImplicitParam(name = "categoryId",value = "栏目id",paramType ="query",required = true),
            @ApiImplicitParam(name = "authorId",value = "作者id",paramType ="query")
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Long id,
                                @NotNull String title,
                                @NotNull String content,
                                String source,
                                @NotNull long categoryId,
                                Long authorId){
        Article article=new Article(id,title,content,source,categoryId,authorId);
        articleService.saveOrUpdate(article);
        return MessageUtil.success("保存成功");
    }
}
