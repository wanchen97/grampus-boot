package com.oceancloud.grampus.admin.modules.security.properties;

// import io.jsonwebtoken.io.Decoders;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * 认证相关的配置
 *
 * @author Beck
 * @since 2020-12-9
 */
@Getter
@Setter
@Configuration
public class AuthTokenProperties implements Serializable {
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

	// /**
	//  * secret key byte array.
	//  */
	// private byte[] secretKeyBytes;

	public byte[] getSecretKeyBytes() {
//		if (secretKeyBytes == null) {
//			secretKeyBytes = Decoders.BASE64.decode(secretKey);
//		}
		return secretKey.getBytes();
	}
}
