package vaje.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vaje.ejb.VajaVmesnik;
import vaje.vao.Vaja;


@ManagedBean(name="vaja")
@SessionScoped
public class VajaJSF {

	@EJB
	VajaVmesnik vajaVmesnik;
	
	private Vaja vajaTrenuten= new Vaja();
	private Vaja vajaPodrobnosti = new Vaja();
	private String naslovVnosa="Dodaj vajo";
	
	private List<Vaja> sezanmVseh = null;
	
	@PostConstruct
	public void pridobiVse() {
		sezanmVseh = vajaVmesnik.vseVaje();

	}
	
	
	public void uredi(Vaja v) {
		naslovVnosa="Uredi vajo";
		
		vajaTrenuten=v;
		
		
	}
	public String podrobnosti(Vaja v) {
		vajaPodrobnosti=v;
		return "podrobnostiVaja.xhtml";
		
	}
	
	public void izbrisi(Vaja v) {
		vajaVmesnik.odstraniVajo(v);
		pridobiVse();
		
		
	}
	
	public void dodajVajo() {
		
		vajaVmesnik.dodajVajo(vajaTrenuten);
		vajaTrenuten= new Vaja();
		pridobiVse();
		naslovVnosa="Dodaj vajo";
		
	}
	
	
	public String getUrlzavideo() {
		//https://www.youtube.com/embed/HcEc8zeNYxI?rel=0
		//https://www.youtube.com/watch?v=HcEc8zeNYxI
		String nekaj = vajaPodrobnosti.getVideo().substring(32);
		
		String temp = "https://www.youtube.com/embed/"+ nekaj + "?rel=0";
		
		return temp;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public VajaVmesnik getVajaVmesnik() {
		return vajaVmesnik;
	}

	public void setVajaVmesnik(VajaVmesnik vajaVmesnik) {
		this.vajaVmesnik = vajaVmesnik;
	}

	public Vaja getVajaTrenuten() {
		return vajaTrenuten;
	}

	public void setVajaTrenuten(Vaja vajaTrenuten) {
		this.vajaTrenuten = vajaTrenuten;
	}

	public List<Vaja> getSezanmVseh() {
		return sezanmVseh;
	}

	public void setSezanmVseh(List<Vaja> sezanmVseh) {
		this.sezanmVseh = sezanmVseh;
	}


	public Vaja getVajaPodrobnosti() {
		return vajaPodrobnosti;
	}


	public void setVajaPodrobnosti(Vaja vajaPodrobnosti) {
		this.vajaPodrobnosti = vajaPodrobnosti;
	}


	public String getNaslovVnosa() {
		return naslovVnosa;
	}


	public void setNaslovVnosa(String naslovVnosa) {
		this.naslovVnosa = naslovVnosa;
	}
	
	
	
	
	
	
}
