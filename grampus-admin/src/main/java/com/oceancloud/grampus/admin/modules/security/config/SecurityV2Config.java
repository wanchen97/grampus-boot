package com.oceancloud.grampus.admin.modules.security.config;

import com.oceancloud.grampus.admin.modules.security.filter.JwtAuthenticationTokenFilter;
import com.oceancloud.grampus.admin.modules.security.properties.AuthSystemProperties;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security配置
 *
 * @author Beck
 * @since 2020-12-15
 */
@AllArgsConstructor
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(AuthSystemProperties.class)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityV2Config {
	private final JwtAuthenticationTokenFilter jwtAuthenticationFilter;
	private final AuthSystemProperties authSystemProperties;

	/**
	 * anyRequest          |   匹配所有请求路径
	 * access              |   SpringEl表达式结果为true时可以访问
	 * anonymous           |   匿名可以访问
	 * denyAll             |   用户不能访问
	 * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
	 * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
	 * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
	 * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
	 * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
	 * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
	 * permitAll           |   用户可以任意访问
	 * rememberMe          |   允许通过remember-me登录的用户访问
	 * authenticated       |   用户登录后可访问
	 */
	@Bean
	@SneakyThrows
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) {
		String[] ignoreUrls = authSystemProperties.getIgnoreUrls().toArray(new String[0]);
		// @formatter:off
		http.cors()
				// 关闭 CSRF
				.and().csrf().disable()
				// 登录行为由自己实现，参考 AuthController#login
				.formLogin().disable()
				.httpBasic().disable()

				// 认证请求
				.authorizeRequests()
				// 忽略特定请求路径的认证
				.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.requestMatchers(ignoreUrls).permitAll()
				// 所有请求都需要登录访问
				.anyRequest()
				.authenticated()

				// 登出行为由自己实现，参考 AuthController#logout
				.and().logout().disable()
				// Session 管理
				.sessionManagement()
				// 因为使用了JWT，所以这里不管理Session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				.and()
				// 添加自定义 JWT 过滤器
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		// @formatter:on

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
