package logic;

import java.util.Date;

public class KlientCentrum extends Banki {
	
	protected String nrKonta;
	protected String nazwa;
	protected String dataDolaczenia;
	protected double saldo;
	
	public String getNrKonta() {
		return nrKonta;
	}
	public void setNrKonta(String nrKonta) {
		this.nrKonta = nrKonta;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public KlientCentrum(String nazwa, String nrKonta){
		//super(nazwa);
		this.nazwa = nazwa;
		this.nrKonta = nrKonta;
	}
	public boolean Autoryzuj(Banki banki, double kwota, String nrKonta, KartaPlatnicza kartaplatnicza ) {
		boolean flaga = false;
		Date dataAutoryzacji = new Date();
		
		for(int i=0; i<banki.listaBankow.size(); i++) {
			for(int j=0; j<banki.listaBankow.get(i).listaKartKlientow.size(); j++) {
				//System.out.println(banki.listaBankow.get(i).listaKartKlientow.get(j).nrKonta+ " " +i+ " "+ j);
				if(banki.listaBankow.get(i).listaKartKlientow.get(j).nrKonta.equals(kartaplatnicza.nrKonta)
						&& (banki.listaBankow.get(i).listaKartKlientow.get(j).czyMoznaZaplacic(nrKonta, kwota) == true )
						&& banki.listaBankow.get(i).listaKartKlientow.get(j).date.after(dataAutoryzacji)){
						flaga = true;
						kartaplatnicza.zaplac(nrKonta, kwota);
						this.saldo += kwota;
				}
			}
		}
		return flaga;
	}
	public double getSaldo() {
		return saldo;
	}
	
}
