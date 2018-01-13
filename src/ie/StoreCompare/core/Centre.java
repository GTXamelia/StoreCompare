package ie.StoreCompare.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ie.StoreCompare.storage.Items;
import ie.StoreCompare.store.Cex;
import ie.StoreCompare.store.MusicMagPieEbayStore;

public class Centre {

	public static void main(String[] args) throws InterruptedException {
		
		// Threads
		CexThread CexThread;
		MusicMagPieThread MusicMagPieThread;
		
		// User Input
		Scanner reader = new Scanner(System.in);
		
		// Items Object list array
		List<Items> itemList = new ArrayList<Items>();
		
		// Variables
		String gameName = null;
		int menu = -1;
		
		while(menu != 0){
			
			// Menu Prompt
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
					MusicMagPieThread = new MusicMagPieThread(gameName, itemList);
					MusicMagPieThread.start();
					menu = 0;
					MusicMagPieThread.join();
				}
				else if(menu == 2){
					CexThread = new CexThread(gameName, itemList);
					CexThread.start();
					menu = 0;
					CexThread.join();
				}
				else if(menu == 3){
					MusicMagPieThread = new MusicMagPieThread(gameName, itemList);
					CexThread = new CexThread(gameName, itemList);
					MusicMagPieThread.start();
					CexThread.start();
					menu = 0;
					MusicMagPieThread.join();
					CexThread.join();
				}
			}else if(menu == 0){
				System.out.println("Goodbye!");
			}
			else{
				System.out.println("\nPlease select a valid option");
			}
		}
		
		System.out.println(itemList);
		
		reader.close();
	}
}

class CexThread extends Thread {
 	String gameName;
 	List<Items> itemList;
	
	CexThread(String g, List<Items> i) {
		gameName = g;
		itemList = i;
	}
	
	public void run() {

		try {
			Cex.main(gameName, itemList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MusicMagPieThread extends Thread {
 	String gameName;
	
 	MusicMagPieThread(String g, List<Items> itemList) {
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