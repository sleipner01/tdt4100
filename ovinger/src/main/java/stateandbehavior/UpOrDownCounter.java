package stateandbehavior;

public class UpOrDownCounter {

    int counter;
    int end;
    int increment;

    public UpOrDownCounter(int start, int end) throws IllegalArgumentException {

        String validation = validateTimer(start, end);
        if(validation != null) {
            throw new IllegalArgumentException(validation);
        }

        if(start < end) this.increment = 1;
        else this.increment = -1;

        this.counter = start;
        this.end = end;
    }

    private String validateTimer(int start, int end) {
        if(start == end) return "The start and end can't be the same.";
        return null;
    }

    public int getCounter() {
        return this.counter;
    }

    public boolean count() {
        if(counter == end) return false;

        counter += increment;
        if(counter == end) return false;
        return true;
    }

    public static void main(String[] args) {
        UpOrDownCounter timer = new UpOrDownCounter(1, -5);
        System.out.println(timer.getCounter());
        timer.count();
        System.out.println(timer.getCounter());
        System.out.println(timer.count());
    }
}