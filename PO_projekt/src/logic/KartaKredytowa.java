package logic;

public class KartaKredytowa extends KartaPlatnicza {
	private static final long serialVersionUID = 1L;

	KartaKredytowa(String nrKonta, String imie, String nazwisko, double saldo) {
		super(nrKonta, imie, nazwisko, saldo);
	}

	@Override
	public boolean czyMoznaZaplacic(String nrKonta, double kwota) {
		return true;
	}

	@Override
	public boolean zaplac(String nrKonta, double kwota) {
		saldo -= kwota;
		return czyMoznaZaplacic(nrKonta, kwota);
	}
}
