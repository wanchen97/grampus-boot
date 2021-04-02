package com.vdegree.grampus.common.mybatis.entity;

import com.vdegree.grampus.common.mybatis.utils.SnowflakeKeyGen;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Title: 基础实体类，所有实体都需要继承
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-02
 */
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = -1799573625766414211L;
	/**
	 * id
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	@KeySql(genId = SnowflakeKeyGen.class)
	private Long id;
}
