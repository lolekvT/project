package logic;

public class KlientCentrum extends Banki {
	
	protected String nrKonta;
	protected String nazwa;
	
	public KlientCentrum(String nazwa, String nrKonta){
		//super(nazwa);
		this.nazwa = nazwa;
		this.nrKonta = nrKonta;
	}
	public boolean Autoryzuj(Banki banki, double kwota, KartaPlatnicza kartaplatnicza ) {
		boolean flaga = false;
		
		for(int i=0; i<banki.listaBankow.size(); i++) {
			for(int j=0; j<banki.listaBankow.get(i).listaKartKlientow.size(); j++) {
				if(banki.listaBankow.get(i).listaKartKlientow.get(j).nrKonta.equals(kartaplatnicza.nrKonta)
						&& (banki.listaBankow.get(i).listaKartKlientow.get(j).saldo > kwota)) {
						flaga = true;
				}
			}
		}
		return flaga;
	}
	
}
