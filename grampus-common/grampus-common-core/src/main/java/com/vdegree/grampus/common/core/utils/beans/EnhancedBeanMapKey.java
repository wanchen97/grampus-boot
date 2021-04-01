package com.vdegree.grampus.common.core.utils.beans;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * Title: EnhancedBeanMapKey
 * Project: zeta
 *
 * @author Beck
 * @date 2021-01-25
 */
@EqualsAndHashCode
@RequiredArgsConstructor
public class EnhancedBeanMapKey {
	private final Class type;
	private final int require;
}
