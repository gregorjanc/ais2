package nal8.vao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nal9.MojPoslusalecVmesnik;
import nal9.PoslusaniVmesnik;
import nal9.Trener;
import paketi.PaketLetni;
import paketi.PaketMesecni;
import paketi.PaketObicajen;
import paketi.PaketVmesnik;

@Entity
// @Table(name="clanVao")
public class ClanVao implements Serializable, Cloneable, PoslusaniVmesnik {

	private int id;
	private String ime;
	private String priimek;
	private String spol;
	private Calendar datumRojstva = new GregorianCalendar();
	private Calendar datumVpisaVKlub = new GregorianCalendar();
	private String sifra;
	private String email;

	private String paket;

	private Set<Trener> trenerji = new HashSet<>();
	private List<MeritevVao> seznamMeritev = new ArrayList<>();

	public ClanVao(String ime, String priimek, String spol, Calendar datumRojstva, Calendar datumVpisaVKlub,
			String sifra, String email, int id) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.datumVpisaVKlub = datumVpisaVKlub;
		this.sifra = sifra;
		this.email = email;
		this.datumRojstva = datumRojstva;
		this.id = id;

	}

	public ClanVao(String ime, String priimek, String spol, Calendar datumRojstva, Calendar datumVpisaVKlub,
			String sifra, String email, String paket) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.datumVpisaVKlub = datumVpisaVKlub;
		this.sifra = sifra;
		this.email = email;
		this.datumRojstva = datumRojstva;
		this.paket = paket;
	}

	public ClanVao() {
		ime = "";
		priimek = "";
		email = "";
		spol = "";
		sifra = "";
		paket = "";

	}

	@Transient
	public String getIzpisiDatum() {
		if (datumVpisaVKlub == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(datumVpisaVKlub.getTime());
	}

	@Transient
	public String getIzpisiDatumR() {
		if (datumRojstva == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(datumRojstva.getTime());
	}

	public String toString() {
		return ime + " " + priimek;
	}

	@Override
	public void obvestiVse() {
		for (Trener t : trenerji) {
			t.obvesti(this.toString());
		}

	}

	@Override
	public void dodajPoslusalca(MojPoslusalecVmesnik p) {
		trenerji.add((Trener) p);

	}

	@Override
	public void odstraniPoslusalca(MojPoslusalecVmesnik p) {
		trenerji.remove((Trener) p);

	}

	// getterji/setterji
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

	@JsonIgnore
	public Calendar getDatumVpisaVKlub() {
		return datumVpisaVKlub;
	}

	public void setDatumVpisaVKlub(Calendar datumVpisaVKlub) {
		this.datumVpisaVKlub = datumVpisaVKlub;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public Calendar getDatumRojstva() {
		return datumRojstva;
	}

	public void setDatumRojstva(Calendar datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name="claId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlTransient
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER // ,mappedBy="clanId"
	)
	@JoinColumn(name = "clanid"
	// ,referencedColumnName="id"
	)
	public List<MeritevVao> getSeznamMeritev() {
		return seznamMeritev;
	}

	public void setSeznamMeritev(List<MeritevVao> seznamMeritev) {
		this.seznamMeritev = seznamMeritev;
	}

	public String getPaket() {
		return paket;
	}

	public void setPaket(String paket) {
		this.paket = paket;
	}

	@XmlTransient
	// @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Trener> getTrenerji() {
		return trenerji;
	}

	public void setTrenerji(Set<Trener> trenerji) {
		this.trenerji = trenerji;
	}

}
