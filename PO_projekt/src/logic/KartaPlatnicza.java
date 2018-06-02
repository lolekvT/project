package logic;

import java.util.Calendar;
import java.util.Date;

public class KartaPlatnicza {
	
	protected String nrKonta;
	protected String imie;
	protected String nazwisko;
	protected String data;
	protected Date date;
	Calendar c;
	
	protected double saldo;
	protected double kwota;
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	public KartaPlatnicza(String nrKonta, String imie, String nazwisko, double saldo)
	{
		this.nrKonta = nrKonta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.saldo = saldo;
		
		date = new Date();
		 c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 2);
		date = c.getTime();
		data = date.toString();
		
	}
	public boolean czyMoznaZaplacic(String nrKonta, double kwota){
		if(saldo - kwota > 0) 
			return true;
		return false;
	}
	
	public boolean zaplac(String nrKonta, double kwota) {
		if(czyMoznaZaplacic(nrKonta, kwota) == true) {
				saldo-=kwota;
				return true;
		}
		return false;
	}
	
	public Date getDate() {
		return date;
	}
}
