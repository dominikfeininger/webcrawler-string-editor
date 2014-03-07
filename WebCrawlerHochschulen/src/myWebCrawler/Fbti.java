package myWebCrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Fbti extends HsSalting implements HsSaltingInterface {
	
	@Override
	public List<URL> getLinks() throws MalformedURLException {

		List<URL> urlList = new ArrayList<URL>();

		urlList.add(new URL(
				"http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=ad"));
		urlList.add(new URL(
				"http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=eh"));
		urlList.add(new URL(
				"http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=il"));
		urlList.add(new URL(
				"http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=mq"));
		urlList.add(new URL(
				"http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=ru"));
		urlList.add(new URL(
				"http://fbtiform.fh-hannover.de/mitglieder/index.php?cmd=gesamtAnsicht&id=vz"));

		return urlList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		Elements td = doc.select("td.tr_text2").select("h2");
		
		ArrayList<Elements> e = new ArrayList<Elements>();
		e.add(td);

		return e;
	}

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
			domList.addAll(crawler.paresContent(this, i.toString()));
		}
		
		return domList;
	}
}
