package nal13;

import java.io.Serializable;

public class MeritevRest implements Serializable {

	private double telesnaVisina;
	private double obsegPasu;
	private double teza;
	private int id;
	
	public MeritevRest(double telesnaVisina, double obsegPasu, double teza) {

		this.telesnaVisina = telesnaVisina;
		this.obsegPasu = obsegPasu;
		this.teza = teza;

	}

	public MeritevRest() {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
