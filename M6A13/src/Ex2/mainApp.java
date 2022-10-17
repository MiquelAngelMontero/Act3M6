package Ex2;

import java.io.IOException;

public class mainApp {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Departament[] arrDep = new Departament[5];
		
		arrDep[0] = new Departament(1, "Matemàtiques", "Valls");
		arrDep[1] = new Departament(2, "Català", "Montblanc");
		arrDep[2] = new Departament(3, "Informàtica", "Reus");
		arrDep[3] = new Departament(4, "Socials", "Tarragona");
		arrDep[4] = new Departament(5, "Química", "Barcelona");
		
		Ex2 e2 = new Ex2(arrDep, "src/Ex2/execucio");
	}

}
