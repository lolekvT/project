package logic;

public class KartaKredytowa extends KartaPlatnicza {
	
	KartaKredytowa(String nrKonta, String imie, String nazwisko, double kwota){
		super(imie, imie, imie, kwota);
	}
	
	public boolean zaplac(String nrKonta, double kwota)
	{
		saldo-=kwota;
		return true;
	}
}
