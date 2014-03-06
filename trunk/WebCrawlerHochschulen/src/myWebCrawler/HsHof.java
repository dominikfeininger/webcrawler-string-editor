package myWebCrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsHof implements HsSaltingInterface{

	@Override
	public List<String> startCrawler(CrawlJsoup crawler) {
		
		List<URL> urlList = null;
		List<String> domList = new ArrayList<String>();
		
		try {
			urlList = this.getLinks();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		for (URL i : urlList) {
			domList.addAll(crawler.paresContent(this, i));
		}

		return domList;
	}

	@Override
	public List<URL> getLinks() throws MalformedURLException {

		List<URL> urlList = new ArrayList<URL>();

		//urlList.add(new URL(
				//"http://www.hof-university.de/ueber-uns/personen.html?tx_personenverzeichnis_pi1%5Baction%5D=suche&tx_personenverzeichnis_pi1%5Bcontroller%5D=Personenverzeichnis&cHash=a646903d4e735b8cc7f84d37e75b040e#personensuche"));

		return urlList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		ArrayList<Elements> e = new ArrayList<Elements>();

		Elements name = doc.select(
				"span[class=six mobile-one columns]").select("h4");
		System.out.println("name: " + doc.select("span[class=six mobile-one columns]").select("h4").text());
		System.out.println("name: " + name.text());
		e.add(name);
		
		Elements email = doc.select(
				"span[class=six mobile-one columns]").select("a");
		System.out.println("email: " + doc.select("span[class=six mobile-one columns]").select("a").text());
		System.out.println("name: " + name.text());
		e.add(email);
		return e;
	}

}
