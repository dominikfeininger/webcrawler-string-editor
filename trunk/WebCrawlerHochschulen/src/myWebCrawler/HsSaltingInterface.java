package myWebCrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public interface HsSaltingInterface {

	public List<String> startCrawler(CrawlJsoup crawler);
	
	public List<URL> getLinks() throws MalformedURLException;

	public ArrayList<Elements> parseContent(Document doc);
}
