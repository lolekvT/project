package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	protected List<KartaPlatnicza> listaKartKlientow = new LinkedList<>();
	protected String nazwa;
	private String dataStworzenia;

	public List<KartaPlatnicza> getKartyKlientow() {
		return listaKartKlientow;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getDataStworzenia() {
		return dataStworzenia;
	}

	public Bank(String nazwa) {
		this.nazwa = nazwa;
		dataStworzenia = new Date().toString();
	}

	public void dodajKlienta(KartaPlatnicza kartaPlatnicza) {
		listaKartKlientow.add(kartaPlatnicza);
	}

	public void usunKlienta(KartaPlatnicza kartaPlatnicza) {
		listaKartKlientow.remove(kartaPlatnicza);
	}

	public int getRozmiarListyKlientow() {
		return listaKartKlientow.size();
	}
}
