package logic;
import java.util.List;
import java.util.ArrayList;

public class Banki {

	public List <Bank>listaBankow = new ArrayList<>();
	public Banki(){};
	
	public void dodaj(Bank bank) {
		listaBankow.add(bank);
	}
}
