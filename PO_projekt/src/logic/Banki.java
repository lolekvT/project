package logic;
import java.util.List;
import java.util.ArrayList;

public class Banki {

    List <Bank>listaBankow = new ArrayList<>();
	public List<Bank> getListaBankow() {
		return listaBankow;
	}

	public void setListaBankow(List<Bank> listaBankow) {
		this.listaBankow = listaBankow;
	}

	public Banki(){};
	
	public void dodaj(Bank bank) {
		listaBankow.add(bank);
	}
}
