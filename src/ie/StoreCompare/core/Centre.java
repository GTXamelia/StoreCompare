package ie.StoreCompare.core;

import java.io.IOException;
import java.util.Scanner;

public class Centre {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		CexThread FileThread;
		
		int amount = 0;
		String gameName;
		
		System.out.println("> Amount to Display: ");
		amount = reader.nextInt();
		reader.nextLine();
		
		System.out.println("> Game to Search: ");
		gameName = reader.nextLine();
		reader.nextLine();
		
		

	}

}

class CexThread extends Thread {
	String file;
	int shingleCount;
	
	CexThread(String f, int s) {
		file = f;
		shingleCount = s;
	}
	
	public void run() {

		//TODO stuff here
	}
}