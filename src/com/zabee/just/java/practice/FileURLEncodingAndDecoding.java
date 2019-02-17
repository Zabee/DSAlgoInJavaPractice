package com.zabee.just.java.practice;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.sound.midi.Patch;

public class FileURLEncodingAndDecoding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String path = "D:\\Spring upgrade to 4.3.18 on Xstore6.5.patch";
		encodeDecodeUsingJavaNet(path);
		ecodeUsingStringEncoder(path);
	}

	private static void encodeDecodeUsingJavaNet(String path) throws UnsupportedEncodingException {
		System.out.println("Called java.net");
		String encodedFileURL = URLEncoder.encode("A.B.C.E", "UTF-8");
		System.out.println("Encoded File URL : " + encodedFileURL);
		String decodedFileURL = URLDecoder.decode(path, "US-ASCII");
		System.out.println("Decoded File URL : " + decodedFileURL);
	}

	private static void ecodeUsingStringEncoder(String path) throws UnsupportedEncodingException {
		System.out.println("Called our StringEncoder");
		boolean doubleDotAttack = false;
		char[] pathCharArray = path.toCharArray();
		if (path.contains("..")) {			
			for(int i=0; i<=pathCharArray.length-2; i++) {
				if(pathCharArray[i] == '.' && pathCharArray[i+1] == '.') {
					doubleDotAttack = true;
					pathCharArray[i] = 'x';
					pathCharArray[i+1] = 'x';
				}
			}
		}
		System.out.println(pathCharArray);
//		System.out.println(StringEncoder.getAsciiEncodedValue(path));
	}

}

/**
 * A class designed to encode strings to different value for embedding into
 * delimited files.
 * 
 * @author jrose
 * @created Mar 15, 2010
 * @version $Revision: 412480 $
 */
class StringEncoder {

	/**
	 * Gets the ASCII encoding of the string.
	 * 
	 * @param argString the string to get the encoding for.
	 * @return the string in the format &lt;!<i>ascii val</i>+<i>ascii
	 *         val</i>+...&gt;
	 */
	public static String getAsciiEncodedValue(String argString) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("<!");
		for (int i = 0; i < argString.length(); i++) {
			char c = argString.charAt(i);
			buffer.append("" + (int) c);
			if (i != argString.length() - 1) {
				buffer.append("+");
			}
		}
		buffer.append(">");
		return buffer.toString();
	}

// don't allow instantiation
	private StringEncoder() {
	};

}
