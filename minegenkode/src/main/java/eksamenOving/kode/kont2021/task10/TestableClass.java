package eksamenOving.kode.kont2021.task10;

public class TestableClass {
     
    private Integer myInteger;
    private String myString;
     
    public TestableClass(Integer myInteger, String myString) {
        this.myInteger = myInteger;
        this.myString = myString;
    }
     
    /**
     *
     * @param otherString a string
     * @return whether myString text value is equal to the otherString
     */
    public boolean isMyStringEqualTo(String otherString) {
        return this.myString == otherString;
    }
     
    /**
     *
     * @return myInteger + 1;
     */
    public Integer getMyIntegerIncrement() {
        return this.myInteger + 1;
    }
}