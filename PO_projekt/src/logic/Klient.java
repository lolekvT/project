package logic;

import java.util.LinkedList;
import java.util.List;

public class Klient {
	
	private KartaPlatnicza kartaplatnicza;
	private List <KartaPlatnicza>listaKartKlientow;
	public String id;
	
	public Klient(String nrKonta, String imie, String nazwisko, double  saldo, String id){
		 kartaplatnicza = new KartaDebetowa(nrKonta, imie, nazwisko, saldo, id);
		 listaKartKlientow = new LinkedList<>();
		 listaKartKlientow.add(kartaplatnicza);
		 this.id = id;
	}
	public KartaPlatnicza getKartaPlatnicza()
	{
		if(listaKartKlientow.size() != 1) {
			for(KartaPlatnicza kartaplatnicza : listaKartKlientow)
				return kartaplatnicza;
		}
			return kartaplatnicza;
	}
	public void dodajKarte(KartaPlatnicza kartaplatnicza1) {
		if(this.id.equals(kartaplatnicza1.id) && this.kartaplatnicza.getImie().equals(kartaplatnicza1.getImie())
				&& this.kartaplatnicza.getNazwisko().equals(kartaplatnicza1.getNazwisko()))
			listaKartKlientow.add(kartaplatnicza1);
	}
}
