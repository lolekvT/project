package app;
import java.util.Scanner;

import logic.*;

public class App {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String answer;
		
		////////////////// PRZYKLADOWO DZIALAJACA APLIKACJA
		CentrumObslugi centrumobslugi = new CentrumObslugi();
		
		Banki banki = new Banki();
		Bank bank = new Bank("BZWBK");
		banki.dodaj(bank);
		
		Sklep sklep = new Sklep("ABC", "156987");
		Zaklad zaklad = new Zaklad("Fryzjek Maciek","469877");
		centrumobslugi.getListaKlientowCentrum().add(sklep);
		centrumobslugi.getListaKlientowCentrum().add(zaklad);
		
		//KartaPlatnicza kartaplatnicza1 = new KartaPlatnicza("","","",);
		
		Klient klient = new Klient("148654","Jan","Kowalski",100.0);
		Klient klient1 = new Klient("151654","Zbigniew","Kowalski",100.0);
		
		bank.dodajKlienta(klient.getKartaPlatnicza());
		bank.dodajKlienta(klient1.getKartaPlatnicza());
		System.out.println(klient.getKartaPlatnicza().getSaldo());
		//klient.getKartaPlatnicza().zaplac("156987", 20.0);
		System.out.println(klient.getKartaPlatnicza().getSaldo());
		
		if(sklep.Autoryzuj(banki, 20.0,"156987",klient.getKartaPlatnicza()) == true)
			System.out.println("Udana Autoryzacja");
		else
			System.out.println("Nieudana Autoryzacja");
		System.out.println(klient.getKartaPlatnicza().getSaldo());
			
		//////////////////////////////////
		
		
		
		System.out.println("       Witamy w centrum obslugi kart platniczych. Co ¿yczysz sobie zrobiæ: ...");
		System.out.println("1) Wyswietl firmy korzystajace z centrum");
		System.out.println("2) Wyswietl banki korzystajace z centrum");
		answer = input.nextLine();
		switch (answer) {
		
		case("1"):
			for(KlientCentrum i : centrumobslugi.getListaKlientowCentrum())
				System.out.println(i.getNazwa());
		break;
		case("2"):
			for(Bank i : banki.getListaBankow())
			{
				System.out.println(i.getNazwa());
			}
		break;
		}
	}

}
