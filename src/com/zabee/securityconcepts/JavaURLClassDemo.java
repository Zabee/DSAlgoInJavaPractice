package com.zabee.securityconcepts;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class JavaURLClassDemo {

	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[1024];
		URL aURL = new URL("https://www.google.co.in");
		URLConnection urlConnection = aURL.openConnection();
		urlConnection.connect();
		try (InputStream inputStream = urlConnection.getInputStream()) {
			do {
				inputStream.read(bytes);
				System.out.println(new String(bytes, "UTF-8"));
			}while(bytes != null && bytes.length > 0);
		}
		System.out.println(aURL.getProtocol());
		System.out.println(aURL.getAuthority());
		System.out.println(aURL.getHost());
		System.out.println(aURL.getPort());
		System.out.println(aURL.getDefaultPort());

	}

}
