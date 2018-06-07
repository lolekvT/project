package logic;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Banki implements Serializable{

   protected List <Bank>listaBankow = new LinkedList<>();
   

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
	public void usun(Bank bank) {
		listaBankow.remove(bank);
	}
}
