package org.vabushchevich.lab3.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainReader {

	private final static String FILE_NAME = "lab3.txt";

	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader(FILE_NAME);
			int[] symbols = new int[26];
			read(symbols, reader);
			print(symbols);

		} catch (FileNotFoundException e) {
			System.out.print("File not found");
		} catch (IOException e) {
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}

	}

	private static void read(int[] symbols, FileReader reader) throws IOException {
		int c;
		while ((c = reader.read()) != -1) {
			if (c - 'a' < 26 && c - 'a' >= 0) {
				symbols[c - 'a']++;
			} else {
				if (c - 'A' < 26 && c - 'A' >= 0) {
					symbols[c - 'A']++;
				}
			}
		}
	}

	private static void print(int[] symbols) {
		System.out.println("Statistic");
		for (int i = 0; i < symbols.length; i++) {
			System.out.print("" + (char) (i + 'a') + ": ");
			System.out.printf("%.3f", (double) symbols[i] / symbols.length * 100);
			System.out.print("%;\t");
		}
	}
}
