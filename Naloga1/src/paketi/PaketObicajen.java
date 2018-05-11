package paketi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class PaketObicajen implements PaketVmesnik, Serializable {
	
	@Override
	public void posljiMail() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "obicajen";
	}

	


}
