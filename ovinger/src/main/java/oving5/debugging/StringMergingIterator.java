package oving5.debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second) {
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();
	}

	@Override
	public String next() {

		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		// Massiv syntaksfeil. TurnSwitch ble byttet om inni ifsene, som gjorde at både first og second ble kjørt i første iterasjon.
		// De to første ifsene satte seg selv til result selv om den ikke hadde noen next. 

		// Nå har jeg gjort om slik at annenhver funksjonen kjører fram til en av listene ikke har flere elementer.
		// Da vil result være null. Så ser vi hvilken iterator som har flere elementer, og returnerer dem direkte.

		String result = null;

		if (turnSwitch && first.hasNext()) result = first.next();
		if (!turnSwitch && second.hasNext()) result = second.next();

		if(Objects.isNull(result)) {
			if (!first.hasNext()) return second.next();	
			if (!second.hasNext()) return first.next();
		}
		
		if (turnSwitch) turnSwitch = false;
		else turnSwitch = true;

		return result;

	}

}