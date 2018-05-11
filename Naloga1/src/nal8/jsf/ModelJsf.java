package nal8.jsf;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import nal8.ejb.ClanEjbVmesnik;

import nal8.vao.ClanVao;
import nal8.vao.MeritevVao;
import nal9.Trener;
import nal9.TrenerEJB;
import nal9.TrenerVmesnik;

@ManagedBean(name = "modelNew")
@SessionScoped

public class ModelJsf {

	@EJB
	ClanEjbVmesnik ejb;

	@EJB
	TrenerVmesnik ejbTrener;

	// za izbiro
	private ClanVao izbranClan = new ClanVao();
	private MeritevVao novaMeritev = new MeritevVao();
	private int izbranTrener = 0;

	// za na strani
	private ClanVao clan = new ClanVao();
	private MeritevVao meritev = new MeritevVao();
	private Trener trener = new Trener();
	
	
	private String izbranPaket;

	public String izberiClanaZaPodrobnosti(ClanVao c) {

		this.izbranClan = ejb.izberiClana(c);
		return "podrobnostiNew.xhtml";
	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/vajeNew.xhtml?faces-redirect=true";
    }

	public List<ClanVao> getVsiClani() {

		return ejb.vsiClani();
	}

	public void dodajTrener(ClanVao c) {

		ejbTrener.dodaj(c.getId(), izbranTrener);

	}

	public void dodajTrenerja() {
		ejbTrener.dodajTrener(trener);
		trener=new Trener();
	}

	public void izbrisiClana(ClanVao c) {
		ejb.izbrisiClana(c);

	}

	public void dodajClana() {

		ejb.vpisiClana(clan);

		izbranPaket = null;
		clan = new ClanVao();
	}

	public void dodajMeritev() {

		// izbranClan.getSeznamMeritev().add(novaMeritev);
		izbranClan = ejb.dodajMeritev(izbranClan, novaMeritev);

		novaMeritev = new MeritevVao();

	}

	public List<Trener> getVsiTrenerji() {
		return ejbTrener.vsiTrenerji();
	}

	public List<MeritevVao> getSeznamMeritev() {
		return izbranClan.getSeznamMeritev();

	}

	public String getIzbranPaket() {
		return izbranPaket;
	}

	public void setIzbranPaket(String paket) {
		this.izbranPaket = paket;
	}

	public ClanVao getIzbranClan() {
		return izbranClan;
	}

	public void setIzbranClan(ClanVao izbranClan) {
		this.izbranClan = izbranClan;
	}

	public MeritevVao getNovaMeritev() {
		return novaMeritev;
	}

	public void setNovaMeritev(MeritevVao novaMeritev) {
		this.novaMeritev = novaMeritev;
	}

	public ClanVao getClan() {
		return clan;
	}

	public void setClan(ClanVao clan) {
		this.clan = clan;
	}

	public MeritevVao getMeritev() {
		return meritev;
	}

	public void setMeritev(MeritevVao meritev) {
		this.meritev = meritev;
	}

	public int getIzbranTrener() {
		return izbranTrener;
	}

	public void setIzbranTrener(int izbranTrener) {
		this.izbranTrener = izbranTrener;
	}

	public Trener getTrener() {
		return trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

}
