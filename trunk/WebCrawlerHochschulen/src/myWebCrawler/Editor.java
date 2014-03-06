package myWebCrawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Editor {
	
	public List<String[]> spaceSeperator(List<String> domList){
		
		List<String[]> list2 = new ArrayList<String[]>();
		Iterator<String> iterator = domList.iterator();
		String str = null;
		String[] splited = null;
		while (iterator.hasNext()) {
			str = iterator.next();
			splited = str.split("\\s+");
			list2.add(splited);
			
			//System.out.println(splited[2]);
		}
		
		return list2;
	}
	
	public List<String> atSubstiut(List<String> domList){
		
		Iterator<String> iterator = domList.iterator();
		while (iterator.hasNext()) {
			domList.add(iterator.next().replace("(at)", "@"));	
			iterator.remove();
		}
		
		return domList;
	}

}
