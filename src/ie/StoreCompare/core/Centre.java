package ie.StoreCompare.core;

import java.io.IOException;
import java.util.Scanner;
import ie.StoreCompare.store.Cex;
import ie.StoreCompare.store.MusicMagPieEbayStore;

public class Centre {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		CexThread CexThread;
		
		String gameName;
		
		//System.out.println("> Amount to Display: ");
		//amount = reader.nextInt();
		//reader.nextLine();
		
		System.out.println("> Game to Search: ");
		gameName = reader.nextLine();
		
		gameName = gameName.replaceAll(" ", "+");
		
		CexThread = new CexThread(gameName);
		CexThread.start();
		
		reader.close();
	}
}

class CexThread extends Thread {
 	String gameName;
	
	CexThread(String g) {
		gameName = g;
	}
	
	public void run() {

		try {
			Cex.main(gameName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}