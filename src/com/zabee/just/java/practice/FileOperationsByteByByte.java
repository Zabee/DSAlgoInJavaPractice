package com.zabee.just.java.practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;;

public class FileOperationsByteByByte {

	public static void main(String[] args) throws InterruptedException, IOException {
		readAndWriteUsingUsingFileInpuStreamAndOutputStream();
		Thread.sleep(2000);
		readAndWriteUsingBufferedInputStramAndOutputStream();
	}

	private static void readAndWriteUsingUsingFileInpuStreamAndOutputStream() throws IOException {
		final String fileName = System.getProperty("user.dir") + "/FileCreatedUsingFileInpuStreamAndOutputStream.txt";
		try (FileOutputStream fileOutputStram = new FileOutputStream(fileName)) {
			fileOutputStram.write(
					"This file written using FileOutputStream and will be read using FileInputStream i.e. byte-by-byte"
							.getBytes());
			fileOutputStram.flush();
		}
		try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
			int readByteAsInt = -1;
			while ((readByteAsInt = fileInputStream.read()) != -1) {
				System.out.print((char) readByteAsInt);
			}
		}
		System.out.println();
	}

	private static void readAndWriteUsingBufferedInputStramAndOutputStream() throws IOException {
		final String fileName = System.getProperty("user.dir")
				+ "/FileCreatedUsingBufferedInputStramAndOutputStream.txt";
		try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName))) {
			bufferedOutputStream.write(
					"This file written using BufferedOutputStram and will be reda using BufferedInputStream i.e. byte-by-byte"
							.getBytes());
			bufferedOutputStream.flush();
		}

		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
			int readDataAsInt = -1;
			while ((readDataAsInt = bufferedInputStream.read()) != -1) {
				System.out.print((char) readDataAsInt);
			}
		}
	}

}
