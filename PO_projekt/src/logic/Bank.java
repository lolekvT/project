package logic;
import java.util.ArrayList;
import java.util.List;

public class Bank {

	protected List <KartaPlatnicza>listaKartKlientow = new ArrayList<>();
	protected String nazwa;
	
	public List<KartaPlatnicza> getKartyKlientow() {
		return listaKartKlientow;
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public Bank(String nazwa) {
		this.nazwa = nazwa;
	}


	public void dodajKlienta(KartaPlatnicza kartaPlatnicza){
		listaKartKlientow.add(kartaPlatnicza);
	}
	public void usunKlienta(KartaPlatnicza kartaPlatnicza){
		listaKartKlientow.remove(kartaPlatnicza);
	}
}
