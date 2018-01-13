package ie.StoreCompare.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ie.StoreCompare.storage.Items;

public class MusicMagPieEbayStore {

	public static void main(String gameName) throws IOException {
		
		List<Items> itemList = new ArrayList<Items>();
		
		String name = null;
		double price = 0;
		double postage = 0;
		
		String url = "http://www.ebay.ie/sch/i.html?LH_BIN=1&_nkw=" + gameName + "&_ssn=musicmagpie";
		Document doc = Jsoup.connect(url).userAgent("Mozilla").timeout(60000).get();
		
		System.out.println("Sending request..." + "\"" + url + "\"");
		
		Elements els  = doc.select("li.sresult.lvresult");
		
		for(Element el : els)
		{
			name = (el.getElementsByTag("h3").text()).replaceAll("VideoGames", "");
			price =  Double.parseDouble((el.getElementsByClass("lvprice prc").text()).replaceAll("[^0-9.]", ""));
			postage =  Double.parseDouble((el.getElementsByClass("fee").text()).replaceAll("[^0-9.]", ""));
			
		}
		itemList.add(new Items(name, (price + postage)));
	}
}
