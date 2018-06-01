package logic;

public class Klient {
	
	public KartaPlatnicza kartaplatnicza;
	
	public Klient(String nrKonta, String imie, String nazwisko, double  saldo){
		 kartaplatnicza = new KartaKredytowa(nrKonta, imie, nazwisko, saldo); 
	}
	public KartaPlatnicza getKartaPlatnicza()
	{
		return kartaplatnicza;
	}
}
