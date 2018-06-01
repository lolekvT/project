package logic;
import java.util.List;
import java.util.ArrayList;

public class Banki {

   protected List <Bank>listaBankow = new ArrayList<>();
   

   public Banki(){};
   
	public List<Bank> getListaBankow() {
		return listaBankow;
	}

	public void setListaBankow(List<Bank> listaBankow) {
		this.listaBankow = listaBankow;
	}

	
	public void dodaj(Bank bank) {
		listaBankow.add(bank);
	}
}
