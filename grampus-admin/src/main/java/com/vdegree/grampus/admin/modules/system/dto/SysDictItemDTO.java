package com.vdegree.grampus.admin.modules.system.dto;

import lombok.Data;
import tk.mybatis.mapper.annotation.LogicDelete;

import java.io.Serializable;
import java.util.Date;

/**
 * Title:
 * Company: v-degree
 *
 * @author Beck
 * @date 2021-04-13
 */
@Data
public class SysDictItemDTO implements Serializable {
	private static final long serialVersionUID = -8288240035977175413L;
	/**
	 * 数据ID
	 */
	private Long id;
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
