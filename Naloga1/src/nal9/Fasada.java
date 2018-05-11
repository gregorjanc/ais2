package nal9;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nal10.Poslji;
import nal8.vao.ClanVao;
import paketi.Mail;


@Stateless
public class Fasada implements FasadaVmesnik {

	@PersistenceContext
	EntityManager em;

	//private Mail mail = new Mail();
	private Poslji mail=new Poslji();

	@Override
	public void posljiMail(int c) {
		ClanVao temp = em.find(ClanVao.class, c);
		System.out.println(temp);
			for(Trener t : temp.getTrenerji()) {
				try {
					mail.posljiMail(t.getEmail(), "Oseba " + temp + " je vnesla svoje meritve.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		
	}
	
	public void poslijEmail(String e, String kdo) {
		try {
			mail.posljiMail(e, "Oseba " + kdo + " je vnesla svoje meritve.");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void posljiMail(String prejemnik,String sporocilo) {
		
		try {
			mail.posljiMail(prejemnik, sporocilo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
