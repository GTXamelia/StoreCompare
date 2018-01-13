package ie.StoreCompare.store;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MusicMagPieEbayStore {

	public static void main(String gameName) throws IOException {
		
		String url = "http://www.ebay.ie/sch/i.html?LH_BIN=1&_nkw=" + gameName + "&_ssn=musicmagpie";
		Document doc = Jsoup.connect(url).userAgent("Mozilla").timeout(60000).get();
		
		System.out.println("Sending request..." + "\"" + url + "\"");
		
		Elements els  = doc.select("li.sresult.lvresult");
		
		//System.out.println(els);
		
		for(Element el : els)
		{
			System.out.println("Title : " + el.getElementsByTag("h3").text());
			
			int k = el.getElementsByTag("span").text().indexOf("+", el.getElementsByTag("span").text().indexOf("+") + 1);
			String res = el.getElementsByTag("span").text().substring(0,k);
			
			System.out.println("Price : " +  ((res).replaceAll("EUR ", "€")).replaceAll("   ", " ")+"\n");
			//System.out.println("Abstract : " + el.getElementsByTag("span").text() + "\n");
		}

	}
}
