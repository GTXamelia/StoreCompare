package ie.StoreCompare.store;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.StoreCompare.storage.Items;

public class Cex {
	
	public static void main(String gameName, List<Items> itemList) throws IOException {
		
		String name;
		String gameType;
		double price;
		double postage = 1.50;
		
		String url = "https://ie.webuy.com/search/index.php?stext="+gameName;
		System.out.println("\nSending request..." + "\"" + url + "\"\n");
		Document doc = Jsoup.connect(url).followRedirects(false).userAgent("Mozilla").timeout(60000).get();
		
		Elements els  = doc.select("div.searchRecord");
		
		for(Element el : els)
		{
			name = (el.getElementsByTag("h1").text()).replaceAll("\\(.*?\\) ?", "");
			price =  Double.parseDouble((el.select("div.priceTxt").get(0).text()).replaceAll("[^0-9.]", ""));
			gameType = ((el.getElementsByTag("p").text().substring(el.getElementsByTag("p").text().indexOf("/")+1, el.getElementsByTag("p").text().length())).replaceAll("Games", "")).replaceAll(" ", "");  
			
			itemList.add(new Items((name + "(" + gameType + ")"), (price + postage)));
		}
	}
}