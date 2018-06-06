package logic;

import java.util.LinkedList;
import java.util.List;

public class Klient {
	
	private KartaPlatnicza kartaplatnicza;
	private List <KartaPlatnicza>listaKartKlientow = new LinkedList<>();
	
	public Klient(String nrKonta, String imie, String nazwisko, double  saldo){
		 kartaplatnicza = new KartaDebetowa(nrKonta, imie, nazwisko, saldo);
		 listaKartKlientow.add(kartaplatnicza);
	}
	public KartaPlatnicza getKartaPlatnicza()
	{
		if(listaKartKlientow.size() != 1) {
			for(KartaPlatnicza kartaplatnicza : listaKartKlientow)
				return kartaplatnicza;
		}
			return kartaplatnicza;
	}
	public void dodajKarte(KartaPlatnicza kartaplatnicza) {
		listaKartKlientow.add(kartaplatnicza);
	}
}
