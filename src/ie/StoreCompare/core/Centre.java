package ie.StoreCompare.core;

import java.io.IOException;
import java.util.Scanner;
import ie.StoreCompare.store.Cex;
import ie.StoreCompare.store.MusicMagPieEbayStore;

public class Centre {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		CexThread CexThread;
		MusicMagPieThread MusicMagPieThread;
		
		String gameName = null;
		int menu = -1;
		
		while(menu != 0){
			
			System.out.println("=========== Menu ===========");
			System.out.println(") 1. Search MusicMagPie");
			System.out.println(") 2. Search Cex");
			System.out.println(") 3. Search MusicMagPie/Cex");
			System.out.println(") 0. Exit");
			menu = reader.nextInt();
			reader.nextLine();
			
			if(menu >= 1 && menu <= 3){
				System.out.println("> Game to Search: ");
				gameName = reader.nextLine();
				gameName = gameName.replaceAll(" ", "+");
				
				if(menu == 1){
					MusicMagPieThread = new MusicMagPieThread(gameName);
					MusicMagPieThread.start();
					menu = 0;
				}
				else if(menu == 2){
					CexThread = new CexThread(gameName);
					CexThread.start();
					menu = 0;
				}
				else if(menu == 3){
					MusicMagPieThread = new MusicMagPieThread(gameName);
					CexThread = new CexThread(gameName);
					MusicMagPieThread.start();
					CexThread.start();
					menu = 0;
				}
			}else if(menu == 0){
				System.out.println("Goodbye!");
			}
			else{
				System.out.println("\nPlease select a valid option");
			}
			
			
		}
		
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

class MusicMagPieThread extends Thread {
 	String gameName;
	
 	MusicMagPieThread(String g) {
		gameName = g;
	}
	
	public void run() {

		try {
			MusicMagPieEbayStore.main(gameName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}