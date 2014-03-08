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
	
	public List<String> substututeCrap(List<String> domList){
		List<String> tmp = new ArrayList<String>();
		Iterator<String> iterator = domList.iterator();
		while (iterator.hasNext()) {
			tmp.add(iterator.next().replace(" ", " "));	
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

	public List<String[]> removeCommaAndSeparate(List<String> domList) {
		
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
	
	public List<String> removeComma(List<String> domList) {
		
		List<String> list2 = new ArrayList<String>();
		Iterator<String> iterator = domList.iterator();
		String str = null;
		while (iterator.hasNext()) {
			str = iterator.next();
			str = str.replace(",","");
			list2.add(str);
			
			//System.out.println(splited[2]);
		}
		
		return list2;
	}
	
	public List<String> addDomain(List<String> domList, String domain){
		List<String> list = new ArrayList<String>();
		
		Iterator<String> iter = domList.iterator();
		
		while(iter.hasNext()){
			list.add(iter.next()+domain);
		}
		
		return list;
	}

	public List<String[]> spaceSeperatorAdvanced(List<String> domlist) {
		
		List<String[]> list2 = new ArrayList<String[]>();
		Iterator<String> iterator = domlist.iterator();
		String str = null;
		String[] splited = null;
		while (iterator.hasNext()) {
			str = iterator.next();
			//remove space in titel
			str = str.replace("Prof. Dr. med. Dipl.-Ing.", "Prof.Dr.med.Dipl.-Ing.");
			str = str.replace("Prof. Dr. rer. nat.","Prof.Dr.rer.nat.");
			str = str.replace("Prof. Dr. sc. hum.", "Prof.Dr.sc.hum.");
			str = str.replace("Prof. Dr. math.", "Prof.Dr.math.");
			str = str.replace("Prof. Dr. med.", "Prof.Dr.med.");
			str = str.replace("Prof. D", "Prof.D");
			//split
			splited = str.split("\\s+");
			list2.add(splited);
			
			//System.out.println(splited[2]);
		}
		
		return list2;
	}
	
	public List<String> removeQuestionmarks(List<String> domList){
		List<String> tmp = new ArrayList<String>();
		Iterator<String> iterator = domList.iterator();
		String str = null;
		while (iterator.hasNext()) {
			str = iterator.next();
			//System.out.println(str);
			str = str.replace("?", "");
			//System.out.println(str);
			tmp.add(str);	
		}
		
		return tmp;
	}
	
	public List<String> makeLinksPlain(List<String> domList){
		List<String> tmp = new ArrayList<String>();
		Iterator<String> iterator = domList.iterator();
		String str = null;
		int index;
		while (iterator.hasNext()) {
			str = iterator.next();
			//System.out.println(str);
			str = str.replace("<a href=", "http://www.fh-stralsund.de");//.html">
			//str = str.replace("",".html\">");
			index = str.indexOf(".html\">");
			str = str.substring(0, index);
			//System.out.println(str);
			tmp.add(str);	
		}
		
		return tmp;
	}

	public List<String[]> arrowSeperator(List<String> readFileFromDisk) {
		
		List<String[]> list2 = new ArrayList<String[]>();
		Iterator<String> iterator = readFileFromDisk.iterator();
		String str = null;
		String[] splited = null;
		
		while (iterator.hasNext()) {
			str = iterator.next();
			//remove space in titel
			str = str.replace("Prof. Dr. med. Dipl.-Ing.", "Prof.Dr.med.Dipl.-Ing.");
			str = str.replace("Prof. Dr. rer. nat.","Prof.Dr.rer.nat.");
			str = str.replace("Prof. Dr. sc. hum.", "Prof.Dr.sc.hum.");
			str = str.replace("Prof. Dr. math.", "Prof.Dr.math.");
			str = str.replace("Prof. Dr. med.", "Prof.Dr.med.");
			str = str.replace("Prof. D", "Prof.D");
			//split
			splited = str.split(">>");
			int i = 0;
			for (String string : splited) {
				splited[i] = string.trim();
				System.out.println(splited[i]);
			}
			list2.add(splited);
			
			//System.out.println(splited[2]);
		}
		
		return list2;
	}
}
