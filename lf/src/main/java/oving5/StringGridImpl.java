package oving5;

import java.util.Iterator;

public class StringGridImpl implements StringGrid, Iterable<String> {

	private String[][] elements;

	public StringGridImpl(int rows, int columnCount) {
		if (rows < 1 || columnCount < 1) {
			throw new IllegalArgumentException("Row/column count should not be less than 1");
		}

		this.elements = new String[rows][columnCount];
	}

	// from StringGrid

	@Override
	public int getRowCount() {
		return this.elements.length; // Length of first array will be the amount of rows
	}

	@Override
	public int getColumnCount() {
		return this.elements[0].length; // We can look at any column array to find column count
	}

	@Override
	public String getElement(int row, int column) {
		this.checkValidElement(row, column);
		return this.elements[row][column];
	}

	@Override
	public void setElement(int row, int column, String element) {
		this.checkValidElement(row, column);
		this.elements[row][column] = element;
	}

	// from Iterable<String>

	@Override
	public Iterator<String> iterator() {
		return new StringGridIterator(this, true);
	}

	private void checkValidElement(int row, int column) {
		if (row > 0 && row < this.getRowCount() && column > 0 && column < this.getColumnCount()) {
			return;
		}

		throw new IllegalArgumentException("Illegal grid coordinates, " + row + "," + column
				+ ", for a grid of size " + getRowCount() + "," + getColumnCount());
	}
}
