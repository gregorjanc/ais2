package vaje.ejb;

import java.util.List;

import javax.ejb.Local;

import vaje.vao.Vaja;

@Local
public interface VajaVmesnik {
	
	void dodajVajo(Vaja v);
	
	void odstraniVajo(Vaja v);
	
	void urediVajo(Vaja v);
	
	List<Vaja> vseVaje();
	
	Vaja vrniVajo(int id);
	
	
	
	
	
	

}
