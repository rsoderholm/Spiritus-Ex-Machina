package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;

/**
 * 
 * @author Robin Söderholm
 * @author Björn Svensson
 */

public class TextFileReader {

	public String[] read(String filepath) throws IOException {
		String[] splitParagraph = null;
		try {
			Scanner scanner1 = new Scanner(new File(filepath));
			String line = "";
			while (scanner1.hasNextLine()) {
				line += scanner1.nextLine();
			}
			splitParagraph = line.split("#");
			scanner1.close();
			scanner1=null;
		} catch (Exception ex) {
		}
		return splitParagraph;
	}

	public String[] readChapters(String filepath) throws IOException {
		String[] splitChapter = null;
		try {
			Scanner scanner2 = new Scanner(new File(filepath));
			String line = "";

			while (scanner2.hasNextLine()) {
				line += scanner2.nextLine();
			}
			splitChapter = line.split("#");
			scanner2.close();
			scanner2=null;
		} catch (Exception ex) {
		}
		return splitChapter;

	}

	public void saveToFile(int itemChoice, String stats,int health,int medGel, String currentChapter, String currentConversation) throws FileNotFoundException{
		File dir = new File("save");
		if(!dir.exists()) {
			dir.mkdir();
		}
		try {
			Writer pw = new PrintWriter("save/SeMsave");
			pw.write("Save#");
			pw.write(itemChoice+"#");
			pw.write(stats+"#");
			pw.write(""+health+"#");
			pw.write(""+medGel+"#");
			pw.write(currentChapter+"#");
			pw.write(currentConversation);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] loadFromFile() {
		String[] splitLoadFile = null;
		try {
			Scanner scanner2 = new Scanner(new File("save/SeMsave"));
			String line = "";

			while (scanner2.hasNextLine()) {
				line += scanner2.nextLine();
			}
			splitLoadFile = line.split("#");
			scanner2.close();
			scanner2=null;
		} catch (Exception ex) {
		}
		return splitLoadFile;

	}

}
