package logic;

public class KartaPlatnicza {
	
	protected String nrKonta;
	protected String imie;
	protected String nazwisko;
	
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
	}
	
	public boolean zaplac(String nrKonta, double kwota) {
		if(saldo - kwota > 0) {
				saldo-=kwota;
				return true;
		}
		return false;
	}
}
