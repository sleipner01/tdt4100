package of5_2.kode;

import java.util.function.Predicate;

public class DogPredicate implements Predicate<Animal> {

    @Override
    public boolean test(Animal t) {
        return t instanceof Dog;
    }

}
