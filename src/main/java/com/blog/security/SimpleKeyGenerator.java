package com.blog.security;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class SimpleKeyGenerator implements KeyGenerator {
	private static SimpleKeyGenerator simpleKeyGenerator = new SimpleKeyGenerator();
	private String keyString = "keyforjwt9865232238";

	private SimpleKeyGenerator() {
	}

	public static KeyGenerator getInstance() {
		return simpleKeyGenerator;
	}

	public Key generateKey() {
		Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
		return key;
	}
}