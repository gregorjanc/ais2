package nal8.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;
@Local
public interface MeritevEjbVmesnik {
	
	List<MeritevVao> getSeznamMeritev(int id);
	List<MeritevVao> getSeznamMeritevPoVrsti(int id);

	void vpisiMeritev(MeritevVao meritev, int izbranClan);
	MeritevVao dobiZadnjo(int izbranClan);
	
	
}
