package hochschulen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Fbti extends HsSalting implements HsSaltingInterface {
	
	@Override
	public List<String> getLinks() throws MalformedURLException {

		List<String> pathList = new ArrayList<String>();

		pathList.add("http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=ad");

		pathList.add("http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=eh");

		pathList.add("http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=il");

		return pathList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		Elements td = doc.select("td.tr_text2").select("h2");
		
		ArrayList<Elements> e = new ArrayList<Elements>();
		e.add(td);

		return e;
	}
	
	@Override
	public List<URL> toURLs(List<String> links) {
		
		List<URL> urlList = new ArrayList<URL>();
		
		//TODO:
		
		return urlList;
	}

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
}
