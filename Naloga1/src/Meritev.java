import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Meritev {
	private Calendar datumMeritve;
	private double telesnaVisina;
	private double obsegPasu;
	private double teza;

	public Meritev(Calendar datum, double telesnaVisina, double obsegPasu, double teza) {
			
		this.datumMeritve = datum;
		this.telesnaVisina = telesnaVisina;
		this.obsegPasu = obsegPasu;
		this.teza = teza;

	}
		public String getDatum() {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.format(datumMeritve.getTime());
		}
	
	
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		return telesnaVisina + " " + obsegPasu + " " + teza + " " + format.format(datumMeritve.getTime());

	}

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

}
