package com.vdegree.grampus.common.core.utils.beans;

import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * Bean属性
 *
 * @author Beck
 */
@Getter
@AllArgsConstructor
public class BeanProperty {
	private final String name;
	private final Class<?> type;
}
