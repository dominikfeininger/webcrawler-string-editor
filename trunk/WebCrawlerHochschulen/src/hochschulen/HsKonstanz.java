package hochschulen;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsKonstanz extends HsSalting implements HsSaltingInterface{
	//http://www.htwg-konstanz.de/ProfessorInnen.180.0.html#c3651
	
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

		pathList.add("http://www.htwg-konstanz.de/ProfessorInnen.180.0.html");

		return pathList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		ArrayList<Elements> e = new ArrayList<Elements>();

		//Elements name = doc.select("div.csc-header").select("h2");
		//System.out.println("name: " + name.text());
		//e.add(name);

		//Elements email = doc.select("href[class=mail]");
		Elements email = doc.select("a.mail");
		//System.out.println("email: " + email.text());
		e.add(email);
		
		Elements fak = doc.select("span[class=tx-iwpersonen-pi1-paragraph]");
		//System.out.println("fak: " + fak.text());
		//e.add(fak);
		return e;
	}

}
