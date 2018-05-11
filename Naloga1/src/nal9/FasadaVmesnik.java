package nal9;

import javax.ejb.Local;

@Local
public interface FasadaVmesnik {

	void posljiMail(int c);
	
	void poslijEmail(String e, String kdo); 
	void posljiMail(String prejemnik,String sporocilo);

}