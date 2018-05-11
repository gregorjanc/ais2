package nal9;

import java.util.List;

import javax.ejb.Local;
@Local
public interface TrenerVmesnik {

	void dodaj(int id, int izbranTrener);
	List<Trener> vsiTrenerji();
	void dodajTrener(Trener t);

}
