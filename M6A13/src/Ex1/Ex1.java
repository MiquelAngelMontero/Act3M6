package Ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Ex1 {

	private File fichero;

	public Ex1(String path) throws FileNotFoundException, IOException {
		this.fichero = new File(path);
		imprimir();
	}
	
	public void imprimir() throws FileNotFoundException, IOException {
		String cadena; 
		FileReader f = new FileReader(fichero); 
		BufferedReader b = new BufferedReader(f); 
		while((cadena = b.readLine())!=null) { 
			System.out.println(cadena); 
		} 
		b.close(); 
	}
}
