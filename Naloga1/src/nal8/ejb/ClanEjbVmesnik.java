package nal8.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;

@Local
public interface ClanEjbVmesnik {
	
	
	void vpisiClana(ClanVao c);
	List<ClanVao> vsiClani();
	void izbrisiClana(ClanVao c);
	ClanVao izberiClana(int c);
	ClanVao izberiClana(ClanVao c);
	void dodajMeritev(ClanVao izbranClan);
	ClanVao dodajMeritev(ClanVao c, MeritevVao m);
	void spremeniClana(ClanVao c);
	boolean izbrisiClana(int id);
 

}
