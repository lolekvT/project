package logic;

public class KartaKredytowa extends KartaPlatnicza {
	
	KartaKredytowa(String nrKonta, String imie, String nazwisko, double saldo){
		super(nrKonta, imie, nazwisko, saldo);
	}
	
	public boolean czyMoznaZaplacic(String nrKonta, double kwota){
		return true;
	}
	
	public boolean zaplac(String nrKonta, double kwota)
	{
		saldo-=kwota;
		return czyMoznaZaplacic(nrKonta, kwota);
	}
}
