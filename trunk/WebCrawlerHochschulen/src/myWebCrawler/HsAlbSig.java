package myWebCrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HsAlbSig implements HsSaltingInterface {

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

		urlList.add(new URL(
				"http://www.hs-albsig.de/studium/wirtschaftsinformatik/seiten/professoren.aspx"));

		return urlList;
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
