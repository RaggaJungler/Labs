package org.vabishchevich.lab2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	private static final String FILE_NAME = "matrix.txt";
	private static final int ROWS = 100;
	private static final int COLS = 100;

	public static void main(String[] args) {
		System.out.println("ArrayList");
		System.out.println("For ArrayList time is : " + test(ArrayList.class));
		System.out.println("LinkedList");
		System.out.println("For LinkedList time is : " + test(LinkedList.class));
	}

	private static <T extends List<Double>> long test(Class<T> type) {
		Matrix<T> matrix = new Matrix<>(ROWS, COLS, type);
		Matrix<T> matrix2 = new Matrix<>(ROWS, COLS, type);
		matrix.fillRandom();
		matrix2.fillRandom();
		long timeStart = System.currentTimeMillis();
		matrix.multiply(matrix2);
		long timeEnd = System.currentTimeMillis();
		return timeEnd - timeStart;
	}
}
