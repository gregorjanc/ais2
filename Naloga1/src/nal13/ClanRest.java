package nal13;

import java.io.Serializable;


//@Entity
// @Table(name="clanVao")
public class ClanRest implements Serializable {

	private int id;
	private String ime;
	private String priimek;



	public ClanRest(String ime, String priimek ) {
		this.ime = ime;
		this.priimek = priimek;
	

	}

	public ClanRest() {
		ime = "";
		priimek = "";
//		email = "";
//		spol = "";
//		sifra = "";
//		paket = "";

	}

//	@Transient
//	public String getIzpisiDatum() {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		return format.format(datumVpisaVKlub.getTime());
//	}
//
//	@Transient
//	public String getIzpisiDatumR() {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		return format.format(datumRojstva.getTime());
//	}

	public String toString() {
		return ime + " " + priimek;
	}

//	@Override
//	public void obvestiVse() {
//		for (Trener t : trenerji) {
//			t.obvesti(this.toString());
//		}
//
//	}
//
//	@Override
//	public void dodajPoslusalca(MojPoslusalecVmesnik p) {
//		trenerji.add((Trener) p);
//
//	}
//
//	@Override
//	public void odstraniPoslusalca(MojPoslusalecVmesnik p) {
//		trenerji.remove((Trener) p);
//
//	}

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

//	public String getSpol() {
//		return spol;
//	}
//
//	public void setSpol(String spol) {
//		this.spol = spol;
//	}
//	 @JsonIgnore
//	public Calendar getDatumVpisaVKlub() {
//		return datumVpisaVKlub;
//	}
//
//	public void setDatumVpisaVKlub(Calendar datumVpisaVKlub) {
//		this.datumVpisaVKlub = datumVpisaVKlub;
//	}
//
//	public String getSifra() {
//		return sifra;
//	}
//
//	public void setSifra(String sifra) {
//		this.sifra = sifra;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	 @JsonIgnore
//	public Calendar getDatumRojstva() {
//		return datumRojstva;
//	}
//	 
//	public void setDatumRojstva(Calendar datumRojstva) {
//		this.datumRojstva = datumRojstva;
//	}
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name="claId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@XmlTransient
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER // ,mappedBy="clanId"
//	)
//	@JoinColumn(name = "clanid"
//	// ,referencedColumnName="id"
//	)
//	public List<MeritevVao> getSeznamMeritev() {
//		return seznamMeritev;
//	}
//
//	public void setSeznamMeritev(List<MeritevVao> seznamMeritev) {
//		this.seznamMeritev = seznamMeritev;
//	}
//
//	public String getPaket() {
//		return paket;
//	}
//
//	public void setPaket(String paket) {
//		this.paket = paket;
//	}
//
//	@XmlTransient
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	public Set<Trener> getTrenerji() {
//		return trenerji;
//	}
//
//	public void setTrenerji(Set<Trener> trenerji) {
//		this.trenerji = trenerji;
//	}

}
