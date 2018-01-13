package ie.StoreCompare.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.StoreCompare.storage.Items;

public class Cex {
	
	public static void main(String gameName) throws IOException {
		
		List<Items> itemList = new ArrayList<Items>();
		
		String url = "https://ie.webuy.com/search/index.php?stext="+gameName;
		Document doc = Jsoup.connect(url).followRedirects(false).userAgent("Mozilla").timeout(60000).get();
		
		System.out.println("\nSending request..." + "\"" + url + "\"\n");
		
		Elements els  = doc.select("div.searchRecord");
		
		for(Element el : els)
		{
			if(el.getElementsByTag("h3").text() != " "){
				
				/*
				String itemType = el.getElementsByTag("p").text();
				String itemTypeRem = itemType.substring(itemType.indexOf("/")+1, itemType.length());  
				System.out.println("Game :     " + el.getElementsByTag("h1").text());
				System.out.println("Console : " +  itemTypeRem);
				System.out.println("Link :     https://ie.webuy.com" + el.getElementsByTag("a").attr("href"));
				System.out.println("Buy :      " + el.select("div.priceTxt").get(0).text());
				System.out.println("Sell :     " + el.select("div.priceTxt").get(1).text() + " " + el.select("div.priceTxt").get(2).text() + "\n");
				
				System.out.println("Game :     " + el.getElementsByTag("h1").text());
				System.out.println("Buy :      " + el.select("div.priceTxt").get(0).text());
				*/
				
				String name = el.getElementsByTag("h1").text();
				double price = Double.parseDouble(el.select("div.priceTxt").get(0).text().replaceAll("[^0-9.]", ""));
				
				//System.out.println(name + "\n" + price + "\n");
				
				itemList.add(new Items(name, price));
			}
		}
		DisplayList(itemList);
	}
	
	public static void DisplayList(List<Items> itemList) throws IOException {
		
		System.out.println(itemList);
	}
	
}
