package hochschulen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import myWebCrawler.CrawlJsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public interface HsSaltingInterface {

	public List<String> startCrawler(CrawlJsoup crawler);
	
	public List<String> getLinks() throws MalformedURLException;

	public ArrayList<Elements> parseContent(Document doc);
	
	public List<URL> toURLs(List<String> links);
}
