package com.oceancloud.grampus.admin.modules.system.security.manager;

import com.oceancloud.grampus.admin.modules.system.enums.RequestPlatformEnum;
import com.oceancloud.grampus.admin.modules.system.security.properties.AuthTokenProperties;
import com.oceancloud.grampus.framework.core.utils.CollectionUtil;
import com.oceancloud.grampus.framework.core.utils.chars.StringPool;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JWT token manager.
 *
 * @author Beck
 * @since 2020-12-5
 */
@AllArgsConstructor
@Component
public class JwtTokenManager {

	private static final String AUTHORITIES_KEY = "perms";
	private static final String PLATFORM_KEY = "platform";

	private final AuthTokenProperties authProperties;

	/**
	 * Create token.
	 *
	 * @param authentication auth info
	 * @param platform       request platform
	 * @return token
	 */
	public String createToken(Authentication authentication, RequestPlatformEnum platform) {
//		return createToken(authentication.getName(), authentication.getAuthorities());
		return createToken(authentication.getName(), platform.getPlatform(), null);
	}

	/**
	 * Create token.
	 *
	 * @param userNo userno
	 * @return token
	 */
	public String createToken(String userNo) {

		long now = System.currentTimeMillis();

		Date validity;
		validity = new Date(now + authProperties.getTokenValidityInSeconds() * 1000L);

		Claims claims = Jwts.claims().setSubject(userNo);
		return Jwts.builder().setClaims(claims).setExpiration(validity)
				.signWith(Keys.hmacShaKeyFor(authProperties.getSecretKeyBytes()), SignatureAlgorithm.HS512).compact();
	}

	/**
	 * Create token with userNo platform authorities.
	 *
	 * @param userNo      userno
	 * @param platform    request platform
	 * @param authorities authorities
	 * @return token
	 */
	public String createToken(String userNo, String platform, Collection<? extends GrantedAuthority> authorities) {

		long now = System.currentTimeMillis();

		Date validity = new Date(now + authProperties.getTokenValidityInSeconds() * 1000L);

		Claims claims = Jwts.claims().setSubject(userNo);
		claims.put(PLATFORM_KEY, platform);

		if (CollectionUtil.isNotEmpty(authorities)) {
			String permissions = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(StringPool.COMMA));
			claims.put(AUTHORITIES_KEY, permissions);
		}
		return Jwts.builder().setClaims(claims).setExpiration(validity)
				.signWith(Keys.hmacShaKeyFor(authProperties.getSecretKeyBytes()), SignatureAlgorithm.HS512).compact();
	}

	/**
	 * Get subject Info.
	 *
	 * @param token token
	 * @return auth info
	 */
	public String getSubject(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(authProperties.getSecretKeyBytes()).build()
				.parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	/**
	 * Get auth Info. TODO 动态改权限，token不写入权限
	 *
	 * @param token token
	 * @return auth info
	 */
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(authProperties.getSecretKeyBytes()).build()
				.parseClaimsJws(token).getBody();

		List<GrantedAuthority> authorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList((String) claims.get(AUTHORITIES_KEY));

		User principal = new User(claims.getSubject(), "", authorities);
		return new UsernamePasswordAuthenticationToken(principal, "", authorities);
	}

	/**
	 * validate token.
	 *
	 * @param token token
	 */
	public void validateToken(String token) {
		Jwts.parserBuilder().setSigningKey(authProperties.getSecretKeyBytes()).build().parseClaimsJws(token);
	}

}
