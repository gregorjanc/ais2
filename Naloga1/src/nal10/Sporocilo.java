package nal10;

import java.io.Serializable;

public class Sporocilo implements Serializable {

	private String email;
	private String kdo;
	
	public Sporocilo(String email, String kdo) {
		this.email=email;
		this.kdo=kdo;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKdo() {
		return kdo;
	}

	public void setKdo(String kdo) {
		this.kdo = kdo;
	}
	
	
	
	
}
