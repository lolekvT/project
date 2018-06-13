package logic;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Banki implements Serializable {

	private static final long serialVersionUID = 1L;
	protected List<Bank> listaBankow = new LinkedList<>();

	public Banki() {
	};

	public List<Bank> getListaBankow() {
		return listaBankow;
	}

	public void setListaBankow(List<Bank> listaBankow) {
		this.listaBankow = listaBankow;
	}

	public void dodaj(Bank bank) {
		listaBankow.add(bank);
	}

	public void usun(Bank bank) {
		listaBankow.remove(bank);
	}

	public List<Bank> znajdzBanki(String nazwa) {
		List<Bank> listaWynikow = new LinkedList<>();

		for (Bank obj : listaBankow) {
			if (obj.getNazwa().toLowerCase().equals(nazwa.toLowerCase())) {
				listaWynikow.add(obj);
			}
		}

		return listaWynikow;
	}

	public List<KartaPlatnicza> znajdzKlientow(String imie, String nazwisko) {
		List<KartaPlatnicza> listaWynikow = new LinkedList<>();
		List<KartaPlatnicza> listaKartKlientow;

		for (Bank bank : listaBankow) {
			listaKartKlientow = bank.getKartyKlientow();
			for (KartaPlatnicza obj : listaKartKlientow) {
				if (obj.getImie().toLowerCase().equals(imie.toLowerCase())
						&& obj.getNazwisko().toLowerCase().equals(nazwisko.toLowerCase())) {
					listaWynikow.add(obj);
				}
			}
		}

		return listaWynikow;
	}
}
