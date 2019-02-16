package com.zabee.securityconcepts;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.apache.commons.text.StringEscapeUtils;

public class Base64URLAndHTMLEncoding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		urlEncoding();
		htmlEncoding();
		base64Encoding();
	}

	/**
	 * Base64 encoding is used whenever we want to transmit the data for e.g. bytes
	 * to String, MIME to some random string and URL to some random string. Every
	 * method input is in bytes This is to encode bytes to string and vice versa.
	 * This is needed as we transfer data through some network devices they may take
	 * some as commands and start doing some insane stuff to avoid it we encode
	 * bytes to string and transmit and at the destination we decode i.e. string to
	 * byte For MIME encoding and decoding For URL Encoding and decoding
	 * 
	 * @throws UnsupportedEncodingException
	 * 
	 */
	private static void base64Encoding() throws UnsupportedEncodingException {
		Encoder base64Encoder = Base64.getEncoder();
		byte[] byteArray = { 'Z', 'a', 'b', 'e', 'e' };
		System.out.print("Printing bytes:");
		for (byte aByte : byteArray) {
			System.out.print(aByte);
		}
		System.out.println();
		String encodedStr = base64Encoder.encodeToString(byteArray);
//		Can also be like below but handles everything in bytes
//		String encodedStr = base64Encoder.encodeToString(byteArray);
		System.out.println("Base64 Encoded means bytes to string:" + encodedStr);

		Decoder base64Decoder = Base64.getDecoder();
		byteArray = base64Decoder.decode(encodedStr);
		System.out.print("Base64 Decoded means strings to byes:");
		for (byte aByte : byteArray) {
			System.out.print(aByte);
		}

		base64Encoder = Base64.getMimeEncoder();
		String emailBody = "This is to inform you that whatever!!";
		byte[] mimeEncodedBytes = base64Encoder.encode(emailBody.getBytes());
		System.out.println("\n\nMIMEEncoded bytes");
		for (byte aByte : mimeEncodedBytes) {
			System.out.print(aByte);
		}
		base64Decoder = Base64.getMimeDecoder();
		System.out.println("\nMIMEDecoded bytes");
		byte[] mimeDecodedBytes = base64Decoder.decode(mimeEncodedBytes);
		System.out.println(new String(mimeDecodedBytes));

		base64Encoder = Base64.getUrlEncoder();
		String url = "https://localhost:9001/mywebapp/home page";
		String encodedURL = new String(base64Encoder.encode(url.getBytes()));
		System.out.println("Encoded URL:" + encodedURL);
		base64Decoder = Base64.getUrlDecoder();
		String decodedURL = new String(base64Decoder.decode(encodedURL.getBytes()));
		System.out.println("Decoded URL:" + decodedURL);

	}

	/**
	 * This is not supported in JDK by default. So I have added commons-text library
	 * and its dependency commons-lang3. The latter 4th party and former is used
	 * directly
	 */
	private static void htmlEncoding() {
		System.out.println("\n\n\n=============================== HTML Encoding ===============================");
		String maliciousJavaScript = "<script type=\"javascript/text\">\n"//
				+ "var x = 'Doing something malicious';\n"//
				+ "alert('You are affected by malware');\n"//
				+ "</script>";
		System.out.println("Sending as below to Web browser from server is not recommended");
		System.out.println(maliciousJavaScript);

		System.out.println(
				"\nHTML encoded. The encoed one will be just printed as it is! But don't interpret but just print it as it don't find any tags!!");
		String encodedJavaScriptNotAtAllDangerous = StringEscapeUtils.escapeHtml4(maliciousJavaScript);
		System.out.println(encodedJavaScriptNotAtAllDangerous);
	}

	/**
	 * I have used JDK's internal classes from java.net package. Duh, of course java
	 * is in build path
	 * 
	 * @throws UnsupportedEncodingException
	 */
	private static void urlEncoding() throws UnsupportedEncodingException {
		System.out.println("=============================== URL Encoding ===============================");
		String urlStr = "https://localhost:9004/mywebapp?locale=US ";

		String encodedStr = URLEncoder.encode(urlStr, "UTF-16");
		System.out.println(encodedStr);

		String decodedStr = URLDecoder.decode(encodedStr, "ASCII");
		System.out.println(
				"Encoded using UTF-16 i.e. 16 bit Unicode for handling all the languages around the world but decoding using ASCII 8 bits\n"
						+ decodedStr);
		System.out.println("\nDecoded using UTF-16 used for encoding :" + URLDecoder.decode(encodedStr, "UTF-16"));

	}
}
