package org.vabishchevich.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.vabishchevich.lab2.Matrix;

public class MatrixSerilizationTester {
	private Matrix<List<Double>> matrix;
	private static final Class type = ArrayList.class;

	@Before
	public void initialize() throws IOException {
		initializeMatrix();
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
	public void writeReadTest() throws IOException, ClassNotFoundException {
		// serialization
		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(matrix);
		oos.flush();
		oos.close();

		// deserialization
		FileInputStream fis = new FileInputStream("temp.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		Matrix<List<Double>> m = (Matrix<List<Double>>) oin.readObject();
		Assert.assertEquals(matrix, m);
	}
}
