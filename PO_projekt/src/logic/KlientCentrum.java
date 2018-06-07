package logic;

import java.util.Date;

public class KlientCentrum extends Banki {
	private static final long serialVersionUID = 1L;
	protected String nrKonta;
	protected String nazwa;
	protected String dataDolaczenia;
	private KartaPlatnicza kartaplatnicza;
	protected double saldo;

	public KlientCentrum(String nazwa, String nrKonta) {
		// super(nazwa);
		this.nazwa = nazwa;
		this.nrKonta = nrKonta;
		dataDolaczenia = new Date().toString();
	}

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

	public String getDataDolaczenia() {
		return dataDolaczenia;
	}

	public boolean Autoryzuj(Banki banki, double kwota, String nrKontaFirmy, String nrKonta) {
		boolean flaga = false;
		Date dataAutoryzacji = new Date();

		for (int i = 0; i < banki.listaBankow.size(); i++) {
			for (int j = 0; j < banki.listaBankow.get(i).listaKartKlientow.size(); j++) {
				// System.out.println(banki.listaBankow.get(i).listaKartKlientow.get(j).nrKonta+
				// " " +i+ " "+ j);
				if (banki.listaBankow.get(i).listaKartKlientow.get(j).nrKonta.equals(nrKonta)
						&& (banki.listaBankow.get(i).listaKartKlientow.get(j).czyMoznaZaplacic(nrKonta, kwota) == true)
						&& banki.listaBankow.get(i).listaKartKlientow.get(j).date.after(dataAutoryzacji)) {
					flaga = true;
					kartaplatnicza = banki.listaBankow.get(i).listaKartKlientow.get(j);
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

	@Override
	public String toString() {
		return "Nazwa: " + getNazwa() + " Konto: " + getNrKonta() + " Data dolaczenia: " + getDataDolaczenia();
	}

}
