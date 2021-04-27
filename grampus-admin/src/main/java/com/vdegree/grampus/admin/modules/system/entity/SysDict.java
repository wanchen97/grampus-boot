package com.vdegree.grampus.admin.modules.system.entity;

import com.vdegree.grampus.common.mybatis.annotation.FieldFill;
import com.vdegree.grampus.common.mybatis.annotation.TableField;
import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * 字典表 实体类
 *
 * @author Beck
 * @since 2020-12-09 19:47:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_dict")
public class SysDict extends BaseEntity {
	private static final long serialVersionUID = 136388614256596989L;
	/**
	 * 字典类型
	 */
	private String dictType;
	/**
	 * 字典名称
	 */
	private String dictName;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 创建者
	 */
	@TableField(fill = FieldFill.INSERT)
	private String createBy;
	/**
	 * 创建日期
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createDate;
}