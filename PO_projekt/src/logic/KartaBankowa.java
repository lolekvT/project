package logic;

public class KartaBankowa extends KartaPlatnicza {

	public KartaBankowa(String nrKonta, String imie, String nazwisko, double saldo)
	{
		super(nrKonta, imie, nazwisko, saldo);
	}
	
	public boolean czyMoznaZaplacic(String nrKonta, double kwota){
		return false;
	}
	
	public boolean zaplac(String nrKonta, double kwota)
	{
		return czyMoznaZaplacic(nrKonta, kwota);
	}
}
