package com.vdegree.grampus.common.security.properties;

import io.jsonwebtoken.io.Decoders;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Title: Auth related properties.
 * Project: grampus
 *
 * @author Beck
 * @date 2020-12-05
 */
@Getter
@Setter
@Component
public class AuthProperties implements Serializable {

	private static final long serialVersionUID = 1018599184459531637L;

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
	 * secret key byte array.
	 */
	private byte[] secretKeyBytes;

	public byte[] getSecretKeyBytes() {
		if (secretKeyBytes == null) {
			secretKeyBytes = Decoders.BASE64.decode(secretKey);
		}
		return secretKeyBytes;
	}
}
