# TkMapperPlus
1. 将以下配置添加到EasyCode的Template Setting即可生成对应数据库表的代码.

### entity
```
##导入宏定义
$!define

##保存文件（宏定义）
#save("/entity", ".java")

##包路径（宏定义）
#setPackageSuffix("entity")

##自动导入包（全局变量）
$!autoImport
import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

##表注释（宏定义）
#tableComment(" 表实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "$!tableInfo.obj.name")
public class $!{tableInfo.name} extends BaseEntity {
private static final long serialVersionUID = $!tool.serial();
#foreach($column in $tableInfo.fullColumn)
    #if(${column.comment})/**
     * ${column.comment}
     */
#end
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end
}
```

### dao
```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("Dao")

##保存文件（宏定义）
#save("/dao", "Dao.java")

##包路径（宏定义）
#setPackageSuffix("dao")

import com.vdegree.grampus.common.mybatis.annotation.MyBatisMapper;
import com.vdegree.grampus.common.mybatis.mapper.BaseMapper;
import $!{tableInfo.savePackageName}.entity.$!tableInfo.name;

##表注释（宏定义）
#tableComment(" 表数据库访问层")
@MyBatisMapper
public interface $!{tableName} extends BaseMapper<$!tableInfo.name> {

}
```

### service
```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("Service")

##保存文件（宏定义）
#save("/service", "Service.java")

##包路径（宏定义）
#setPackageSuffix("service")

import com.vdegree.grampus.common.mybatis.service.EnhancedBaseService;
import $!{tableInfo.savePackageName}.entity.$!tableInfo.name;
import $!{tableInfo.savePackageName}.dto.$!{tableInfo.name}DTO;

##表注释（宏定义）
#tableComment(" 表服务接口")
public interface $!{tableName} extends EnhancedBaseService<$!tableInfo.name, $!{tableInfo.name}DTO> {

}
```

### serviceImpl
```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("ServiceImpl")

##保存文件（宏定义）
#save("/service/impl", "ServiceImpl.java")

##包路径（宏定义）
#setPackageSuffix("service.impl")

import com.vdegree.grampus.common.mybatis.service.impl.EnhancedBaseServiceImpl;
import $!{tableInfo.savePackageName}.dao.$!{tableInfo.name}Dao;
import $!{tableInfo.savePackageName}.entity.$!{tableInfo.name};
import $!{tableInfo.savePackageName}.dto.$!{tableInfo.name}DTO;
import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import org.springframework.stereotype.Service;

##表注释（宏定义）
#tableComment(" 表服务实现类")
@Service("$!tool.firstLowerCase($tableInfo.name)Service")
public class $!{tableName} extends EnhancedBaseServiceImpl<$!{tableInfo.name}Dao, $!{tableInfo.name}, $!{tableInfo.name}DTO> implements $!{tableInfo.name}Service {

}
```

### controller
```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("Controller")

##保存文件（宏定义）
#save("/controller", "Controller.java")

##包路径（宏定义）
#setPackageSuffix("controller")

##定义服务名
#set($serviceName = $!tool.append($!tool.firstLowerCase($!tableInfo.name), "Service"))

##定义实体对象名
#set($entityName = $!tool.firstLowerCase($!tableInfo.name))

import com.vdegree.grampus.common.core.constant.Constant;
import com.vdegree.grampus.common.core.result.Result;
import com.vdegree.grampus.common.mybatis.page.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import $!{tableInfo.savePackageName}.dto.$!{tableInfo.name}DTO;
import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

##表注释（宏定义）
#tableComment(" 表控制层")
@Api(tags = "$!{tableInfo.comment}")
@RestController
@AllArgsConstructor
@RequestMapping("$!tool.firstLowerCase($!tableInfo.name)")
public class $!{tableName} {

    private final $!{tableInfo.name}Service $!{serviceName};
    
    @ApiOperation("分页查询数据")
    @ApiImplicitParams({
    @ApiImplicitParam(name = Constant.PAGE_NUM, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
    @ApiImplicitParam(name = Constant.PAGE_SIZE, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
    @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
    @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
    @ApiImplicitParam(name = Constant.WITH_COUNT, value = "查询数据总量(true、false)", paramType = "query", dataType = "Boolean")
    })
    @GetMapping("page")
    @PreAuthorize("hasAuthority('$!tableInfo.obj.name:page')")
    public Result<PageData<$!{tableInfo.name}DTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<$!{tableInfo.name}DTO> page = $!{serviceName}.queryPage(params);
        return Result.success(page);
    }

    @ApiOperation("查询数据")
    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('$!tableInfo.obj.name:info')")
    public Result<$!{tableInfo.name}DTO> get(@PathVariable("id") Long id) {
        $!{tableInfo.name}DTO result = $!{serviceName}.queryById(id);
        return Result.success(result);
    }

    @ApiOperation("新增数据")
    @PostMapping
    @PreAuthorize("hasAuthority('$!tableInfo.obj.name:save')")
    public Result<Void> save(@RequestBody $!{tableInfo.name}DTO params) {
        $!{serviceName}.save(params);
        return Result.success();
    }

    @ApiOperation("修改数据")
    @PutMapping
    @PreAuthorize("hasAuthority('$!tableInfo.obj.name:update')")
    public Result<Void> update(@RequestBody $!{tableInfo.name}DTO params) {
        $!{serviceName}.modifyById(params);
        return Result.success();
    }

    @ApiOperation("删除数据")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('$!tableInfo.obj.name:delete')")
    public Result<Void> delete(@PathVariable Long id) {
        $!{serviceName}.deleteById(id);
        return Result.success();
    }
}
```

### dto
```
##导入宏定义
$!define

##设置表后缀（宏定义）
#setTableSuffix("DTO")

##保存文件（宏定义）
#save("/dto", "DTO.java")

##包路径（宏定义）
#setPackageSuffix("dto")

##自动导入包（全局变量）
$!autoImport
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

##表注释（宏定义）
#tableComment(" 表数据传输对象")
@Data
@ApiModel("$!{tableInfo.comment}")
public class $!{tableInfo.name}DTO implements Serializable {
private static final long serialVersionUID = $!tool.serial();
#foreach($column in $tableInfo.fullColumn)
    #if(${column.comment})/**
     * ${column.comment}
     */
#end
    @ApiModelProperty("$!{column.comment}")
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end
}
```