import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SomeFileOperations {

	private static String fileName = "zabee.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(fileName);
		fileWrite(file);
		fileRead(file);
		fileAppend(file);
		fileRead(file);
	}

	private static void fileWrite(File argFile) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(argFile)) {
			fos.write("This is a typical file for testing only".getBytes());
			fos.flush();
		}
	}

	private static void fileRead(File argFile) throws IOException {
		try (FileInputStream fis = new FileInputStream(argFile)) {
			byte[] fileBytes = new byte[1024];
			while ((fis.read(fileBytes)) != -1) {
				System.out.print(new String(fileBytes, "UTF-8"));
			}
		}

	}

	private static void fileAppend(File argFile) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(argFile, true)) {
			fos.write(". Appending this text".getBytes());
			fos.flush();
			System.out.println();
		}
	}
}
