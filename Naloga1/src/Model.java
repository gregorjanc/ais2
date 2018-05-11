import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import paketi.PaketLetni;
import paketi.PaketMesecni;
import paketi.PaketObicajen;
import paketi.PaketVmesnik;
import zrno.MojeZrno;
import zrno.MojeZrnoLocal;

@ManagedBean(name = "model")
@SessionScoped

public class Model {

	// za izbiro
	private Clan izbranClan = new Clan();

	// za na strani
	private String ime;
	private String priimek;
	private String spol;
	private String email;
	private String sifra;
	private String izbranPaket;
	private PaketVmesnik paket;

	private double telesnaVisina;
	private double obsegPasu;
	private double teza;

	// private ArrayList<Clan> seznamClanov = new ArrayList<>();
	private Calendar datumRojstva = new GregorianCalendar();
	private Calendar datumMeritve = new GregorianCalendar();

	private ClanBaza clanBaza = ClanBaza.getInstance();

	public String izberiClanaZaPodrobnosti(Clan c) {
		this.izbranClan = c;
		return "podrobnosti.xhtml";
	}

	public void izbrisiClana(Clan c) {
		clanBaza.izbrisiClana(c.getId());

	}

	public void dodajClana() {

		if (izbranPaket.equals("letni")) {
			paket = new PaketLetni(email); 

		}
		if (izbranPaket.equals("obicajen")) {
			paket = new PaketObicajen();

		}
		if (izbranPaket.equals("mesecni")) {

			paket = new PaketMesecni(email);
		}

		Calendar datumVpisaVKlub = Calendar.getInstance();
		clanBaza.vpisiClana(new Clan(ime, priimek, spol, datumRojstva, datumVpisaVKlub, sifra, email, paket));

		email = "";
		spol = "";
		ime = "";
		priimek = "";
		sifra = "";
		izbranPaket = null;
		paket=null;

	}

	public void dodajMeritev() {
		clanBaza.vpisiMeritev(datumMeritve, teza, obsegPasu, telesnaVisina, izbranClan.getId());
		datumMeritve = new GregorianCalendar();
		teza = 0.0;
		obsegPasu = 0.0;
		telesnaVisina = 0;

	}

	public ArrayList<Meritev> getSeznamMeritev() {
		return clanBaza.getSeznamMeritev(izbranClan.getId());

	}

	public Clan getIzbranClan() {
		return izbranClan;
	}

	public void setIzbranClan(Clan izbranClan) {
		this.izbranClan = izbranClan;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getSpol() {
		return spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public double getTelesnaVisina() {
		return telesnaVisina;
	}

	public void setTelesnaVisina(double telesnaVisina) {
		this.telesnaVisina = telesnaVisina;
	}

	public double getObsegPasu() {
		return obsegPasu;
	}

	public void setObsegPasu(double obsegPasu) {
		this.obsegPasu = obsegPasu;
	}

	public double getTeza() {
		return teza;
	}

	public void setTeza(double teza) {
		this.teza = teza;
	}

	// public ArrayList<Clan> getSeznamClanov() {
	// return seznamClanov;
	// }
	//
	// public void setSeznamClanov(ArrayList<Clan> seznamClanov) {
	// this.seznamClanov = seznamClanov;
	// }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClanBaza getClanBaza() {
		return clanBaza;
	}

	public void setClanBaza(ClanBaza clanBaza) {
		this.clanBaza = clanBaza;
	}

	public Calendar getDatumRojstva() {
		return datumRojstva;
	}

	public void setDatumRojstva(Calendar datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	public Calendar getDatumMeritve() {
		return datumMeritve;
	}

	public void setDatumMeritve(Calendar datumPrveMeritve) {
		this.datumMeritve = datumPrveMeritve;
	}

	public String getIzbranPaket() {
		return izbranPaket;
	}

	public void setIzbranPaket(String paket) {
		this.izbranPaket = paket;
	}

}
