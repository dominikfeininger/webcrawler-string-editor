package genericInAnOutPut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
			
		List<String> list = new ArrayList<String>();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/"+filename+".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
			    list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	
	public void writeToFileSeparated(List<String[]> spaceSeperator, String filename) {
		PrintWriter writer = null;
		//TODO: add parameter url
		try {
			writer = new PrintWriter("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/"+filename+".txt", "UTF-8");

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
	
	public void writeToFile(List<String> domList, String filename) {
		PrintWriter writer = null;

		try {
			writer = new PrintWriter("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/"+filename+".txt", "UTF-8");

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
