package myWebCrawler;

import hochschulen.HsSaltingInterface;

import java.net.URL;
import java.util.List;

public interface CrawlerInterface {

	List<String> paresContent(HsSaltingInterface tmpHS, String path);

}
