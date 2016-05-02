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
			for (int i = 0; i < splitParagraph.length; i++) {
				System.out.println(splitParagraph[i]);
			}
		} catch (Exception ex) {
		}
		return splitParagraph;
	}

//<<<<<<< HEAD
//	public static void main(String[] args) throws IOException {
//		TextFileReader reader = new TextFileReader();
//		// reader.readText("files/testscript.txt");
//		reader.read("files/testscript.txt");
//	}
//=======
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
			for (int i = 0; i < splitChapter.length; i++) {
				System.out.println(splitChapter[i]);
			}
		} catch (Exception ex) {
		}
		return splitChapter;

	}

	public static void main(String[] args) throws IOException {
		TextFileReader reader = new TextFileReader();
		// reader.readText("files/testscript.txt");
		reader.read("files/testscript.txt");
		reader.readChapters("files/Chapters.txt");
	}
//>>>>>>> origin/master

}
