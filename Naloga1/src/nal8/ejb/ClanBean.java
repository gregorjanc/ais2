package nal8.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;
import nal9.Trener;
import paketi.PaketLetni;
import paketi.PaketMesecni;
import paketi.PaketObicajen;
import paketi.PaketVmesnik;

@Stateless
public class ClanBean implements ClanEjbVmesnik {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<ClanVao> vsiClani() {
		return em.createQuery("select c from ClanVao c").getResultList();
	}

	@Override
	public void vpisiClana(ClanVao c) {
		dodajPaket(c);
		em.persist(c);

	}

	@Override
	public void izbrisiClana(ClanVao c) {

//		ClanVao temp = em.find(ClanVao.class, c.getId());
//
//		for (Trener t : temp.getTrenerji()) {
//			for (ClanVao d : t.getSeznamClanov()) {
//				if (c.getId() == d.getId()) {
//					t.getSeznamClanov().remove(d);
//					break;
//
//				}
//
//			}
//
//		}
//		temp.getTrenerji().clear();
//
//		em.remove(temp);

	}

	@Override
	public boolean izbrisiClana(int id) {
//		ClanVao temp = em.find(ClanVao.class, id);
//
//		if (temp == null) {
//			return false;
//		}
//		for (Trener t : temp.getTrenerji()) {
//			for (ClanVao d : t.getSeznamClanov()) {
//				if (id == d.getId()) {
//					t.getSeznamClanov().remove(d);
//					break;
//
//				}
//
//			}
//
//		}
//		temp.getTrenerji().clear();
//
//		em.remove(temp);
		return true;

	}

	@Override
	public ClanVao izberiClana(ClanVao c) {
		ClanVao cv = em.find(ClanVao.class, c.getId());
		return cv;

	}

	@Override
	public ClanVao izberiClana(int c) {
		ClanVao cv = em.find(ClanVao.class, c);
		return cv;

	}

	private void dodajPaket(ClanVao c) {
		PaketVmesnik paket = null;
		if (c.getPaket() == null)
			return;
		if (c.getPaket().equals("letni")) {
			paket = new PaketLetni(c.getEmail());

		}
		if (c.getPaket().equals("obicajen")) {
			paket = new PaketObicajen();

		}
		if (c.getPaket().equals("mesecni")) {

			paket = new PaketMesecni(c.getEmail());

		}
		if (paket != null)
			paket.posljiMail();

	}

	@Override
	public ClanVao dodajMeritev(ClanVao c, MeritevVao m) {
		ClanVao temp = em.find(ClanVao.class, c.getId());
		temp.getSeznamMeritev().add(m);
		return temp;

	}

	@Override
	public void spremeniClana(ClanVao c) {
		// ClanVao cv = em.find(ClanVao.class, c.getId());
		em.merge(c);

	}

}
