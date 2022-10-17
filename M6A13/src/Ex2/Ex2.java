package Ex2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class Ex2 {

	private Departament[] arDep;
	private File departament;
	
	public Ex2(Departament[] arDep, String path) throws IOException, ClassNotFoundException {
		this.arDep = arDep;
		this.departament = new File(path, "Departaments.dat");
		crearFixeros();
	}
	
	public void crearFixeros() throws IOException, ClassNotFoundException {
		
		if (!departament.exists()) {
			try {
				 if (departament.createNewFile())
				   System.out.println("Fitxer Departaments creat");
				 else
				   System.out.println("No s'ha pogut crear el fitxer");
			} catch (IOException ioe) {
				   ioe.printStackTrace();
			}
			
			añadirBinario();
			llenarFicheroFinal();
		} else {
			System.out.println("El fitxer ja existeix, elimina'l per continuar");
		}
	}
	
	public void añadirBinario() throws IOException {
		
		byte[] bytes = null;
		int len;
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream (bs);
		
		for(int i=0; i<arDep.length; i++) {
			os.writeObject(arDep[i]);  // this es de tipo DatoUdp
			os.close();
			bytes =  bs.toByteArray(); // devuelve byte[]
		}
		
		OutputStream out = new FileOutputStream(this.departament);
		
			out.write(bytes);
		
		out.close();
	}

	public void llenarFicheroFinal() throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream(departament);
		ObjectInputStream out = new ObjectInputStream(in);
		
		Departament d;
		
		try {
			System.out.println("Departaments");
			while (true) {
				d = (Departament) out.readObject();
				System.out.println("\n");
				System.out.println("Numero departament: " + d.getNumDepartament() + "\nNom: " + d.getNom() + "\nLocalitat: " + d.getLocalitat());
			}
		}catch (EOFException eo) {}
		out.close();

	}
}
