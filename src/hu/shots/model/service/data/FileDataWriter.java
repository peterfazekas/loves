package hu.shots.model.service.data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDataWriter {

	private final String fileName;

	public FileDataWriter(String fileName) {
		this.fileName = fileName;
	}
	
	public void printAll(final String text) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			pw.print(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
