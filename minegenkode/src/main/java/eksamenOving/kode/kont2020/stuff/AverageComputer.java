package eksamenOving.kode.kont2020.stuff;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Encapsulates a set of values and computes their average.
 */
public class AverageComputer {

  private Collection<Integer> values;

  /**
   * Initializes with the provided values.
   * @param initialValues
   */
  public AverageComputer(Collection<Integer> initialValues) {
    this.values = initialValues;
  }

  /**
   * Initializes with no values.
   */
  public AverageComputer() {
    this(new ArrayList<>());
  }

  /**
   * Appends value to the values.
   * @param value
   */
  public void appendValue(int value) {
    values.add(value);
  }

  /**
   * Computes the average of all values.
   * @return the average of all values
   * @throws IllegalStateException if there are no values
   */
  public double computeAverage() throws IllegalStateException {
    if (values.size() == 0) {
      throw new IllegalStateException("No values");
    }
    int sum = 0;
    for (int value : values) {
      sum += value;
    }
    return sum / values.size();
  }
}
