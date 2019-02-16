package com.zabee.securityconcepts;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * The goal is to understand how this works. The entire code is copy pasted from
 * here
 * https://proandroiddev.com/security-best-practices-symmetric-encryption-with-aes-in-java-7616beaaade9
 * 
 * @author zulla
 *
 */

public class SymmetricEncryptionExample {

	private static byte[] key = new byte[16];
	private static String plainText = "This is just a plain text that's going to be encrypted!!";
	private static String cipherText;
	private static byte[] cipherBytes;
	private static SecretKey secretKey;
	private static SecureRandom secureRandom;
	private static byte[] iv = new byte[12]; // NEVER REUSE THIS IV WITH SAME KEY
	private static byte[] cipherMessageBytes;

	private static void generateARandomKey() {
		// Generating a key that gets passed to encryption algorithm
		secureRandom = new SecureRandom();
		secureRandom.nextBytes(key);
	}

	private static void setTheGeneratedKeyToEncryptionAlgorithm() {
		// Set the key
		secretKey = new SecretKeySpec(key, "AES");
	}

	private static void createInitializationVector() {
		secureRandom.nextBytes(iv);
	}

	private static void encrypt() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv); // 128 bit auth tag length
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
		cipherBytes = cipher.doFinal(plainText.getBytes());
	}

	private static void printCipherBytesInProperStringFormat() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(4 + iv.length + cipherBytes.length);
		byteBuffer.putInt(iv.length);
		byteBuffer.put(iv);
		byteBuffer.put(cipherBytes);
		cipherMessageBytes = byteBuffer.array();
		cipherText = Base64.getEncoder().encodeToString(cipherMessageBytes);
		System.out.println("Plain to Cipher text   : " + cipherText);
	}

	private static void showEncrypted() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		generateARandomKey();
		setTheGeneratedKeyToEncryptionAlgorithm();
		encrypt();
		printCipherBytesInProperStringFormat();
	}

	private static void deconstructCipherText() {
		ByteBuffer byteBuffer = ByteBuffer.wrap(cipherMessageBytes);
		int ivLength = byteBuffer.getInt();
		if (ivLength < 12 || ivLength >= 16) { // check input parameter
			throw new IllegalArgumentException("invalid iv length");
		}
		byte[] iv = new byte[ivLength];
		byteBuffer.get(iv);
		cipherBytes = new byte[byteBuffer.remaining()];
		byteBuffer.get(cipherBytes);

	}

	private static void decrypt() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, iv));
		byte[] plainTextBytes = cipher.doFinal(cipherBytes);
		plainText = new String(plainTextBytes);
		System.out.println("Cipher to Plain text   : " + plainText);
	}

	private static void showDecrypted() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		deconstructCipherText();
		decrypt();

	}

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println("Input string plain text:" + plainText + "\n");

		showEncrypted();
		showDecrypted();
	}

}
