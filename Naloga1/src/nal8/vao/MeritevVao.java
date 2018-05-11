package nal8.vao;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name="meritevVao")
public class MeritevVao implements Serializable, Cloneable {
	
	private ClanVao clanId;
	private int id;
	private Calendar datumMeritve;
	private double telesnaVisina;
	private double obsegPasu;
	private double teza;

	public MeritevVao() {
		datumMeritve = new GregorianCalendar();

	}

	public MeritevVao(Calendar datum, double telesnaVisina, double obsegPasu, double teza) {

		this.datumMeritve = datum;
		this.telesnaVisina = telesnaVisina;
		this.obsegPasu = obsegPasu;
		this.teza = teza;

	}
	@Override
	public Object clone() {
	try {
		return super.clone();
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return null;
}	
	
	@Transient
	public String getDatum() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(datumMeritve.getTime());
	}

	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		return telesnaVisina + " " + obsegPasu + " " + teza + " " + format.format(datumMeritve.getTime());

	}
	 @JsonIgnore
	public Calendar getDatumMeritve() {
		return datumMeritve;
	}

	public void setDatumMeritve(Calendar datumMeritve) {
		this.datumMeritve = datumMeritve;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	public ClanVao getClanId() {
		return clanId;
	}

	public void setClanId(ClanVao clanId) {
		this.clanId = clanId;
	}

}
