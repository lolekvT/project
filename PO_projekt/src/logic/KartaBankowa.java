package logic;

public class KartaBankowa extends KartaPlatnicza {

	KartaBankowa(String nrKonta, String imie, String nazwisko, double kwota)
	{
		super(nazwisko, nazwisko, nazwisko, kwota);
	}
	
	public boolean zaplac(String nrKonta, double kwota)
	{
		return false;
	}
}
