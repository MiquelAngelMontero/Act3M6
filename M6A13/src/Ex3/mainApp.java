package Ex3;

import java.io.IOException;

public class mainApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Empleat[] e = new Empleat[5];
		
		e[0] = new Empleat(1, 1200, "Burgos");
		e[1] = new Empleat(2, 1800, "Montero");
		e[2] = new Empleat(3, 2000, "Garcia");
		e[3] = new Empleat(4, 800, "Martinez");
		e[4] = new Empleat(5, 650, "Hernandez");
		
		Ex3 e3 = new Ex3("src/Ex3/execució/binari.txt", e);
		
	}

}
