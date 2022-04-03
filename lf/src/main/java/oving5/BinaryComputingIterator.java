package oving5;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {

	private final Iterator<Double> iterator1, iterator2;
	private final Double default1, default2;
	private final BinaryOperator<Double> operator;

	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1,
			Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = default1;
		this.default2 = default2;
		this.operator = operator;
	}

	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2,
			final BinaryOperator<Double> operator) {
		this(iterator1, iterator2, null, null, operator);
	}

	@Override
	public boolean hasNext() {
		return this.hasNext1() && this.hasNext2();
	}

	@Override
	public Double next() {
		return operator.apply(this.next1(), this.next2());
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove is not supported");
	}

	// Hjelpemetoder

	private boolean hasNext1() {
		return this.iterator1.hasNext() || this.default1 != null;
	}

	private boolean hasNext2() {
		return this.iterator2.hasNext() || this.default2 != null;
	}

	private double next1() {
		if (!this.hasNext1()) {
			throw new IllegalStateException("Iterator 1 has no next element!");
		}

		return this.iterator1.hasNext() ? this.iterator1.next() : this.default1;
	}

	private double next2() {
		if (!this.hasNext2()) {
			throw new IllegalStateException("Iterator 2 has no next element!");
		}

		return this.iterator2.hasNext() ? this.iterator2.next() : this.default2;
	}
}
