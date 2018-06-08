package logic;

public class KartaKredytowa extends KartaPlatnicza {
	private static final long serialVersionUID = 1L;

	KartaKredytowa(String nrKonta, String imie, String nazwisko, double saldo, String id) {
		super(nrKonta, imie, nazwisko, saldo, id);
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
