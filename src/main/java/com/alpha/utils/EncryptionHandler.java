package com.alpha.utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionHandler {
	
	final static String ALGORITHM = "AES";
	private	static final String KEY = "yourStrongAndSecureKey"; // Replace with your secret key

	public static String encrypt(String data) {
        try {
//            Cipher cipher = Cipher.getInstance(ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed: " + e.getMessage());
        }
    }

	public static String decrypt(String encryptedData) {
        try {
//            Cipher cipher = Cipher.getInstance(ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decoded = Base64.getDecoder().decode(encryptedData);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String originalText = "Bibassssssss";
        
        // Encrypt
        String encryptedText = encrypt(originalText);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decrypt
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }

}
