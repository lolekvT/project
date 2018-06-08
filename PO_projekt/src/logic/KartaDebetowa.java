package logic;

public class KartaDebetowa extends KartaPlatnicza {
	private static final long serialVersionUID = 1L;

	public KartaDebetowa(String nrKonta, String imie, String nazwisko, double kwota) {
		super(nrKonta, imie, nazwisko, kwota);
	}
	public KartaDebetowa()
	{
		super();
	}
}
