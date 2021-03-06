package logic;

public class KartaBankowa extends KartaPlatnicza {
	private static final long serialVersionUID = 1L;

	public KartaBankowa(String nrKonta, String imie, String nazwisko, double saldo) {
		super(nrKonta, imie, nazwisko, saldo);
	}

	@Override
	public boolean czyMoznaZaplacic(String nrKonta, double kwota) {
		return false;
	}

	@Override
	public boolean zaplac(String nrKonta, double kwota) {
		return czyMoznaZaplacic(nrKonta, kwota);
	}
}
