package logic;

public class KartaPlatnicza {
	
	public String nrKonta;
	public String imie;
	public String nazwisko;
	
	public double saldo;
	public double kwota;
	
	public KartaPlatnicza(String nrKonta, String imie, String nazwisko, double saldo)
	{
		this.nrKonta = nrKonta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.saldo = saldo;
	}
	
	public boolean zaplac(String nrKonta, double kwota) {
		if(saldo - kwota > 0) {
				saldo-=kwota;
				return true;
		}
		return false;
	}
}
