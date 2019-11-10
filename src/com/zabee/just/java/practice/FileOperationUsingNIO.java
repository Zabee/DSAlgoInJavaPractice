package com.zabee.just.java.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class FileOperationUsingNIO {

	public static void main(String[] args) throws IOException {
		fileWrite();
		fileRead();

		countDotJavaFilesInThisProject();
	}

	private static void countDotJavaFilesInThisProject() throws IOException {
		Path rootPath = Paths.get(System.getProperty("user.dir"));
		//NIO way
		Stream<Path> paths = Files.walk(rootPath);
		long javaFilesCount = paths.filter(path -> path != null)//
				.map(path -> path.getFileName().toString())//
				.filter(fileName -> fileName.endsWith(".java"))//
				.count();
		System.out.println("There are " +  javaFilesCount + " java files in this project");
	}

	private static void fileRead() throws IOException {
		Path filePath = Paths.get(System.getProperty("user.dir"), "WrittenAndReadUsingNIO.txt");
		List<String> fileLines = Files.readAllLines(filePath);
		System.out.println("Read file contents are : ");
		fileLines.stream()//
				.forEach(System.out::println);
	}

	private static void fileWrite() throws IOException {
		Path filePath = Paths.get(System.getProperty("user.dir"), "WrittenAndReadUsingNIO.txt");
		Files.write(filePath, "This file written and will be reading using file NIO".getBytes(),
				StandardOpenOption.CREATE);
	}

}
