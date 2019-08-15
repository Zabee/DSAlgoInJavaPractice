package com.zabee.just.java.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * File class has all the necessary things related to file. For e.g. create,
 * delete, exists, rename, getPath, getAbsolutePath etc.,
 * 
 * Yeah, I know I could have made Stream members and reused them, but this is
 * for just only for practice I wanted to create and exercise try with resource
 * mutiple times, so chill and enjoy Reading and Writing with Files
 * ================================ Want to handle character by character?
 * Reader, Writer (FileReader, FileWriter)
 * 
 * Want to handle byte by bye? InputStream, OutputStream
 * 
 * And little bit of reflection but never mind I will cover reflection in
 * another program
 * 
 * 
 * @author Zabee
 *
 */

public class FileAndStreams {
	private static String newFileContents = String.format(
			"All the %d programming languages provide %f support for standard I/O where the user's program can take input from a keyboard and then produce an output on the computer screen. If you are aware of C or C++ programming languages, then you must be aware of three standard devices STDIN, STDOUT and STDERR. Similarly, Java provides the following three standard streams",
			10, 12.03);
	private static File aFile = new File(/* System.getProperty("user.dir") +"/" + */"testFiles/testFile1.txt");
	private static File bFile = new File(/* System.getProperty("user.dir") + "/" + */"testFiles/testFile2.txt");
	private static Map<Integer, Method> optionMethodMap = new HashMap<>();
	private static Scanner scanner;

	static {
		try {
			final Method readWriteBytes = FileAndStreams.class.getDeclaredMethod("readWriteByteByByte", null);
			final Method readWriteChars = FileAndStreams.class.getDeclaredMethod("readWriteCharByChar", null);
			final Method modifyFile = FileAndStreams.class.getDeclaredMethod("modifyFile", null);
			final Method append = FileAndStreams.class.getDeclaredMethod("append", null);

			optionMethodMap.put(1, readWriteBytes);
			optionMethodMap.put(2, readWriteChars);
			optionMethodMap.put(3, modifyFile);
			optionMethodMap.put(4, append);

			if (!aFile.exists()) {
				try (FileOutputStream fileOutStream = new FileOutputStream(aFile)) {
					fileOutStream.write(newFileContents.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				// if file exists by no content
				try (FileInputStream fileInStream = new FileInputStream(aFile)) {
					int intByte;
					boolean anyContent = false;
					while ((intByte = fileInStream.read()) != -1) {
						if (!anyContent) // Compiler optimization will skip this for subsequent iterations
							anyContent = true;
					}
					if (!anyContent) {
						try (FileOutputStream fileOutStream = new FileOutputStream(aFile)) {
							fileOutStream.write(newFileContents.getBytes());
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
			throws IOException, InvocationTargetException, IllegalAccessException, IllegalArgumentException {
		System.out.println("Choose from options:");
		System.out.println("(1) Byte by Byte");
		System.out.println("(2) Char by Char");
		System.out.println("(3) Modify file contetns");
		System.out.println("(4) Append");
		System.out.print("Your opiton goes here:");
		scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		Method targetMethod = optionMethodMap.get(option);
		Object invoke = targetMethod.invoke(null, null);
	}

	/**
	 * FileInputStream and FileOutputStream
	 * 
	 * @param argFile
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void readWriteByteByByte() throws FileNotFoundException, IOException {
		try (FileInputStream fileInStream = new FileInputStream(aFile);
				FileOutputStream fileOutStream = new FileOutputStream(bFile)) {
			int intByte;
			while ((intByte = fileInStream.read()) != -1) {
				fileOutStream.write(intByte);
			}
		}
	}

	/**
	 * Reader and Writer
	 * 
	 * @param argFile
	 * @throws IOException
	 */
	private static void readWriteCharByChar() throws IOException {
		try (FileReader fileReader = new FileReader(aFile); FileWriter fileWriter = new FileWriter(bFile)) {
			int intByte;
			while ((intByte = fileReader.read()) != -1) {
				fileWriter.write(intByte);
			}
		}
	}

	private static void modifyFile() throws FileNotFoundException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		String readFileContents;
		int intByte;
		System.out.println("Enter serach key and replacement sepearated by new lines");
		scanner.nextLine(); // I don't know why but this what it takes one simply extra nextLine();
		String searchKey = scanner.nextLine();
		String replacement = scanner.nextLine();

		try (FileReader fileReader = new FileReader(aFile)) {
			while ((intByte = fileReader.read()) != -1) {
				stringBuilder.append(intByte);
			}
		}
		readFileContents = stringBuilder.toString();
		readFileContents = readFileContents.replaceAll(searchKey, replacement);

		try (FileWriter fileWriter = new FileWriter(aFile)) {
			fileWriter.write(readFileContents);
		}
	}

	private static void append() throws FileNotFoundException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		int intByte;
		System.out.println("Enter text to append");
		scanner.nextLine(); // I don't know why but this what it takes one simply extra nextLine();
		String appendingText = scanner.nextLine();
		try (FileReader fileReader = new FileReader(aFile)) {
			while ((intByte = fileReader.read()) != -1) {
				stringBuilder.append(intByte);
			}
		}
		// 2 ways
		// (1) Append to stringBuilder and write a fresh (yeah, that's what it do write
		// freshly)
		// (2) Open FileWrite in append mode and write

		try (FileWriter fileWriter = new FileWriter(aFile, true)) {
			fileWriter.write(appendingText);
//			fileWriter.append(appendingText);
		}

	}
}
