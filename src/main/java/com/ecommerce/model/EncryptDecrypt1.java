package com.ecommerce.model;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptDecrypt1 {

	private final String KEY = "MySecretKey12345";

	public String encrypt(String password) {
		try {
			SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedPassword = cipher.doFinal(password.getBytes());
			return Base64.getEncoder().encodeToString(encryptedPassword);
		} catch (Exception e) {
			System.out.println("Error while encrypting password: " + e.toString());
			return null;
		}
	}

	public String decrypt(String encryptedPassword) {
		try {
			SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedPassword = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
			return new String(decryptedPassword);
		} catch (Exception e) {
			System.out.println("Error while decrypting password: " + e.toString());
			return null;
		}
	}
}
