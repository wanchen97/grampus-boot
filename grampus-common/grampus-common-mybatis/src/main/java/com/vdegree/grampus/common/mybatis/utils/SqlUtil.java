package com.vdegree.grampus.common.mybatis.utils;

import com.vdegree.grampus.common.core.utils.StringUtil;

/**
 * SQL 工具类
 *
 * @author Beck
 * @since 2020-12-15
 */
public class SqlUtil {

	private final static String[] KEYWORDS = { "master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop", "sleep" };

	/**
	 * 验证 order by 语法是否符合规范
	 */
	public static boolean isValidOrderBySql(String value) {
		for (String keyword : KEYWORDS) {
			if (StringUtil.containsIgnoreCase(value, keyword)) {
				return false;
			}
		}
		return true;
	}
}
