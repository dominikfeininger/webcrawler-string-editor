package myWebCrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class HsSalting {

	public abstract List<URL> getLinks() throws MalformedURLException;

	public abstract ArrayList<Elements> parseContent(Document doc);

}
