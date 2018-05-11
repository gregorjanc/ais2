import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import paketi.PaketVmesnik;

public class Clan {
	
	
	private int id;
	private String ime;
	private String priimek;
	private String spol;
	private Calendar datumRojstva;
	private Calendar datumVpisaVKlub;
	private String sifra;
	private String email;
	private PaketVmesnik paket;
	
	private String izpisiDatumR;
	private String izpisiDatum;
	
	public Clan(String ime, String priimek, String spol,Calendar datumRojstva, Calendar datumVpisaVKlub, String sifra,String email,int id) {
		this.ime=ime;
		this.priimek=priimek;
		this.spol= spol;
		this.datumVpisaVKlub= datumVpisaVKlub;
		this.sifra= sifra;
		this.email=email;
		this.datumRojstva=datumRojstva;
		this.id=id;
		izpisiDatum();
	}
	public Clan(String ime, String priimek, String spol,Calendar datumRojstva, Calendar datumVpisaVKlub, String sifra,String email, PaketVmesnik paket) {
		this.ime=ime;
		this.priimek=priimek;
		this.spol= spol;
		this.datumVpisaVKlub= datumVpisaVKlub;
		this.sifra= sifra;
		this.email=email;
		this.datumRojstva=datumRojstva;
		this.paket=paket;
		izpisiDatum();
	}
	
	public Clan() {
		
	}
	public void izpisiDatum() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		izpisiDatumR= format.format(datumRojstva.getTime());
		izpisiDatum= format.format(datumVpisaVKlub.getTime());
	}
	public String toString() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		return ime + " " + priimek;
	}

	
	
	
	
	
	
	
	
	//getterji/setterji
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

	public String getIzpisiDatum() {
		return izpisiDatum;
	}

	public void setIzpisiDatum(String izpisiDatum) {
		this.izpisiDatum = izpisiDatum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIzpisiDatumR() {
		return izpisiDatumR;
	}

	public void setIzpisiDatumR(String izpisiDatumR) {
		this.izpisiDatumR = izpisiDatumR;
	}

	public Calendar getDatumRojstva() {
		return datumRojstva;
	}

	public void setDatumRojstva(Calendar datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public PaketVmesnik getPaket() {
		return paket;
	}
	public void setPaket(PaketVmesnik paket) {
		this.paket = paket;
	}

	
	
}
