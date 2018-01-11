package ie.StoreCompare.core;

import java.io.IOException;
import java.util.Scanner;

import ie.gmit.sw.main.FileThread;

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
		
		CexThread = new CexThread(amount, gameName);
		CexThread.start();
		
		reader.close();
	}
}

class CexThread extends Thread {
	int amount;
	String gameName;
	
	CexThread(int a, String g) {
		file = f;
		shingleCount = s;
	}
	
	public void run() {

		//TODO stuff here
	}
}