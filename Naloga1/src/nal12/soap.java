package nal12;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import nal8.ejb.ClanEjbVmesnik;
import nal8.ejb.MeritevBean;
import nal8.ejb.MeritevEjbVmesnik;
import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;
import nal9.TrenerVmesnik;

@WebService
public class soap {

	@EJB
	ClanEjbVmesnik ejb;
	@EJB
	MeritevEjbVmesnik ejbm;

	public List<ClanVao> vsiClani() {

		return ejb.vsiClani();
	}

	public void vpisiClana(ClanVao c) {
		ejb.vpisiClana(c);
		
	}
	public void vpisiMeritev(MeritevVao m, int izbranClan) {
		ejbm.vpisiMeritev(m, izbranClan);
		
	}

}
