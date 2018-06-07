package app;
import java.util.Scanner;
import logic.*;

public class App {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String answer;
		String answer1;
		//String answer2;
		double answer3;
		
		/////////////////////////////////////////////////////////////////////// PRZYKLADOWO DZIALAJACA APLIKACJA
		CentrumObslugi centrumobslugi = new CentrumObslugi();
		
		Banki banki = new Banki();
		Bank bank = new Bank("BZWBK");
		banki.dodaj(bank);
		
		Sklep sklep = new Sklep("ABC", "156987");
		Zaklad zaklad = new Zaklad("Fryzjek Maciek","469877");
		centrumobslugi.dodaj(sklep);
		centrumobslugi.dodaj(zaklad);
		
		//KartaPlatnicza kartaplatnicza1 = new KartaPlatnicza("","","",);
		
		Klient klient = new Klient("148654","Jan","Kowalski",100.0);
		Klient klient1 = new Klient("151654","Zbigniew","Kowalski",100.0);
		
		bank.dodajKlienta(klient.getKartaPlatnicza());
		bank.dodajKlienta(klient1.getKartaPlatnicza());
		System.out.println("saldo klienta przed autorzacj¹: "+klient.getKartaPlatnicza().getSaldo());
		
		if(sklep.Autoryzuj(banki, 20.0,"156987","148654") == true) 
			System.out.println("Udana Autoryzacja"); /// Nale¿y zmieniæ parametry metody Autoryzuj na(Banki banki, int kwota, String nrKonta:KlientaCentrum, String nrKonta)
		else
			System.out.println("Nieudana Autoryzacja");
		System.out.println("saldo klienta po autoryzacji: "+klient.getKartaPlatnicza().getSaldo());
		System.out.println(sklep.getSaldo());
			
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//                       PRZYKLADOWA KONSOLA
		
		System.out.println("               Witamy w centrum obslugi kart platniczych. Co ¿yczysz sobie zrobiæ: ...");
		System.out.println("1) Wyswietl firmy korzystajace z centrum");
		System.out.println("2) Wyswietl banki korzystajace z centrum");
		System.out.println("3) Dodaj firme");
		System.out.println("4) Usun firme");
		System.out.println("5) Dodaj bank");
		System.out.println("6) Usun bank");
		System.out.println("7) Obs³u¿ ¿¹danie autoryzacji");
		System.out.println("8) Przeszukaj archiwum");
		System.out.println("9) Zapisz stan systemu na dysk");
		System.out.println("10) Wyswietl karty platnicze w systemie");
		
		
		while(true) {
			answer = input.nextLine();
		switch (answer) {
		
			case("1"):
				for(KlientCentrum i : centrumobslugi.getListaKlientowCentrum())
					//System.out.println(i.getNazwa()+"    "+i.getSaldo()+"   "+i.getNrKonta());
					System.out.printf("%-17s\t %.2f$\t %10s \t%s\n", i.getNazwa(), i.getSaldo(), i.getNrKonta(), i.getDataDolaczenia());
					
			break;
			case("2"):
				for(Bank i : banki.getListaBankow())
				{
					//System.out.println(i.getNazwa());
					System.out.printf("%-17s\t %d \t%s\n", i.getNazwa(),i.getRozmiarListyKlientow(), i.getDataStworzenia());
				}
			break;
			case("3"):
				System.out.println("Twoja firma jest : 1)sklepem, 2)zakladem, 3)firma transportowa");
				answer = input.nextLine();
				if(answer.equals("1"))
				{
					System.out.println("Podaj nazwê");
					answer = input.nextLine();
					System.out.println("Podaj nrKonta");
					answer1 = input.nextLine();
					Sklep s = new Sklep(answer, answer1);
					//lsklepy.add(s);
					centrumobslugi.getListaKlientowCentrum().add(s);
					
					break;
				
				}
				if(answer.equals("2"))
				{
					System.out.println("Podaj nazwê");
					answer = input.nextLine();
					System.out.println("Podaj nrKonta");
					answer1 = input.nextLine();
					Zaklad z = new Zaklad(answer, answer1);
					//lzaklady.add(z);
					centrumobslugi.dodaj(z);
					break;
				}
				if(answer.equals("3"))
				{
					System.out.println("Podaj nazwê nowej firmy");
					answer = input.nextLine();
					System.out.println("Podaj nrKonta");
					answer1 = input.nextLine();
					Firma f = new Firma(answer, answer1);
					//lfirmy.add(f);
					centrumobslugi.dodaj(f);
					break;
				}
				else System.out.println("Nie rozumiem");
				break;
			case("6"):
					System.out.println("Podaj nazwê");
					answer = input.nextLine();
					
					for(Bank i : banki.getListaBankow())
					{
						if(i.getNazwa().equals(answer))
							banki.usun(i);
						}
					break;
			case("5"):
					System.out.println("Podaj nazwê");
					answer = input.nextLine();
					Bank b = new Bank(answer);
					banki.dodaj(b);
					break;
			case("4"):
					System.out.println("Podaj nazwê");
					answer = input.nextLine();
					for(KlientCentrum i : centrumobslugi.getListaKlientowCentrum() )
					{
						if(i.getNazwa().equals(answer))
							centrumobslugi.getListaKlientowCentrum().remove(i);
						}
					break;
			case("7"):
					System.out.println("Podaj nazwê swojej firmy");
					answer = input.nextLine();
					System.out.println("Podaj nrKonta tranzakcji(klienta)");
					answer1 = input.nextLine();
					System.out.println("Podaj kwotê tranzakcji");
					answer3 = input.nextDouble();
					Boolean flag =false;
					
					for(KlientCentrum i : centrumobslugi.getListaKlientowCentrum() )
					{
						if(i.getNazwa().equals(answer))
							if( i.Autoryzuj(banki, answer3, i.getNrKonta(), answer1) == true ) {
								System.out.println("Autoryzacja udana");
								flag = true;
								break;
							}
						}
					if(flag == false) System.out.println("Autoryzacja nieudana sprawdz dane");
			case("10"):
					for(Bank i : banki.getListaBankow()) {
						for(KartaPlatnicza j : i.getKartyKlientow())
							System.out.printf("%-15s%-15s%-15s%-15.2f%-15s\n", j.getNrKonta(), j.getImie(), j.getNazwisko(),
									j.getSaldo(),j.getData());
					}
					
		}
			
	}
	}

}
