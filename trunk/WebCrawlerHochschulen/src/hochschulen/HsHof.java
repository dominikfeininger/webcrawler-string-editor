package hochschulen;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsHof extends HsSalting implements HsSaltingInterface {

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

		pathList.add("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/hsHofQuellcode.html");

		return pathList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		ArrayList<Elements> e = new ArrayList<Elements>();

		Elements name = doc.select("div[class=pers bg]").select("h4");
		// System.out.println("name: " +
		// doc.select("span[class=six mobile-one columns]").select("h4").text());
		//System.out.println("name: " + name.text());
		e.add(name);

		Elements email = doc.select("div[class=pers bg]").select("a");
		// System.out.println("email: " +
		// doc.select("span[class=six mobile-one columns]").select("a").text());
		//System.out.println("email: " + email.text());
		e.add(email);
		return e;
	}

}
