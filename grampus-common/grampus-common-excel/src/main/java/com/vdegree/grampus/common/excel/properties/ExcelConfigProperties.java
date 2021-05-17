package com.vdegree.grampus.common.excel.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Beck
 * @since 2021-5-14
 */
@Data
@ConfigurationProperties(prefix = ExcelConfigProperties.PREFIX)
public class ExcelConfigProperties {

	static final String PREFIX = "excel";

	/**
	 * 模板路径
	 */
	private String templatePath = "excel";
}
