package ie.StoreCompare.store;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Cex {

	public static void main(String gameName) throws IOException {
		
		String url = "https://ie.webuy.com/search/index.php?stext="+gameName;
		Document doc = Jsoup.connect(url).followRedirects(false).userAgent("Mozilla").timeout(60000).get();
		
		System.out.println("\nSending request..." + "\"" + url + "\"\n");
		
		Elements els  = doc.select("div.searchRecord");
		
		for(Element el : els)
		{
			if(el.getElementsByTag("h3").text() != " "){
				
				String itemType = el.getElementsByTag("p").text();
				String itemTypeRem = itemType.substring(itemType.indexOf("/")+1, itemType.length());  
				
				System.out.println("Game :     " + el.getElementsByTag("h1").text());
				System.out.println("Console : " +  itemTypeRem);
				System.out.println("Link :     https://ie.webuy.com" + el.getElementsByTag("a").attr("href"));
				System.out.println("Buy :      " + el.select("div.priceTxt").get(1).text());
				System.out.println("Sell :     " + el.select("div.priceTxt").get(2).text() + "\n");
			}
		}
	}
}
