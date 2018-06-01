package logic;
import java.util.ArrayList;
import java.util.List;

public class Bank {

	protected String nazwa;
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public List <KartaPlatnicza>listaKartKlientow = new ArrayList<>();
	
	
	public Bank(String nazwa) {
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
