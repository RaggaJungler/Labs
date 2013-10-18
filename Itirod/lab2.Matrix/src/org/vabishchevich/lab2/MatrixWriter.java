package org.vabishchevich.lab2;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class MatrixWriter {

	private FileWriter writer;
	private static final Logger log = Logger.getLogger(MatrixWriter.class.getSimpleName());
	private static final String MATRIX_RECORDED = "The matrix has been recorded";
	
	public MatrixWriter(String fileName) throws IOException {
		writer = new FileWriter(fileName);
	}

	public void write(Matrix matrix) throws IOException {
		writer.write(matrix.getRowsCount() + "\n");
		writer.write(matrix.getColumnsCount() + "\n");
		for (int i = 0; i < matrix.getRowsCount(); i++) {
			for (int j = 0; j < matrix.getColumnsCount(); j++) {
				writer.write(matrix.getElement(j, i) + " ");
			}
			writer.write("\n");
		}
		log.info(String.format("%s:\t %s", log.getName(), MATRIX_RECORDED));
		writer.close();
	}

}
