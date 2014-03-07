package editoren;

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
		List<String> tmp = new ArrayList<String>();
		Iterator<String> iterator = domList.iterator();
		while (iterator.hasNext()) {
			tmp.add(iterator.next().replace("(at)", "@"));	
		}
		
		return tmp;
	}
	
	public List<String> atSubstiut2(List<String> domList){
		List<String> tmp = new ArrayList<String>();
		Iterator<String> iterator = domList.iterator();
		while (iterator.hasNext()) {
			tmp.add(iterator.next().replace("(@)", "@"));	
		}
		
		return tmp;
	}

	public List<String> removelines(List<String> domList) {
		List<String> tmp = new ArrayList<String>();
		Iterator<String> iterator = domList.iterator();
		int i = 0;
		String str = null;
		while (iterator.hasNext()) {
			if(i%2==0){
				str=iterator.next();
				tmp.add(str);	
				System.out.println(str);
			}else{
				iterator.next();
			}
			i++;
		}
		
		return tmp;
	}

	public List<String[]> removeComma(List<String> domList) {
		
		List<String[]> list2 = new ArrayList<String[]>();
		Iterator<String> iterator = domList.iterator();
		String str = null;
		String[] splited = null;
		while (iterator.hasNext()) {
			str = iterator.next();
			str = str.replace(",","");
			splited = str.split("\\s+");
			list2.add(splited);
			
			//System.out.println(splited[2]);
		}
		
		return list2;
	}
	
	public List<String> addDomain(List<String> domList){
		List<String> list = new ArrayList<String>();
		
		Iterator<String> iter = domList.iterator();
		
		while(iter.hasNext()){
			list.add(iter.next()+"@hof-university.de");
		}
		
		return list;
	}

}
