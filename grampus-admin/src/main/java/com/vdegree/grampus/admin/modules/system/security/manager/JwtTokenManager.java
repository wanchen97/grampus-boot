package com.vdegree.grampus.admin.modules.system.security.manager;

import com.vdegree.grampus.admin.modules.system.security.properties.AuthProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-5
 */
@Component
public class JwtTokenManager {

	private static final String AUTHORITIES_KEY = "perms";

	@Autowired
	private AuthProperties authProperties;

	/**
	 * Create token.
	 *
	 * @param authentication auth info
	 * @return token
	 */
	public String createToken(Authentication authentication) {
		return createToken(authentication.getName(), authentication.getAuthorities());
	}

	/**
	 * Create token.
	 *
	 * @param userNo auth info
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
	 * Create token with .
	 *
	 * @param userNo auth info
	 * @return token
	 */
	public String createToken(String userNo, Collection<? extends GrantedAuthority> authorities) {

		long now = System.currentTimeMillis();

		Date validity = new Date(now + authProperties.getTokenValidityInSeconds() * 1000L);

		String permissions = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
		Claims claims = Jwts.claims().setSubject(userNo);
		claims.put(AUTHORITIES_KEY, permissions);
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
