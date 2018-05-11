package vaje.vao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaja implements Serializable {
	
	private int id;
	
	private String nazivVaje;
	
	private String sifraVaje;
	
	private String delTelesa;
	
	private String naprava;
	private String opis;
	private String slika;
	private String video;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nazivVaje;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivVaje() {
		return nazivVaje;
	}
	public void setNazivVaje(String nazivVaje) {
		this.nazivVaje = nazivVaje;
	}
	public String getSifraVaje() {
		return sifraVaje;
	}
	public void setSifraVaje(String sifraVaje) {
		this.sifraVaje = sifraVaje;
	}
	public String getDelTelesa() {
		return delTelesa;
	}
	public void setDelTelesa(String delTelesa) {
		this.delTelesa = delTelesa;
	}
	public String getNaprava() {
		return naprava;
	}
	public void setNaprava(String naprava) {
		this.naprava = naprava;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	
	

}
