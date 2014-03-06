package myWebCrawler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAndWrite {
	
	public void printConsole(List<String> domList) {
		Iterator<String> iterator = domList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public List<String> readFileFromDisk(String filename){
		//TODO:
		List<String> list = new ArrayList<String>(); 
		return list;
	}
	
	public void printConsoleSeparated(List<String[]> spaceSeperator) {

		Iterator<String[]> iterator = spaceSeperator.iterator();

		while (iterator.hasNext()) {
			String[] str = iterator.next();
			for (int i = 0; str.length > i; i++) {
				System.out.print(str[i] + "\t");
			}
			System.out.println();
		}
	}
	
	public void writeToFileSeparated(List<String[]> spaceSeperator) {
		PrintWriter writer = null;

		try {
			writer = new PrintWriter("tmpHochschulen.txt", "UTF-8");
			

			Iterator<String[]> iterator = spaceSeperator.iterator();

			while (iterator.hasNext()) {
				String[] str = iterator.next();

				for (int i = 0; str.length > i; i++) {
					// System.out.println(iterator.next()[i]);
					writer.print(str[i] + "\t");
				}
				System.out.println();
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}
	
	public void writeToFile(List<String> domList) {
		PrintWriter writer = null;

		try {
			writer = new PrintWriter("tmpHochschulen.txt", "UTF-8");

			Iterator<String> iterator = domList.iterator();
			while (iterator.hasNext()) {
				writer.println(iterator.next());
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}
