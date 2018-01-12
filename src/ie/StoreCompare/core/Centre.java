package ie.StoreCompare.core;

import java.io.IOException;
import java.util.Scanner;

import ie.StoreCompare.storage.ConsoleChoice;
import ie.StoreCompare.store.Cex;

public class Centre {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		CexThread CexThread;
		
		int amount = 0;
		String gameName;
		
		System.out.println("> Amount to Display: ");
		amount = reader.nextInt();
		reader.nextLine();
		
		System.out.println("\n> Game to Search: ");
		gameName = reader.nextLine();
		
		gameName.replace(" ", "+");
		
		int consoleID = ConsoleChoice.main();
		
		System.out.println(consoleID);
		
		CexThread = new CexThread(amount, gameName);
		CexThread.start();
		
		reader.close();
	}
}

class CexThread extends Thread {
	int amount;
	String gameName;
	
	CexThread(int a, String g) {
		amount = a;
		gameName = g;
	}
	
	public void run() {

		try {
			Cex.main(amount, gameName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}