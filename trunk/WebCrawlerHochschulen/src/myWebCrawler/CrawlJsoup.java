package myWebCrawler;

import hochschulen.HsSaltingInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlJsoup implements CrawlerInterface {

	public List<String> paresContent(HsSaltingInterface tmpHS, String path) {

		Document doc = null;
		List<String> tmpList = new ArrayList<String>();
		
		boolean urlTrue = true;
		
		URL url = null;
		try {
			url = new URL(path);
		} catch (MalformedURLException e1) {
			urlTrue = false;
			e1.printStackTrace();
		}

		try {
			if(urlTrue)
				doc = Jsoup.parse(url, 99999);
			else{
				doc = Jsoup.parse(new File(path), "UTF-8");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(doc.toString());

		for (Elements e : tmpHS.parseContent(doc)) {
			for (Element i : e) {
				tmpList.add(i.toString());//.text());
			}
		}
		return tmpList;
	}

}
