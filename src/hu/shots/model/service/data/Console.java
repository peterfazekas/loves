package hu.shots.model.service.data;

import java.util.Scanner;

public class Console {
	
	private final Scanner scanner = new Scanner(System.in);
	
	public int readInt(final String text) {
		System.out.print(text);
		return scanner.nextInt();
	}

}
