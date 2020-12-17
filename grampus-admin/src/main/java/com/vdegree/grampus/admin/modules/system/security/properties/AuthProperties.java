package com.vdegree.grampus.admin.modules.system.security.properties;

import io.jsonwebtoken.io.Decoders;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;

/**
 * Auth related configurations.
 * Company: v-degree
 *
 * @author Beck
 * @date 2020-12-9
 */
@Getter
@Setter
@Configuration
public class AuthProperties implements Serializable {
	private static final long serialVersionUID = 6026069450967381841L;

	/**
	 * secret key.
	 */
	@Value("${grampus.auth.token.secret.key:}")
	private String secretKey;

	/**
	 * Token validity time(seconds).
	 */
	@Value("${grampus.auth.token.expire.seconds:1800}")
	private long tokenValidityInSeconds;

	/**
	 * Which auth system is in use.
	 */
	@Value("${grampus.auth.system.type:}")
	private String authSystemType;

	@Value("${grampus.auth.system.ignoreUrls:}")
	private List<String> ignoreUrls;

	/**
	 * secret key byte array.
	 */
	private byte[] secretKeyBytes;

	public byte[] getSecretKeyBytes() {
//		if (secretKeyBytes == null) {
//			secretKeyBytes = Decoders.BASE64.decode(secretKey);
//		}
		return secretKey.getBytes();
	}
}
