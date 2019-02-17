package com.zabee.security.concepts;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SomeHashings {

	private static final String password = "ThisIsMyPasswordOkay12345!@#$";
	private static String salt = "salt";

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] hashedBytes = hashUsingMd5();
		System.out.println("MD5\t\t:" + new String(base64Encode(hashedBytes), "UTF-8"));

		hashedBytes = hashUsingSHA1();
		System.out.println("SHA1 128 bits\t:" + new String(base64Encode(hashedBytes), "UTF-8"));

		hashedBytes = hashUsingSHA2();
		System.out.println("SHA2 256 bits\t:" + new String(base64Encode(hashedBytes), "UTF-8"));

		hashedBytes = hashUsingSHA3();
		System.out.println("SHA3 384 bits\t:" + new String(base64Encode(hashedBytes), "UTF-8"));
		
		hashedBytes = hashUsingSHA4();
		System.out.println("SHA4 512 bits\t:" + new String(base64Encode(hashedBytes), "UTF-8"));
	}

	private static byte[] base64Encode(byte[] hashedBytes) {
		byte[] base64EncodedBytes = Base64.getEncoder().encode(hashedBytes);
		return base64EncodedBytes;
		// OR
//		String base64EncodedBytes = Base64.getEncoder().encodeToString(hashedBytes);
//		System.out.println(base64EncodedBytes);
	}

	private static byte[] hashUsingMd5() {
		byte[] hashedBytes = null;
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			msgDigest.reset();
			msgDigest.update(password.getBytes());
			msgDigest.update(getSecureRandom());
			hashedBytes = msgDigest.digest();
		} catch (NoSuchAlgorithmException ns) {

		}
		return hashedBytes;
	}

	private static byte[] getSecureRandom() {
		SecureRandom secRandom = new SecureRandom();
		Double aDouble = secRandom.nextDouble();
		return String.valueOf(aDouble).getBytes();
	}

	private static byte[] hashUsingSHA1() throws NoSuchAlgorithmException {
		byte[] hashedBytes = {};
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("SHA-1");
			msgDigest.reset();
			msgDigest.update(password.getBytes());
			msgDigest.update(getSecureRandom());
			hashedBytes = msgDigest.digest();
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
		}
		return hashedBytes;
	}

	private static byte[] hashUsingSHA2() throws NoSuchAlgorithmException {
		byte[] hashedBytes = {};
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");
			msgDigest.reset();
			msgDigest.update(password.getBytes());
			msgDigest.update(getSecureRandom());
			hashedBytes = msgDigest.digest();
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
		}
		return hashedBytes;
	}

	private static byte[] hashUsingSHA3() throws NoSuchAlgorithmException {
		byte[] hashedBytes = {};
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("SHA-384");
			msgDigest.reset();
			msgDigest.update(password.getBytes());
			msgDigest.update(getSecureRandom());
			hashedBytes = msgDigest.digest();
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
		}
		return hashedBytes;
	}
	
	private static byte[] hashUsingSHA4() throws NoSuchAlgorithmException {
		byte[] hashedBytes = {};
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("SHA-512");
			msgDigest.reset();
			msgDigest.update(password.getBytes());
			msgDigest.update(getSecureRandom());
			hashedBytes = msgDigest.digest();
		} catch (NoSuchAlgorithmException ns) {
			ns.printStackTrace();
		}
		return hashedBytes;
	}
}