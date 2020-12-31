package com.vdegree.grampus.admin.modules.system.entity;

import com.vdegree.grampus.common.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Table;
import java.util.Date;

/**
 * 字典数据表(SysDictItem)实体类
 *
 * @author Beck
 * @since 2020-12-09 19:48:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_dict_item")
public class SysDictItem extends BaseEntity {
	private static final long serialVersionUID = -43076863635944309L;

	/**
	 * 字典ID
	 */
	private Long dictId;

	/**
	 * 字典标签
	 */
	private String dictLabel;

	/**
	 * 字典值
	 */
	private String dictValue;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 创建者
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新者
	 */
	private Long updateBy;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 删除标识(0正常 1删除)
	 */
	@LogicDelete
	private Integer delFlag;

}