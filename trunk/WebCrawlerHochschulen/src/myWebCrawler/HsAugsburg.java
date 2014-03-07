package myWebCrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsAugsburg extends HsSalting implements HsSaltingInterface {

	public List<URL> getLinks() throws MalformedURLException {

		List<URL> urlList = new ArrayList<URL>();

		urlList.add(new URL(
				"http://www.hs-augsburg.de/fakultaet/informatik/person/professor/index.html"));
		

		return urlList;
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
			urlList = this.getLinks();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		for (URL i : urlList) {
			domList.addAll(crawler.paresContent(this, i.toString()));
		}

		return domList;
	}

}
