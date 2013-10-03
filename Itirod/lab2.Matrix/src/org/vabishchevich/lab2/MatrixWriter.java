package org.vabishchevich.lab2;

import java.io.FileWriter;
import java.io.IOException;

public class MatrixWriter {

	private FileWriter writer;

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
		writer.close();
	}

}
