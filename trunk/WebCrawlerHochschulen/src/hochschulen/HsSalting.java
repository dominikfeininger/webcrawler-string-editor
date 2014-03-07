package hochschulen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HsSalting {

	
	public List<URL> toURLs(List<String> links) {
		
		List<URL> urlList = new ArrayList<URL>();
		
		Iterator<String> iterator = links.iterator();

		while (iterator.hasNext()) {
			try {
				urlList.add(new URL(iterator.next()));
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
			//System.out.println();
		}
		
		return urlList;
	}
	
}
