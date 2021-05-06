package com.vdegree.grampus.common.sequence.builder;

import com.vdegree.grampus.common.sequence.generator.IdGenerator;

/**
 * ID生成器Builder
 *
 * @author Beck
 * @date 2020-12-03
 */
public interface IdGeneratorBuilder {

	/**
	 * 构建ID生成器
	 *
	 * @return ID生成器
	 */
	IdGenerator build();
}
