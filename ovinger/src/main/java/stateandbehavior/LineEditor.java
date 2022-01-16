package stateandbehavior;

public class LineEditor {

    String text;
    int insertionIndex;

    public LineEditor() {
        insertionIndex = 0;
    }

    public void left() {
        this.insertionIndex--;
    }

    public void right() {
        this.insertionIndex++;
    }

    public void deleteLeft() {

    }

    public void deleteRight() {

    }

    public void insertString(String s) {

    }

    public String getText() {
        return this.text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public int getInsertionIndex() {
        return this.insertionIndex;
    }

    public void setInsertionIndex(int index) {
        this.insertionIndex = index;
    }

    public static void main(String[] args) {
        
    }

    @Override
    public String toString() {
        return "";
    }
    
}
