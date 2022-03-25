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
        // Har laget oppgaven med tanke på at rowMajor går radvis...
        if(!rowMajor) {
            while(columnIndex < grid.getColumnCount()) {
                while(rowIndex < grid.getRowCount()) {
                    // System.out.println(rowIndex + ":" + columnIndex);
                    if(this.grid.getElement(rowIndex, columnIndex) instanceof String) {
                        return true;
                    }
                    rowIndex++;       
                }
                rowIndex = 0;
                columnIndex++;
            }
            return false;
        }
        else {
            while(rowIndex < grid.getRowCount()) {
                while(columnIndex < grid.getColumnCount()) {
                    if(this.grid.getElement(rowIndex, columnIndex) instanceof String) {
                        return true;
                    }
                    columnIndex++;       
                }
                columnIndex = 0;
                rowIndex++;
            }
            return false;
        }


        // if(rowMajor) {
        //     if(rowIndex+1 < this.grid.getRowCount()) {
        //         rowIndex++;
        //         this.hasNext();
        //     }

        //     if(rowIndex+1 == this.grid.getRowCount()) {
        //         rowIndex = 0;
        //         columnIndex++;
        //         this.hasNext();
        //     }

        // }
        // else {
        //     if(columnIndex+1 < this.grid.getColumnCount()) {
        //         columnIndex++;
        //         this.hasNext();
        //     }

        //     if(columnIndex+1 == this.grid.getColumnCount()) {
        //         columnIndex = 0;
        //         rowIndex++;
        //         this.hasNext();
        //     }
        // }
    }

    @Override
    public String next() {
        if(this.hasNext()) {
            if(!rowMajor) return this.grid.getElement(rowIndex++, columnIndex);
            else return this.grid.getElement(rowIndex, columnIndex++);
        }
        else throw new NoSuchElementException("There are no strings left in the grid.");
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("It's not possible to remove String objects from the grid");
    }

    public static void main(String[] args) {
        StringGrid grid = new StringGridImpl(3, 3);
        grid.setElement(0, 0, "Hei");
        grid.setElement(1, 0, "Hei2");
        grid.setElement(2, 0, "Hei3");
        grid.setElement(0, 1, "Hei3");

        StringGridIterator iterator = new StringGridIterator(grid, true);

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
}
