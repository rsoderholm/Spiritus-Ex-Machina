package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;

/**
 * 
 * @author robinsoderholm
 *
 */

public class TextFileReader {
	String line = null;
//	private HashMap<String, String> map = new HashMap<>();

	public String[] read(String filepath) throws IOException {
		String[] splitParagraph = null;
		String lineTemp;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line = "";
			lineTemp = reader.readLine();
			while (lineTemp!=null) {
				line += lineTemp;
				lineTemp = reader.readLine();
			}
			reader.close();
			splitParagraph = line.split("#");
			for (int i = 0; i < splitParagraph.length; i++) {
				System.out.println(splitParagraph[i]);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return splitParagraph;
	}

//<<<<<<< HEAD
////	public static void main(String[] args) throws IOException {
////		TextFileReader reader = new TextFileReader();
////		// reader.readText("files/testscript.txt");
////		reader.read("files/testscript.txt");
////	}
//=======
	public String[] readChapters(String filepath) throws IOException {
		String[] splitChapter = null;
		File file = new File(filepath);
		try {
			System.out.println("Attempting to read from file in: "+file.getCanonicalPath());
			Scanner scanner = new Scanner(file);
			String line = "";

			while (scanner.hasNextLine()) {
				line += scanner.nextLine();
			}
			splitChapter = line.split("#");

			for (int i = 0; i < splitChapter.length; i++) {
				System.out.println(splitChapter[i]);
			}
		} catch (Exception ex) {
		}
		return splitChapter;

	}

//	public static void main(String[] args) throws IOException {
//		TextFileReader reader = new TextFileReader();
//		// reader.readText("files/testscript.txt");
//		reader.read("files/testscript.txt");
//		reader.readChapters("files/Chapters.txt");
//	}
//>>>>>>> origin/master

}
