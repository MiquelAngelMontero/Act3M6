package Ex3;

public class Empleat {
	private int id;
	private float salari;
	private String cognom;
	
	public Empleat(int id, float salari, String cognom) {
		this.id = id;
		this.salari = salari;
		this.cognom = cognom;
	}

	public void sumarSalari(float suma) {
		this.setSalari(this.salari+suma);
	}
	
	public float getSalari() {
		return salari;
	}

	public void setSalari(float salari) {
		this.salari = salari;
	}

	public int getId() {
		return id;
	}

	public String getCognom() {
		return cognom;
	}
}
