package myWebCrawler;

import editoren.Editor;
import genericInAnOutPut.ReadAndWrite;
import hochschulen.Fbti;
import hochschulen.HsAlbSig;
import hochschulen.HsAugsburg;
import hochschulen.HsHof;
import hochschulen.HsNiederreihn;
import hochschulen.HsSaltingInterface;
import hochschulen.HsStrahlsund;
import hochschulen.HsStuttgart;

public class StartCrawler {
	
	public static void main(String[] args) {
		
		CrawlJsoup cj = new CrawlJsoup();
		ReadAndWrite printer = new ReadAndWrite();
		Editor editor = new Editor();
		ReadAndWrite rw = new ReadAndWrite();
		
		//add HS here and start crawler
		
		HsSaltingInterface fbti = new Fbti();
		HsSaltingInterface hsAugsburg = new HsAugsburg();
		HsSaltingInterface hsAlSig = new HsAlbSig();
		HsSaltingInterface hsHof = new HsHof();
		HsSaltingInterface hsNieder = new HsNiederreihn();
		HsSaltingInterface hsStrahlsund = new HsStrahlsund();
		HsSaltingInterface hsStuttgart = new HsStuttgart();
		
		//hsAugsburg.startCrawler(cj);
		//fbti.startCrawler(cj);
		
		//cj.writeToFileSeparated(editor.spaceSeperator(list[1]));
		//printer.printConsoleSeparated(editor.spaceSeperator(editor.atSubstiut(hsAlSig.startCrawler(cj))));
		//printer.printConsoleSeparated(editor.spaceSeperator(editor.atSubstiut(hsHof.startCrawler(cj))));
		//printer.printConsoleSeparated(editor.spaceSeperator(editor.atSubstiut(hsNieder.startCrawler(cj))));
		
		//hsStrahlsund.setLinks(rw.readFileFromDisk("links"));
		//printer.printConsole(hsStrahlsund.startCrawler(cj));
		
		hsStuttgart.setLinks(rw.readFileFromDisk("links"));
		printer.printConsole(hsStuttgart.startCrawler(cj));
		
	}
}
