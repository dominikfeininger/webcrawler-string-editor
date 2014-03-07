package editoren;

import genericInAnOutPut.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class FileContentEditorMain {

	public static void main(String[] args) {
		Editor editor = new Editor();
		ReadAndWrite rw = new ReadAndWrite();
		
		//separate
		//rw.writeToFileSeparated((editor.spaceSeperator(rw.readFileFromDisk("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/namen.txt"))));
		//rw.printConsoleSeparated((editor.spaceSeperator(rw.readFileFromDisk("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/namen.txt"))));
		
		//replace (at) -> @
		//rw.writeToFile(editor.atSubstiut(rw.readFileFromDisk("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/emails.txt")));
		
		//replace (@) -> @
		//rw.writeToFile(editor.atSubstiut2(rw.readFileFromDisk("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/emails.txt")));
		
		//remove empty lines
		//rw.writeToFile(editor.removelines(rw.readFileFromDisk("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/emails.txt")));
		//rw.writeToFile(editor.removelines(rw.readFileFromDisk("namen")), "namen");
		
		//remove ,
		//rw.printConsoleSeparated((editor.removeComma(rw.readFileFromDisk("/Users/dominikfeininger/Dropbox/Master_Thesis/Schramm_HIWI_Job/namen.txt"))));
		
		//add domain
		rw.printConsole(editor.addDomain(rw.readFileFromDisk("emails2")));
	}
}
