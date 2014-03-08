package hochschulen;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsNiederreihn extends HsSalting implements HsSaltingInterface{

	@Override
	public List<String> startCrawler(CrawlJsoup crawler) {

		List<String> urlList = null;
		List<String> domList = new ArrayList<String>();

		try {
			urlList = this.getLinks();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		for (String i : urlList) {
			domList.addAll(crawler.paresContent(this, i));
		}

		return domList;
	}

	@Override
	public List<String> getLinks() throws MalformedURLException {

		List<String> pathList = new ArrayList<String>();

		pathList.add("http://www.hs-niederrhein.de/elektrotechnik-informatik/personen/");

		return pathList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		ArrayList<Elements> e = new ArrayList<Elements>();

		Elements name = doc.select("a[class=tx-iwpersonen-pi1-detaillink]");
		//System.out.println("name: " + name.text());
		//e.add(name);

		Elements email = doc.select("a[class=font-size-11]");
		//System.out.println("email: " + email.text());
		e.add(email);
		
		Elements fak = doc.select("span[class=tx-iwpersonen-pi1-paragraph]");
		//System.out.println("fak: " + fak.text());
		//e.add(fak);
		return e;
	}
	
	
}
