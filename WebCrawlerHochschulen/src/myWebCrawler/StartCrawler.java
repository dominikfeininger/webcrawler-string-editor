package myWebCrawler;

import editoren.Editor;
import genericInAnOutPut.ReadAndWrite;
import hochschulen.Fbti;
import hochschulen.HsAlbSig;
import hochschulen.HsAugsburg;
import hochschulen.HsHof;
import hochschulen.HsSaltingInterface;

public class StartCrawler {
	
	public static void main(String[] args) {
		
		CrawlJsoup cj = new CrawlJsoup();
		ReadAndWrite printer = new ReadAndWrite();
		Editor editor = new Editor();
		
		//add HS here and start crawler
		
		HsSaltingInterface fbti = new Fbti();
		HsSaltingInterface hsAugsburg = new HsAugsburg();
		HsSaltingInterface hsAlSig = new HsAlbSig();
		HsSaltingInterface hsHof = new HsHof();
		
		//hsAugsburg.startCrawler(cj);
		//fbti.startCrawler(cj);
		
		//cj.writeToFileSeparated(editor.spaceSeperator(list[1]));
		//printer.printConsoleSeparated(editor.spaceSeperator(editor.atSubstiut(hsAlSig.startCrawler(cj))));
		printer.printConsoleSeparated(editor.spaceSeperator(editor.atSubstiut(hsHof.startCrawler(cj))));
	}
}
