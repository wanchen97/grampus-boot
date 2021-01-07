package com.vdegree.grampus.common.sequence.builder;

import com.vdegree.grampus.common.sequence.generator.IdGenerator;

/**
 * Title: ID生成器Builder
 * Company: v-degree
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
