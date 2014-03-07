package hochschulen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsAlbSig extends HsSalting implements HsSaltingInterface {

	@Override
	public List<String> startCrawler(CrawlJsoup crawler) {
		
		List<URL> urlList = null;
		List<String> domList = new ArrayList<String>();
		
		try {
			urlList = this.toURLs(this.getLinks());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		for (URL i : urlList) {
			domList.addAll(crawler.paresContent(this, i.toString()));
		}

		return domList;
	}

	@Override
	public List<String> getLinks() throws MalformedURLException {

		List<String> pathList = new ArrayList<String>();

		pathList.add("http://www.hof-university.de/ueber-uns/personen.html?tx_personenverzeichnis_pi1%5Baction%5D=suche&tx_personenverzeichnis_pi1%5Bcontroller%5D=Personenverzeichnis&cHash=a646903d4e735b8cc7f84d37e75b040e#personensuche");

		return pathList;
	}
	

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		ArrayList<Elements> e = new ArrayList<Elements>();

		Elements rn = doc.select(
				"span[class=ms-rteCustom-Zwischenueberschrift]");
		//System.out.println("span: " + doc.select("span[class=ms-rteCustom-Zwischenueberschrift]").text());
		e.add(rn);
		
		
		Elements email = doc.select(
				"span[class=ms-rteCustom-maintext]").select("a");
		//System.out.println("email: " + doc.select("span[class=ms-rteCustom-maintext]").select("a").text());
		e.add(email);
		return e;
	}
}
