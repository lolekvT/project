package logic;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class KartaPlatnicza implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String nrKonta;
	protected String imie;
	public String id;
	protected String nazwisko;
	protected String data;
	protected String dataStworzenia;
	protected Date date;
	Calendar c;

	protected double saldo;
	protected double kwota;

	public double getSaldo() {
		return saldo;
	}

	public String getNrKonta() {
		return nrKonta;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public String getData() {
		return data;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public KartaPlatnicza(String nrKonta, String imie, String nazwisko, double saldo) {
		this.nrKonta = nrKonta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.saldo = saldo;

		date = new Date();
		dataStworzenia = date.toString();
		c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 2);
		date = c.getTime();
		data = date.toString();

	}

	public KartaPlatnicza() {
		this.nrKonta = "986566";
		this.imie = "JAn";
		this.nazwisko = "Nowak";
		this.saldo = 100.00;
		this.id = "asd";

	}

	public boolean czyMoznaZaplacic(String nrKonta, double kwota) {
		if (saldo - kwota > 0)
			return true;
		return false;
	}

	public boolean zaplac(String nrKonta, double kwota) {
		if (czyMoznaZaplacic(nrKonta, kwota) == true) {
			saldo -= kwota;
			return true;
		}
		return false;
	}

	public Date getDate() {
		return date;
	}

	public String getDataStworzenia() {
		return dataStworzenia;
	}

	@Override
	public String toString() {
		return "Nr Konta: " + getNrKonta() + " Imie: " + getImie() + " Nazwisko: " + getNazwisko() + " Saldo: "
				+ getSaldo() + " Data Stworzenia: " + getDataStworzenia();
	}
}
