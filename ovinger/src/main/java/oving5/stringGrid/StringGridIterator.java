package oving5.stringGrid;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class StringGridIterator implements Iterator<String> {

    private StringGrid grid;
    private boolean rowMajor;
    private int rowIndex;
    private int columnIndex;

    public StringGridIterator(StringGrid grid, boolean rowMajor) {
        this.grid = grid;
        this.rowMajor = rowMajor;
    }

    @Override
    public boolean hasNext() {
        if(this.grid.getElement(rowIndex, columnIndex) instanceof String)
            return true;

        if(rowIndex+1 == grid.getRowCount() && columnIndex+1 == grid.getColumnCount())
            return false;

        if(rowMajor) {
            if(rowIndex+1 < this.grid.getRowCount()) {
                rowIndex++;
                return this.hasNext();
            }

            if(rowIndex+1 == this.grid.getRowCount()) {
                rowIndex = 0;
                columnIndex++;
                return this.hasNext();
            }

        }
        else {
            if(columnIndex+1 < this.grid.getColumnCount()) {
                columnIndex++;
                return this.hasNext();
            }

            if(columnIndex+1 == this.grid.getColumnCount()) {
                columnIndex = 0;
                rowIndex++;
                return this.hasNext();
            }
        }
    }

    @Override
    public String next() {
        if(this.hasNext()) return this.grid.getElement(rowIndex++, columnIndex++);
        else throw new NoSuchElementException("There are no strings left in the grid.");
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("It's not possible to remove String objects from the grid");
    }
    
}
