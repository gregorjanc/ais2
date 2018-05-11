package nal9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nal8.vao.ClanVao;

@Stateless
public class TrenerEJB implements TrenerVmesnik {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Trener> vsiTrenerji() {
		return em.createQuery("select t from Trener t").getResultList();
	}

	@Override
	public void dodaj(int id, int izbranTrener) {
		

		Trener t=em.find(Trener.class, izbranTrener);
		ClanVao c = em.find(ClanVao.class, id);
		//c.getTrenerji().add(t);
		c.dodajPoslusalca(t);
//		t.getSeznamClanov().add(c);
		
		
	}
	@Override
	public void dodajTrener(Trener t) {
		em.persist(t);
		
		
	}
	
}
