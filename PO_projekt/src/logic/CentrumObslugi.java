package logic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CentrumObslugi implements Serializable{

	//List <Sklep>listaSklepow = new ArrayList<>();
	//List <Firma>listaFirm = new ArrayList<>();
	//List <Zaklad>listaZakladow = new ArrayList<>();
	
	private List <KlientCentrum>listaKlientowCentrum = new LinkedList<>();

	public List<KlientCentrum> getListaKlientowCentrum() {
		return listaKlientowCentrum;
	}

	public void setListaKlientowCentrum(List<KlientCentrum> listaKlientowCentrum) {
		this.listaKlientowCentrum = listaKlientowCentrum;
	}
	
	public void dodaj(KlientCentrum klientcentrum) {
		
		listaKlientowCentrum.add(klientcentrum);
	}
	

	
}
