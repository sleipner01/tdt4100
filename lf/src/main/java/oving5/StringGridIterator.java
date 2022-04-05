package oving5;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {

	private final StringGrid grid;
	private final boolean rowMajor;

	private int row, column;

	public StringGridIterator(StringGrid grid, boolean rowMajor) {
		this.grid = grid;
		this.rowMajor = rowMajor;
		this.row = 0;
		this.column = 0;
	}

	@Override
	public boolean hasNext() {
		return row < grid.getRowCount() && column < grid.getColumnCount();
	}

	@Override
	public String next() {
		String element = this.grid.getElement(row, column);

		if (this.rowMajor) {
			if (++column >= this.grid.getColumnCount()) {
				column = 0;
				row = row + 1;
			}
		} else {
			if (++row >= this.grid.getRowCount()) {
				row = 0;
				column = column + 1;
			}
		}

		return element;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("GridIterator does not not support remove");
	}
}
