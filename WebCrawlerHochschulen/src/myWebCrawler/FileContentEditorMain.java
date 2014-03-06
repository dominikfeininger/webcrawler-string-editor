package myWebCrawler;

import java.util.ArrayList;
import java.util.List;

public class FileContentEditorMain {

	public static void main(String[] args) {
		Editor editor = new Editor();
		ReadAndWrite rw = new ReadAndWrite();
		
		//separate
		//rw.writeToFileSeparated((editor.spaceSeperator(rw.readFileFromDisk("/Users/dominikfeininger/Downloads/namen.txt"))));
		//rw.printConsoleSeparated((editor.spaceSeperator(rw.readFileFromDisk("/Users/dominikfeininger/Downloads/namen.txt"))));
		
		//replace (at) -> @
		//rw.writeToFile(editor.atSubstiut(rw.readFileFromDisk("/Users/dominikfeininger/Downloads/emails.txt")));
		
		//replace (@) -> @
		//rw.writeToFile(editor.atSubstiut2(rw.readFileFromDisk("/Users/dominikfeininger/Downloads/emails.txt")));
		
		//remove empty lines
		//rw.writeToFile(editor.removelines(rw.readFileFromDisk("/Users/dominikfeininger/Downloads/emails.txt")));
		rw.writeToFile(editor.removelines(rw.readFileFromDisk("/Users/dominikfeininger/Downloads/namen.txt")));
		
		//remove ,
		//rw.printConsoleSeparated((editor.removeComma(rw.readFileFromDisk("/Users/dominikfeininger/Downloads/namen.txt"))));
	}
}
