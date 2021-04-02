package com.vdegree.grampus.common.core.utils.beans;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Bean属性
 *
 * @author Beck
 */
@Getter
@RequiredArgsConstructor
public class BeanProperty {
	private final String name;
	private final Class<?> type;
}
