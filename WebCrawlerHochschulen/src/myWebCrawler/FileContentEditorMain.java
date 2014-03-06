package myWebCrawler;

import java.util.ArrayList;
import java.util.List;

public class FileContentEditorMain {

	public static void main(String[] args) {
		Editor editor = new Editor();
		ReadAndWrite rw = new ReadAndWrite();
		
		rw.writeToFileSeparated((editor.spaceSeperator(rw.readFileFromDisk(""))));

	}

}
