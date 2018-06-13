package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import logic.Bank;
import logic.Banki;
import logic.CentrumObslugi;
import logic.Firma;
import logic.KartaDebetowa;
import logic.KartaPlatnicza;
import logic.KlientCentrum;
import logic.Sklep;
import logic.Zaklad;

public class App {

	// Pliki musza istniec na dysku twardym przed load
	/// trzeba podzielic maina :/
	public static String saveDir = "c:\\temp\\";
	public static String saveCentrumPath = saveDir + "centrum.ser";
	public static String saveBankiPath = saveDir + "banki.ser";

	public static Object loadObjectsFromFile(String path) {
		try {
			FileInputStream fin = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fin);
			Object obj = ois.readObject();

			System.out.println("Wczytano obiekty(" + obj.getClass().getName() + ") z pliku: " + path);
			ois.close();
			return obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void saveObjectsToFile(Object saveObj, String path) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
			fout = new FileOutputStream(path);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(saveObj);

			System.out.println("Zapisano obiekty (" + saveObj.getClass().getName() + ") do pliku: " + path);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void searchOR(CentrumObslugi centrum, Banki banki, String firma, String bank, String imieKlienta,
			String nazwiskoKlienta, String numerKarty, String kwota) {
		List<Object> listaWynikow = new LinkedList<>();

		listaWynikow.addAll(centrum.znajdzKlientow(firma));
		listaWynikow.addAll(banki.znajdzBanki(bank));
		listaWynikow.addAll(banki.znajdzKlientow(imieKlienta, nazwiskoKlienta));

		// Wypisz wyniki na ekran
		System.out.println("Lista wynikow:");
		for (Object obj : listaWynikow) {
			System.out.println(obj);
		}
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String answer;
		String answer1;
		String answer2;
		double answer3;
		String answer4;

		/////////////////////////////////////////////////////////////////////// PRZYKLADOWO
		/////////////////////////////////////////////////////////////////////// DZIALAJACA
		/////////////////////////////////////////////////////////////////////// APLIKACJA
		CentrumObslugi centrumobslugi = new CentrumObslugi();
		Banki banki = new Banki();

		// centrumobslugi = loadObjectsFromFile();

		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// PRZYKLADOWA KONSOLA

		System.out.println("               Witamy w centrum obslugi kart platniczych. Co ¿yczysz sobie zrobiæ: ...");
		System.out.println("1) Wyswietl firmy korzystajace z centrum");
		System.out.println("2) Wyswietl banki korzystajace z centrum");
		System.out.println("3) Dodaj firme");
		System.out.println("4) Usun firme");
		System.out.println("5) Dodaj bank");
		System.out.println("6) Usun bank");
		System.out.println("7) Obs³u¿ ¿¹danie autoryzacji");
		System.out.println("8) Przeszukaj archiwum");
		System.out.println("10) Wyswietl karty platnicze w systemie");
		System.out.println("11) Zapisz stan systemu na dysk");
		System.out.println("12) Wczytaj stan systemy z dysku");
		System.out.println("13) Wczytaj przykladowe dane systemu");
		System.out.println("14) Dodaj karte platnicza");
		System.out.println("15) Usun karte platnicza");

		while (true) {
			answer = input.nextLine();
			switch (answer) {

			case ("1"):
				for (KlientCentrum i : centrumobslugi.getListaKlientowCentrum())
					// System.out.println(i.getNazwa()+" "+i.getSaldo()+" "+i.getNrKonta());
					System.out.printf("%-17s\t %.2f$\t %10s \t%s\n", i.getNazwa(), i.getSaldo(), i.getNrKonta(),
							i.getDataDolaczenia());

				break;
			case ("2"):
				for (Bank i : banki.getListaBankow()) {
					// System.out.println(i.getNazwa());
					System.out.printf("%-17s\t %d \t%s\n", i.getNazwa(), i.getRozmiarListyKlientow(),
							i.getDataStworzenia());
				}
				break;
			case ("3"):
				System.out.println("Twoja firma jest : 1)sklepem, 2)zakladem, 3)firma transportowa");
				answer = input.nextLine();
				if (answer.equals("1")) {
					System.out.println("Podaj nazwê");
					answer = input.nextLine();
					System.out.println("Podaj nrKonta");
					answer1 = input.nextLine();
					Sklep s = new Sklep(answer, answer1);
					centrumobslugi.dodaj(s);
					break;
				}
				if (answer.equals("2")) {
					System.out.println("Podaj nazwê");
					answer = input.nextLine();
					System.out.println("Podaj nrKonta");
					answer1 = input.nextLine();
					Zaklad z = new Zaklad(answer, answer1);
					// lzaklady.add(z);
					centrumobslugi.dodaj(z);
					break;
				}
				if (answer.equals("3")) {
					System.out.println("Podaj nazwê nowej firmy");
					answer = input.nextLine();
					System.out.println("Podaj nrKonta");
					answer1 = input.nextLine();
					Firma f = new Firma(answer, answer1);
					// lfirmy.add(f);
					centrumobslugi.dodaj(f);
					break;
				} else
					System.out.println("Nie rozumiem");
				break;
			case ("6"):
				System.out.println("Podaj nazwê");
				answer = input.nextLine();

				for (Bank i : banki.getListaBankow()) {
					if (i.getNazwa().equals(answer))
						banki.usun(i);
				}
				break;
			case ("5"):
				System.out.println("Podaj nazwê");
				answer = input.nextLine();
				Bank b = new Bank(answer);
				banki.dodaj(b);
				break;
			case ("4"):
				System.out.println("Podaj nazwê");
				answer = input.nextLine();
				for (KlientCentrum i : centrumobslugi.getListaKlientowCentrum()) {
					if (i.getNazwa().equals(answer))
						centrumobslugi.getListaKlientowCentrum().remove(i);
				}
				break;
			case ("7"):
				System.out.println("Podaj nazwê swojej firmy");
				answer = input.nextLine();
				System.out.println("Podaj nrKonta tranzakcji(klienta)");
				answer1 = input.nextLine();
				System.out.println("Podaj kwotê tranzakcji");
				answer3 = input.nextDouble();
				Boolean flag = false;

				for (KlientCentrum i : centrumobslugi.getListaKlientowCentrum()) {
					if (i.getNazwa().equals(answer))
						if (i.Autoryzuj(banki, answer3, i.getNrKonta(), answer1) == true) {
							System.out.println("Autoryzacja udana");
							flag = true;
							break;
						}
				}
				if (flag == false) {
					System.out.println("Autoryzacja nieudana sprawdz dane");
					break;
				}

			case ("10"):
				for (Bank i : banki.getListaBankow()) {
					for (KartaPlatnicza j : i.getKartyKlientow())
						System.out.printf("%-15s%-15s%-15s%-15.2f%-15s\n", j.getNrKonta(), j.getImie(), j.getNazwisko(),
								j.getSaldo(), j.getData());
				}
				break;
			case ("8"):
				searchOR(centrumobslugi, banki, "ABC", "BZWBK", "Jan", "Kowalski", "", "");
				break;
			case ("11"):
				saveObjectsToFile(centrumobslugi, saveCentrumPath);
				saveObjectsToFile(banki, saveBankiPath);
				break;
			case ("12"):
				centrumobslugi = (CentrumObslugi) loadObjectsFromFile(saveCentrumPath);
				banki = (Banki) loadObjectsFromFile(saveBankiPath);
				break;
			case ("13"):
				Bank bank = new Bank("BZWBK");
				banki.dodaj(bank);

				Sklep sklep = new Sklep("ABC", "156987");
				Zaklad zaklad = new Zaklad("Fryzjek Maciek", "469877");
				centrumobslugi.dodaj(sklep);
				centrumobslugi.dodaj(zaklad);

				KartaDebetowa kartadebetowa = new KartaDebetowa("123654", "Joanna", "Krawczyk", 100.0);
				KartaDebetowa kartadebetowa1 = new KartaDebetowa("123656", "Adam", "Malysz", 1000.0);
				KartaDebetowa kartadebetowa2 = new KartaDebetowa("567896", "Jan", "Destrojer", 100000.0);

				bank.dodajKarteKlienta(kartadebetowa);
				bank.dodajKarteKlienta(kartadebetowa1);
				bank.dodajKarteKlienta(kartadebetowa2);
				System.out.println("saldo klienta przed autoryzacj¹: " + kartadebetowa.getSaldo());

				if (sklep.Autoryzuj(banki, 20.0, "156987", "123654") == true)
					System.out.println("Udana Autoryzacja"); /// Nale¿y zmieniæ parametry metody Autoryzuj na(Banki
																/// banki, int kwota, String nrKonta:KlientaCentrum,
																/// String nrKonta)
				else
					System.out.println("Nieudana Autoryzacja");
				System.out.println("saldo klienta po autoryzacji: " + kartadebetowa.getSaldo());
				System.out.println(sklep.getSaldo());
				break;
			case ("14"):
				System.out.println("Podaj nrkonta, imie, nazwisko, saldo, id, nazwê banku");
				answer = input.nextLine();
				System.out.println("Podaj imie");
				answer1 = input.nextLine();
				System.out.println("Podaj nazwisko");
				answer2 = input.nextLine();
				System.out.println("nazwê banku");
				answer4 = input.nextLine();
				boolean flaga = false;
				System.out.println("saldo");
				answer3 = input.nextDouble();
				int m = 0;

				for (Bank i : banki.getListaBankow()) {
					if (i.getNazwa().equals(answer4)) {

						for (KartaPlatnicza k : i.getKartyKlientow())
							if (k.getNrKonta().equals(answer)) {
								System.out.println("Nr konta zajety");
								break;
							} else if (!k.getNrKonta().equals(answer) && flaga == false) {
								m = banki.getListaBankow().indexOf(i);
								System.out.println("Dodano kartê platnicz¹");
								flaga = true;
							}
					}
				}

				if (flaga == false)
					System.out.println("Coœ posz³o nie tak :C");
				if (flaga == true)
					banki.getListaBankow().get(m)
							.dodajKarteKlienta(new KartaDebetowa(answer, answer1, answer2, answer3));

				break;
			case ("15"):
				System.out.println("Podaj numer konta karty p³atniczej któr¹ chcesz usun¹æ");
				answer = input.nextLine();
				int kp = 0, ba = 0;
				flaga = false;

				for (Bank i : banki.getListaBankow()) {
					for (KartaPlatnicza k : i.getKartyKlientow())
						if (k.getNrKonta().equals(answer)) {
							flaga = true;
							kp = i.getKartyKlientow().indexOf(k);
							ba = banki.getListaBankow().indexOf(i);
						}
				}
				if (flaga = true && banki.getListaBankow().size() != 0) {
					banki.getListaBankow().get(ba).getKartyKlientow().remove(kp);
					System.out.println("Usunieto karte p³atnicz¹");
				} else
					System.out.println("Nie znaleziono karty o podym numerze konta");

			}

		}
	}

}
