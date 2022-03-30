package uke13.abstrakt.bok;

public class Tegneseriealbum extends Bok {

	public Tegneseriealbum(String tittel, int antallSider) {
		super(tittel, antallSider);
	}

	@Override
	protected String getSjanger() {
		return "Tegneseriealbum";
	}

}
