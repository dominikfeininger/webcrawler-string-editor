package hochschulen;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HsStuttgart extends HsSalting implements HsSaltingInterface{

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
		if (this.links == null) {

			pathList.add("http://www.hft-stuttgart.de/Hochschule/Organisation/Professoren/FakC/index.html/de");
		} else {
			pathList = this.links;
		}
		return pathList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		ArrayList<Elements> e = new ArrayList<Elements>();

		Elements links = doc.select("a");
		//.select("body > table > tbody > tr:nth-child(297) > td.webkit-line-content > span:nth-child(2) > a");

		for (Element element : links) {
			if(element.text().contains("@")){
				//e.add(links);
				//System.out.println(element.text());
			}
		}
		Elements prof = doc.select("div[id=Proftab]").select("a");
		//System.out.println("prof: " + prof.text());
		//e.add(prof);
		
		String str = null;
		int index = 0;
		for (Element element : prof) {
			str = element.toString().substring(9);
			str = "http://www.hft-stuttgart.de"+str;
			
			index = str.indexOf("> ");
			str = str.substring(0, index-1);
			
			//System.out.println(str);
			//e.add(prof);
		}
		
		Elements email = doc.select("#Tabelle > table > tbody > tr:nth-child(3) > td:nth-child(2) > a");
		//System.out.println(email.text());
		//.select("body > table > tbody > tr:nth-child(297) > td.webkit-line-content > span:nth-child(2) > a");
		//e.add(email);
		Elements fak = doc.select("#Tabelle > table > tbody > tr:nth-child(7) > td:nth-child(2)");
		System.out.println(fak.text());
		e.add(fak);

		//Elements email = doc.select("a[class=font-size-11]");

		return e;
	}
}
