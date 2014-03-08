package hochschulen;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HsStrahlsund extends HsSalting implements HsSaltingInterface {

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

			pathList.add("http://www.fh-stralsund.de/fh_stralsund/powerslave,id,75,nodeid,.html");
		} else {
			pathList = this.links;
		}
		return pathList;
	}

	@Override
	public ArrayList<Elements> parseContent(Document doc) {

		ArrayList<Elements> e = new ArrayList<Elements>();

		//System.out.println(doc);
		
		Elements name = doc.select("a");
		// System.out.println("name: " + name.text());

		Elements links = doc.select("a");
				//.select("body > table > tbody > tr:nth-child(297) > td.webkit-line-content > span:nth-child(2) > a");

		for (Element element : links) {
			if(element.text().contains("@")){
				e.add(links);
				System.out.println(element.text());
			}
		}


		Elements email = doc.select("a[class=font-size-11]");
		// System.out.println("email: " + email.text());
		// e.add(email);

		Elements fak = doc.select("span[class=tx-iwpersonen-pi1-paragraph]");
		// System.out.println("fak: " + fak.text());
		// e.add(fak);
		return e;
	}
}
