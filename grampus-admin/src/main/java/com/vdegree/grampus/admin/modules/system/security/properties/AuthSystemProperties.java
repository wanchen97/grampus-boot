package com.vdegree.grampus.admin.modules.system.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Auth related configurations.
 *
 * @author Beck
 * @date 2020-12-9
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "grampus.auth.system")
public class AuthSystemProperties {

	/**
	 * Which auth system is in use.
	 */
	@Value("${grampus.auth.system.type:}")
	private String authSystemType;

	/**
	 * Which urls ignore authorize.
	 */
	private List<String> ignoreUrls;
}
