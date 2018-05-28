package logic;
import java.util.ArrayList;
import java.util.List;

public class Bank {

	public String nazwa;
	public List <KartaPlatnicza>listaKartKlientow = new ArrayList<>();
	
	
	public Bank(String nazwa) {
		super();
		this.nazwa = nazwa;
	}

	public List<KartaPlatnicza> getKartyKlientow() {
		return listaKartKlientow;
	}

	public void dodajKlienta(KartaPlatnicza kartaPlatnicza){
		listaKartKlientow.add(kartaPlatnicza);
	}
	public void usunKlienta(KartaPlatnicza kartaPlatnicza){
		listaKartKlientow.remove(kartaPlatnicza);
	}
}
