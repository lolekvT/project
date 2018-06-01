package app;
import java.util.Scanner;

import logic.*;

public class App {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String answer;
		
		/// PRZYKLADOWO DZIALAJACA APLIKACJA
		CentrumObslugi centrumobslugi = new CentrumObslugi();
		
		Banki banki = new Banki();
		Bank bank = new Bank("BZWBK");
		banki.dodaj(bank);
		//System.out.println(banki.listaBankow.get(0).nazwa);
		
		Sklep sklep = new Sklep("ABC", "156987");
		KlientCentrum klientcentrum = new KlientCentrum("ABC","156789");
		//KartaPlatnicza kartaplatnicza1 = new KartaPlatnicza("","","",)
		Klient klient = new Klient("148654","Jan","Kowalski",100.0);
		bank.dodajKlienta(klient.getKartaPlatnicza());
		System.out.println(klient.kartaplatnicza.saldo);
		klient.kartaplatnicza.zaplac("156987", 20.0);
		System.out.println(klient.kartaplatnicza.saldo);
		bank.listaKartKlientow.add(klient.getKartaPlatnicza());
		
		if(klientcentrum.Autoryzuj(banki, 20.0, klient.kartaplatnicza) == true)
			System.out.println("Udana Autoryzacja");
		else
			System.out.println("Nieudana Autoryzacja");
			
		//////////////////////////////////
		
		answer = input.nextLine();
		
		System.out.println("Witamy w centrum obslugi kart platniczych. Co ¿yczysz sobie zrobiæ: ...");
		System.out.println("1) Wyswietl firmy korzystajace z centrum");
		System.out.println("2) Wyswietl banki korzystajace z centrum");
		switch (answer) {
		
		case("1"):
			
		
		}
	}

}
