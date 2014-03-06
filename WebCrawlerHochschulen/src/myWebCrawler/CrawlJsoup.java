package myWebCrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlJsoup implements CrawlerInterface {

	public List<String> paresContent(HsSaltingInterface tmpHS, URL url) {

		Document doc = null;
		List<String> tmpList = new ArrayList<String>();

		try {
			//TODO:
			//doc = Jsoup.parse(url, 99999);
			doc = Jsoup.parse(new File(
					"/Users/dominikfeininger/Downloads/hsHofQuellcode.html"),
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(doc.toString());

		for (Elements e : tmpHS.parseContent(doc)) {
			for (Element i : e) {
				tmpList.add(i.text().toString());
			}
		}
		return tmpList;
	}

}
