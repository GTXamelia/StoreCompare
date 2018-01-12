package ie.StoreCompare.core;

import java.io.IOException;
import java.util.Scanner;
import ie.StoreCompare.store.Cex;

public class Centre {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		CexThread CexThread;
		
		int amount = 0;
		String gameName;
		
		//System.out.println("> Amount to Display: ");
		//amount = reader.nextInt();
		//reader.nextLine();
		
		System.out.println("\n> Game to Search: ");
		gameName = reader.nextLine();
		
		gameName.replace(" ", "+");
		
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