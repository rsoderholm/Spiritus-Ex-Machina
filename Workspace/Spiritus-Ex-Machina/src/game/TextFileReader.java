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
	private HashMap<String, String> map = new HashMap<>();

	public String[] read(String filepath) throws IOException {
		String[] splitParagraph = null; 
		try {
			Scanner scanner = new Scanner(new File(filepath));
			String line = "";
			while (scanner.hasNextLine()) {
				line += scanner.nextLine();
			}
			splitParagraph = line.split("#");
			for (int i = 0; i < splitParagraph.length; i++) {
				System.out.println(splitParagraph[i]);
			}
		}catch (Exception ex) {}
		return splitParagraph;
	}

	public static void main(String[] args) throws IOException {
		TextFileReader reader = new TextFileReader();
		// reader.readText("files/testscript.txt");
		reader.read("files/testscript.txt");
	}

}
