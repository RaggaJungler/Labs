package org.vabishchevich.lab2.tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.vabishchevich.lab2.Matrix;

public class MatrixTester {

	private Matrix<List<Double>> zeroMatrix;
	private Matrix<List<Double>> zero2Matrix;
	private Matrix<List<Double>> identityMatrix;
	private Matrix<List<Double>> identity2Matrix;
	private Matrix<List<Double>> firstMatrix;
	private Matrix<List<Double>> secondMatrix;
	private Class type = ArrayList.class;
	private int dim = 2;
	private int dim2 = 3;

	@Before
	public void initialize() {
		fillZeros();
		fillIdentity();
		fillFirst();
		fillSecond();
	}

	private <T extends List<Double>> void fillZeros() {
		zeroMatrix = new Matrix<>(dim, dim, type);
		zeroMatrix.fillZero();
		zero2Matrix = new Matrix<>(dim, dim, type);
		zero2Matrix.fillZero();
	}

	private void fillIdentity() {
		identityMatrix = new Matrix<>(dim, dim, type);
		identityMatrix.fillIdentity();
		identity2Matrix = new Matrix<>(dim, dim, type);
		identity2Matrix.fillIdentity();
	}

	private void fillFirst() {
		firstMatrix = new Matrix<>(dim2, dim2, type);
		firstMatrix.addElement(1.0);
		firstMatrix.addElement(2.0);
		firstMatrix.addElement(3.0);
		firstMatrix.addElement(5.0);
		firstMatrix.addElement(6.0);
		firstMatrix.addElement(7.0);
		firstMatrix.addElement(9.0);
		firstMatrix.addElement(10.0);
		firstMatrix.addElement(11.0);
	}

	private void fillSecond() {
		secondMatrix = new Matrix<>(dim2, dim2, type);
		secondMatrix.addElement(1.0);
		secondMatrix.addElement(2.0);
		secondMatrix.addElement(2.0);
		secondMatrix.addElement(2.0);
		secondMatrix.addElement(2.0);
		secondMatrix.addElement(2.0);
		secondMatrix.addElement(2.0);
		secondMatrix.addElement(2.0);
		secondMatrix.addElement(2.0);
	}

	@Test
	public void zeroOnZero() {
		Matrix<List<Double>> res = zeroMatrix.multiply(zero2Matrix);
		Assert.assertEquals(res.getElement(0, 0), 0d);
		Assert.assertEquals(res.getElement(0, 1), 0d);
		Assert.assertEquals(res.getElement(1, 0), 0d);
		Assert.assertEquals(res.getElement(1, 1), 0d);
	}

	@Test
	public void identityOnZero() {
		Matrix<List<Double>> res = identityMatrix.multiply(zeroMatrix);
		Assert.assertEquals(res.getElement(0, 0), 0d);
		Assert.assertEquals(res.getElement(0, 1), 0d);
		Assert.assertEquals(res.getElement(1, 0), 0d);
		Assert.assertEquals(res.getElement(1, 1), 0d);
	}

	@Test
	public void zeroOnIdentity() {
		Matrix<List<Double>> res = zeroMatrix.multiply(identityMatrix);
		Assert.assertEquals(res.getElement(0, 0), 0d);
		Assert.assertEquals(res.getElement(0, 1), 0d);
		Assert.assertEquals(res.getElement(1, 0), 0d);
		Assert.assertEquals(res.getElement(1, 1), 0d);
	}

	@Test
	public void identityOnIdentity() {
		Matrix<List<Double>> res = identity2Matrix.multiply(identityMatrix);
		Assert.assertEquals(res.getElement(0, 0), 1d);
		Assert.assertEquals(res.getElement(0, 1), 0d);
		Assert.assertEquals(res.getElement(1, 0), 0d);
		Assert.assertEquals(res.getElement(1, 1), 1d);
	}

	@Test
	public void multiplyTest() {
		Matrix<List<Double>> res = firstMatrix.multiply(secondMatrix);
		Assert.assertEquals(res.getElement(0, 0), 11d);
		Assert.assertEquals(res.getElement(1, 0), 12d);
		Assert.assertEquals(res.getElement(2, 0), 12d);
		Assert.assertEquals(res.getElement(0, 1), 31d);
		Assert.assertEquals(res.getElement(1, 1), 36d);
		Assert.assertEquals(res.getElement(2, 1), 36d);
		Assert.assertEquals(res.getElement(0, 2), 51d);
		Assert.assertEquals(res.getElement(1, 2), 60d);
		Assert.assertEquals(res.getElement(2, 2), 60d);
	}

}
