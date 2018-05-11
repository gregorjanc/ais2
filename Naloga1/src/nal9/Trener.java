package nal9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.ws.rs.ext.ParamConverter.Lazy;
import javax.xml.bind.annotation.XmlTransient;

import nal8.vao.ClanVao;

@Entity
public class Trener implements MojPoslusalecVmesnik {
	private int id;
	private String ime;
	private String priimek;
	private String email;
	private ClanVao clanVaoId;

	public Trener() {
		this("", "", "");
	}

	public Trener(String ime, String priimek, String email) {
		this.ime = ime;
		this.priimek = priimek;
		this.email = email;

	}

	@Override
	public void obvesti(String kdo) {
		Fasada fasada = new Fasada();
		fasada.poslijEmail(this.email, kdo);

	}

	public String toString() {

		return ime + " " + priimek;
	}
	// private Set<ClanVao> seznamClanov = new HashSet<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	// @XmlTransient
	// @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	// public Set<ClanVao> getSeznamClanov() {
	// return seznamClanov;
	// }

	// public void setSeznamClanov(Set<ClanVao> seznamClanov) {
	// this.seznamClanov = seznamClanov;
	// }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public ClanVao getClanVaoId() {
		return clanVaoId;
	}

	public void setClanVaoId(ClanVao clanVaoId) {
		this.clanVaoId = clanVaoId;
	}

}
