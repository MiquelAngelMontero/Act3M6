package Ex3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ex3 {
	private File binari;
	private RandomAccessFile binariAl;
	private Empleat[] empleats;
	
	public Ex3(String path, Empleat[] empleats) throws IOException {
		this.binari = new File(path);
		this.binariAl = new RandomAccessFile(binari, "rw");
		this.empleats = empleats;
		crearFitxer();
		omplirFitxer();
		execucio();
	}
	
	public boolean crearFitxer() throws IOException {
		if (this.binari.createNewFile()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void omplirFitxer() throws IOException {
		StringBuffer buffer = null;
		for (int i=0; i<empleats.length; i++) {
			this.binariAl.writeInt(empleats[i].getId());
			this.binariAl.writeFloat(empleats[i].getSalari());
			buffer = new StringBuffer(empleats[i].getCognom());
			buffer.setLength(10);
			this.binariAl.writeChars(buffer.toString());
		}
	}
	
	public Empleat[] llegirFitxer() throws IOException {
		int posicion = 0;
		Empleat[] empleatLlegit = new Empleat[this.empleats.length];
		int id, cont = 0;
		float salari;
		char cognom[] = new char[10], aux;
		String cognomS;
		
		for(;;) {
			this.binariAl.seek(posicion);
			id=this.binariAl.readInt();
			salari=this.binariAl.readFloat();
			for(int i=0;i<cognom.length; i++) {
				aux = this.binariAl.readChar();
				cognom[i]=aux;
			}
			cognomS = new String (cognom);
			
			empleatLlegit[cont] = new Empleat(id, salari, cognomS);
			
			posicion=posicion+28;
			cont++;
			if (this.binariAl.getFilePointer()==this.binariAl.length())break;
		}
		this.binariAl.close();
		return empleatLlegit;
	}
	
	public boolean execucio() throws IOException {
		Empleat[] empleatsLlegits = llegirFitxer();
		String idEscS, importEscS;
		int idEsc = 0;
		float importEsc = 0;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Indica l'identificador de l'empleat.");
			idEscS = sc.nextLine();
			idEsc = Integer.parseInt(idEscS);
		} catch (NumberFormatException nfe) {
			System.out.println("L'identificador no s'ha escrit en el format correcte");
		}
		
		try {
			System.out.println("Indica l'import");
			importEscS = sc.nextLine();
			importEsc = Float.parseFloat(importEscS);
		} catch (NumberFormatException nfe) {
			System.out.println("L'import no s'ha escrit en el format correcte");
		}
		
		for(int i=0; i<empleatsLlegits.length; i++) {
			if(empleatsLlegits[i].getId()==idEsc) {
				System.out.println("S'ha troblat l'empleat!");
				System.out.println("El seu cognom és: " + empleatsLlegits[i].getCognom());
				System.out.println("El seu antic salari: " + empleatsLlegits[i].getSalari());
				empleatsLlegits[i].sumarSalari(importEsc);
				System.out.println("El seu nou salari és: " + empleatsLlegits[i].getSalari());
				return true;
			}
		}
		System.out.println("No s'ha trobat l'empleat amb la id indicada");
		return false;
	}
}
