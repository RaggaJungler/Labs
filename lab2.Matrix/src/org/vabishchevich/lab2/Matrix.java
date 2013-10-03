package org.vabishchevich.lab2;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Matrix<T extends List<Double>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8387101051685196662L;

	private T elements;
	private Class<T> classType;
	private int rows;
	private int columns;

	public Matrix(int rows, int cols, Class<T> type) {
		this.rows = rows;
		columns = cols;
		classType = type;		
		initialize();
	}

	private void initialize() {
		try {
			elements = classType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void fillRandom() {
		Random rand = new Random();
		for (int i = 0; i < rows * columns; i++) {
			elements.add(rand.nextDouble() * rand.nextInt(1000));
		}
	}

	public void fillIdentity() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == j) {
					elements.add(1d);
					continue;
				}
				elements.add(0d);
			}
		}
	}

	public void fillZero() {
		for (int i = 0; i < getElementsCount(); i++) {
			elements.add(0d);
		}
	}

	public int getElementsCount() {
		return rows * columns;
	}

	public int getRowsCount() {
		return rows;
	}

	public int getColumnsCount() {
		return columns;
	}

	public double getElement(int x, int y) {
		return elements.get(x + columns * y);
	}

	public void setElement(int x, int y, Double elem) {
		elements.set(x + columns * y, elem);
	}

	public void addElement(double elem) {
		elements.add(elem);
	}

	public Matrix<T> multiply(Matrix<T> other) {
		// check here matrixes sizes
		Matrix<T> result = new Matrix<>(rows, columns, classType);
		for (int k = 0; k < getRowsCount(); k++) {
			for (int i = 0; i < other.getColumnsCount(); i++) {
				double temp = 0;
				for (int j = 0; j < getColumnsCount(); j++) {
					temp += getElement(j, k) * other.getElement(j, i);
				}
				result.addElement(temp);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		DecimalFormat format = new DecimalFormat("####.###");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res.append(format.format(getElement(j, i)) + "\t");
			}
			res.append("\n");
		}
		return res.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj.getClass() == this.getClass()) {
			Matrix m = (Matrix) obj;
			for (int i = 0; i < m.rows; i++) {
				for (int j = 0; j < m.columns; j++) {
					if (this.getElement(j, i) != m.getElement(j, i)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
