package ie.StoreCompare.store;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Cex {

	public static void main(int amount, String gameName) throws IOException {
		
		String url = "https://ie.webuy.com/search/index.php?stext="+gameName+"&num="+amount;
		Document doc = Jsoup.connect(url).followRedirects(false).userAgent("Mozilla").timeout(60000).get();
		
		System.out.println("Sending request..." + "\"" + url + "\"");
		
		Elements els  = doc.select("div.searchRecord");
		
		for(Element el : els)
		{
			if(el.getElementsByTag("h3").text() != " "){
				System.out.println("Game : " + el.getElementsByTag("h1").text());
				System.out.println("Console : " +  el.getElementsByTag("p").text());
				System.out.println("Link : https://ie.webuy.com" + el.getElementsByTag("a").attr("href"));
				System.out.println("Buy : " + el.select("div.priceTxt").get(1).text());
				System.out.println("Sell : " + el.select("div.priceTxt").get(2).text() + "\n");
			}
		}
	}
}
