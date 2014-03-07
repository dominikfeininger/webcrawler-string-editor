package hochschulen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsAugsburg extends HsSalting implements HsSaltingInterface {

	public List<String> getLinks() throws MalformedURLException {

		List<String> pathList = new ArrayList<String>();

		pathList.add("http://www.hof-university.de/ueber-uns/personen.html?tx_personenverzeichnis_pi1%5Baction%5D=suche&tx_personenverzeichnis_pi1%5Bcontroller%5D=Personenverzeichnis&cHash=a646903d4e735b8cc7f84d37e75b040e#personensuche");

		return pathList;
	}

	public ArrayList<Elements> parseContent(Document doc) {

		//System.out.println("doc: " + doc.select("div[class=rightside normal]"));
		
		ArrayList<Elements> e = new ArrayList<Elements>();
		
		Elements rn = doc.select("div[class=rightside normal]").select("a");
		//e.add(rn);
		Elements ln = doc.select("div[class=leftside normal]").select("a");
		e.add(ln);
		Elements rh = doc.select("div[class=rightside highlighted]").select("a");
		//e.add(rh);
		Elements lh = doc.select("div[class=leftside highlighted]").select("a");
		e.add(lh);
		
		return e;
	}

	
	public List<String> startCrawler(CrawlJsoup crawler){
		
		List<String> domList = new ArrayList<String>();
		List<URL> urlList = null;
		
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

}
