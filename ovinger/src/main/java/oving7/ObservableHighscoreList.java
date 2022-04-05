package oving7;

import java.util.ArrayList;
import java.util.List;

public class ObservableHighscoreList extends ObservableList {

    private int maxLength;
    private List<Integer> results = new ArrayList<>();
    private List<ObservableListListener> observers = new ArrayList<>();
    
    public ObservableHighscoreList(int maxLength) {
        this.maxLength = maxLength;
    }

    public int size() {
        return results.size();
    }

    public int getElement(int index) {
        return results.get(index);
    }

    public void addResult(int result) {
        if(this.size() < maxLength) {
            results.add(result);
            results.sort((a, b) -> a-b);
            return;
        }

        if(result > this.results.get(maxLength-1)) return;

        for (int i = 0; i < results.size(); i++) {
            if(result < results.get(i)) {
                results.add(result);
                results.sort((a, b) -> a-b);
                results.remove(maxLength);
                return;
            }

        }
    }

    public void addObservableListListener(ObservableListListener observer) {
        if(!observers.contains(observer)) observers.add(observer);
    }

    public void removeObservableListListener(ObservableListListener observer) {
        if(observers.contains(observer)) observers.remove(observer);
    }

    @Override
    public String toString() {
        return this.results.toString();
    }

    public static void main(String[] args) {
        ObservableHighscoreList highscoreList = new ObservableHighscoreList(3);

        highscoreList.addResult(5);
		highscoreList.addResult(6);
		highscoreList.addResult(2);
		highscoreList.addResult(3);
		// highscoreList.addResult(1);


        System.out.println(highscoreList.toString());
        
    }

}
