package org.vabishchevich.lab2.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.vabishchevich.lab2.Matrix;
import org.vabishchevich.lab2.MatrixReader;
import org.vabishchevich.lab2.MatrixWriter;

public class MatrixIOTester {

	private Matrix<List<Double>> matrix;
	private MatrixReader reader;
	private MatrixWriter writer;
	private static final Class type = ArrayList.class;
	private static final String FILE_NAME = "matrix.txt";

	@Before
	public void initialize() throws IOException {
		initializeMatrix();
		reader = new MatrixReader(FILE_NAME);
		writer = new MatrixWriter(FILE_NAME);
	}

	private void initializeMatrix() {
		matrix = new Matrix<>(3, 3, type);
		matrix.addElement(1.0);
		matrix.addElement(2.0);
		matrix.addElement(3.0);
		matrix.addElement(5.0);
		matrix.addElement(6.0);
		matrix.addElement(7.0);
		matrix.addElement(9.0);
		matrix.addElement(10.0);
		matrix.addElement(11.0);
	}

	@Test
	public void writeReadTest() throws IOException {
		writer.write(matrix);		
		Matrix m = reader.readMatrix(type);
		Assert.assertEquals(matrix, m);
	}
}
