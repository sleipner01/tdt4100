package oving5.stringGrid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringGridImpl implements StringGrid {

    private List<List<String>> grid;

    public StringGridImpl(int rows, int columnCount) {
        this.grid = new ArrayList<>();
        while(this.grid.size() < rows) {
            List<String> column = new ArrayList<>();
            while(column.size() < columnCount) {
                column.add(null);
            }
            this.grid.add(column);
        }
    }

    @Override
    public int getRowCount() {
        return this.grid.size();
    }

    @Override
    public int getColumnCount() {
        return this.grid.get(0).size();
    }

    @Override
    public String getElement(int row, int column) throws IllegalArgumentException {
        if(0 > row || row > getRowCount())
            throw new IllegalArgumentException("The row integer must be above 0 and under " + getRowCount() + ".");
    
        if(0 > column || column > getColumnCount())
            throw new IllegalArgumentException("The column integer must be above 0 and under " + getColumnCount() + ".");

        return this.grid.get(row).get(column);
    }

    @Override
    public void setElement(int row, int column, String element) throws IllegalArgumentException {
        if(0 > row || row > getRowCount())
            throw new IllegalArgumentException("The row integer must be above 0 and under " + getRowCount() + ".");
        
        if(0 > column || column > getColumnCount())
            throw new IllegalArgumentException("The column integer must be above 0 and under " + getColumnCount() + ".");

        this.grid.get(row).remove(column);
        this.grid.get(row).add(column, element);
    }

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
