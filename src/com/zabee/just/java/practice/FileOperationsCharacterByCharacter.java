package com.zabee.just.java.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperationsCharacterByCharacter {

	public static void main(String[] args) throws InterruptedException, IOException {
		readAndWriteUsingFileWriterAndFileReader();
		Thread.sleep(2000);
		readAndWriteUsingBufferedWriterAndFileReader();
	}

	private static void readAndWriteUsingFileWriterAndFileReader() throws IOException {
		System.out.println("Writing then reading file contents character by character");
		// File name and contents
		String fileName = System.getProperty("user.dir") + "/FileUsingFileWriterAndReader.txt";
		String fileContents = "This is file which is written and read by java.io.FileWriter and java.io.FileReader classes!!";

		// Writing to a file
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			fileWriter.write(fileContents.toCharArray());
			System.out.println("File contents written!!");
			fileWriter.flush();
		}
		// Reading from a file
		System.out.print("File contents are follows,\"");
		try (FileReader fileReader = new FileReader(fileName)) {
			int ch;
			while ((ch = fileReader.read()) != -1) {
				System.out.print((char) ch);
			}
		}
		System.out.println("\" \nEnd of Writing and Reading character by character using FileWriter and FileReader");
	}

	private static void readAndWriteUsingBufferedWriterAndFileReader() throws IOException {
		System.out.println("Writing then reading file contents line by line or in bulk");
		// File name and contents
		String fileName = System.getProperty("user.dir") + "/FileUsingBufferedWriterAndReader.txt";
		String fileContents = "This is file which is written and read by java.io.BufferedWriter and java.io.BufferedReader classes!!";

		// Writing to a file
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
			bufferedWriter.write(fileContents);
			bufferedWriter.flush();
		}

		System.out.print("Read file contents are follows, \" ");
		// Reading from a file
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			int ch;
			// Alternatively, you can use readLine() method
//			bufferedReader.readLine()
			while ((ch = bufferedReader.read()) != -1) {
				System.out.print((char) ch);
			}
		}
		System.out.println(
				"\"\nEnd of Writing and Reading character by character using BufferedWriter and BufferedReader - wrapper classes of FileWriter and FileReader");
	}
}
