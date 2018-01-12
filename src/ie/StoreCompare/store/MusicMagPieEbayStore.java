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
			System.out.println("Title : " + el.getElementsByTag("h3").text()+"\n");
			//System.out.println("Site : " +  el.getElementsByTag("cite").text());
			//System.out.println("Abstract : " + el.getElementsByTag("span").text() + "\n");
		}

	}
}
