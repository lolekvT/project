package logic;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Banki implements Serializable {

	private static final long serialVersionUID = 1L;
	protected List<Bank> listaBankow = new LinkedList<>();

	public Banki() {
	};

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
