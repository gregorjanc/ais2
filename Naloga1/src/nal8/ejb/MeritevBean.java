package nal8.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;
import nal9.Trener;

@Stateless
public class MeritevBean implements MeritevEjbVmesnik {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<MeritevVao> getSeznamMeritev(int id) {

		return em.find(ClanVao.class, id).getSeznamMeritev();
	}

	@Override
	public List<MeritevVao> getSeznamMeritevPoVrsti(int id) {

		Query q = em.createQuery("select m from MeritevVao m order by m.datumMeritve asc");
//		 q.setParameter(":id", id);
//		 List<MeritevVao> temp = new ArrayList<>();
//		 for(MeritevVao m: (List<MeritevVao>) q.getResultList() ) {
//			 
//			 if(m.getClanId().getId()==id)
//			 temp.add(m);
//			 
//		 }
		
			 
		 return q.getResultList();
		//	 return temp;
	}

	@Override
	public void vpisiMeritev(MeritevVao meritev, int izbranClan) {
		ClanVao temp = em.find(ClanVao.class, izbranClan);
		temp.getSeznamMeritev().add(new MeritevVao(meritev.getDatumMeritve(), meritev.getTelesnaVisina(),
				meritev.getObsegPasu(), meritev.getTeza()));
		temp.obvestiVse();
//		for (Trener t : temp.getTrenerji()) {
//			t.obvesti(temp.toString());
//		}
		

	}

	@Override
	public MeritevVao dobiZadnjo(int izbranClan) {
		ClanVao temp = em.find(ClanVao.class, izbranClan);
		if (temp.getSeznamMeritev().size() == 0) {
			return new MeritevVao();
		}

		MeritevVao m =temp.getSeznamMeritev().get(temp.getSeznamMeritev().size() - 1);
		
		return (MeritevVao) m.clone();
	}

}
