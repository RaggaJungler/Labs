package org.vabishchevich.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class MatrixReader {

	private File file;
	private static final Logger log = Logger.getLogger(MatrixReader.class.getSimpleName());
	private static final String MATRIX_READED = "The matrix has been read";
	public MatrixReader(String fileName) {
		file = new File(fileName);
	}

	public Matrix<List<Double>> readMatrix(Class<List<Double>> type)
	        throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		sc.useLocale(Locale.US);
		Matrix<List<Double>> matrix = new Matrix<>(rows, cols, type);
		for (int i = 0; i < rows * cols; i++) {
			matrix.addElement(sc.nextDouble());
		}
		log.info(String.format("%s:\t %s", log.getName(), MATRIX_READED));
		sc.close();
		return matrix;
	}
}
