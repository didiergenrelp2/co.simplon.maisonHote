package co.simplon.maisonHote;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws Exception {

		Jdbc db = new Jdbc();
		ArrayList<Reservation> listeReserv;

		db.connectToDB();

		//db.insertData("nom2", "prenom2", "0123456789","email2@email.com","2","1","Loisir","Non","Non","Oui");
		//db.showData();
		listeReserv = db.showData();
		for (int i=0; i< listeReserv.size();i++)
		System.out.println(listeReserv.get(i).getNom());
		db.closeDB();
	}

}
