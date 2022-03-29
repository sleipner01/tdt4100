package oving5.stringGrid;

public interface StringGrid extends Iterable<String> {
    int getRowCount();

    int getColumnCount();

    String getElement(int row, int column) throws IllegalArgumentException;

    void setElement(int row, int column, String element) throws IllegalArgumentException;
}
