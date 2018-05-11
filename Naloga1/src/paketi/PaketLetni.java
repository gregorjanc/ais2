package paketi;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import nal9.Fasada;
import nal9.FasadaVmesnik;

public class PaketLetni implements PaketVmesnik, Serializable {

	private String datumZacetka = "";
	private String datumKonca = "";

	public PaketLetni(String prejemnik) {
		this.prejemnik = prejemnik;

	}

	private String prejemnik;

	@Override
	public void posljiMail() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Calendar zdaj = Calendar.getInstance();
		System.out.println(zdaj);
		datumZacetka = format.format(zdaj.getTime());

		zdaj.add(Calendar.YEAR, 1);
		datumKonca = format.format(zdaj.getTime());

		String sporocilo = "Pozdravljeni!\n\n" + "Zacetek trajanja paketa: " + datumZacetka
				+ ",\nkonec trajanja paketa: " + datumKonca + "."
				+ "\nPoleg letnega dostopa do fitnesa, lahko tudi neomejeno dostopate do skupinskih vadb.";

		FasadaVmesnik mail = new Fasada();
		mail.posljiMail(prejemnik, sporocilo);

	}

	@Override
	public String toString() {
		return "letni";
	}


	public String getDatumZacetka() {
		return datumZacetka;
	}

	public void setDatumZacetka(String datumZacetka) {
		this.datumZacetka = datumZacetka;
	}

	public String getDatumKonca() {
		return datumKonca;
	}

	public void setDatumKonca(String datumKonca) {
		this.datumKonca = datumKonca;
	}

	public String getPrejemnik() {
		return prejemnik;
	}

	public void setPrejemnik(String prejemnik) {
		this.prejemnik = prejemnik;
	}


}
