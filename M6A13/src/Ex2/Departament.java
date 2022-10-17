package Ex2;

import java.io.Serializable;

public class Departament implements Serializable {

	private int numDepartament;
	private String nom;
	private String localitat;
	
	public Departament(int numDepartament, String nom, String localitat) {
		this.numDepartament = numDepartament;
		this.nom = nom;
		this.localitat = localitat;
	}

	public int getNumDepartament() {
		return numDepartament;
	}

	public String getNom() {
		return nom;
	}

	public String getLocalitat() {
		return localitat;
	}
}
