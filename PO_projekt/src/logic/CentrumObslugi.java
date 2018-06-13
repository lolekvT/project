package logic;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CentrumObslugi implements Serializable {
	private static final long serialVersionUID = 1L;
	// List <Sklep>listaSklepow = new ArrayList<>();
	// List <Firma>listaFirm = new ArrayList<>();
	// List <Zaklad>listaZakladow = new ArrayList<>();

	private List<KlientCentrum> listaKlientowCentrum = new LinkedList<>();

	public List<KlientCentrum> getListaKlientowCentrum() {
		return listaKlientowCentrum;
	}

	public void setListaKlientowCentrum(List<KlientCentrum> listaKlientowCentrum) {
		this.listaKlientowCentrum = listaKlientowCentrum;
	}

	public void dodaj(KlientCentrum klientcentrum) {
		listaKlientowCentrum.add(klientcentrum);
	}

	public List<KlientCentrum> znajdzKlientow(String nazwa) {
		List<KlientCentrum> listaWynikow = new LinkedList<>();

		for (KlientCentrum obj : listaKlientowCentrum) {
			if (obj.getNazwa().toLowerCase().equals(nazwa.toLowerCase())) {
				listaWynikow.add(obj);
			}
		}

		return listaWynikow;
	}

	public List<Object> znajdzKlientow(String nazwaFirmy, String nazwaBanku, String imie, String nazwisko, Double kwota,
			String nrKonta) {
		List<Object> listaWynikow = new LinkedList<>();

		for (KlientCentrum obj : listaKlientowCentrum) {
			if (obj.getNazwa().toLowerCase().equals(nazwaFirmy.toLowerCase())) {
				listaWynikow.addAll(obj.znajdzKlientow(nazwaBanku, imie, nazwisko, kwota, nrKonta));
			}
		}

		return listaWynikow;
	}

}
