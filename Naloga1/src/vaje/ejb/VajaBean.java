package vaje.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import vaje.vao.Vaja;

@Stateless
public class VajaBean implements VajaVmesnik {

	@PersistenceContext
	EntityManager em;

	@Override
	public void dodajVajo(Vaja v) {

//		if (em.contains(v)) {
//			em.merge(v);
//			return;
//		}
//		
		Vaja temp = em.find(Vaja.class, v.getId());
		if (temp != null) {
			temp.setNaprava(v.getNaprava());
			temp.setDelTelesa(v.getDelTelesa()); 
			temp.setNazivVaje(v.getNazivVaje());
			temp.setSifraVaje(v.getSifraVaje());
			temp.setVideo(v.getVideo());
			temp.setSlika(v.getSlika());
			temp.setOpis(v.getOpis());
	
		}
		else
		em.persist(v);
			

	}

	@Override
	public void odstraniVajo(Vaja v) {
		em.remove(em.find(Vaja.class, v.getId()));
		// em.remove(em.contains(v) ? v : em.merge(v));
	}

	@Override
	public void urediVajo(Vaja v) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vaja> vseVaje() {

		return em.createQuery("select v from Vaja v").getResultList();
	}

	@Override
	public Vaja vrniVajo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
