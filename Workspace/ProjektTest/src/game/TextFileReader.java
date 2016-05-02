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

/**
 * 
 * @author robinsoderholm
 *
 */

public class TextFileReader {
	String line = null;
	private HashMap<String, String> map = new HashMap<>();

	public void read(String filepath) throws IOException {

		try {

			Scanner scanner = new Scanner(new File(filepath));
			String line = "";
			while (scanner.hasNextLine()) {
				line += scanner.nextLine();
			}
			String[] splitParagraph = line.split("#");
			for (int i = 0; i < splitParagraph.length; i++) {
				System.out.println(splitParagraph[i]);
			}

		}

		catch (Exception ex) {
			System.out.println("Problem");

		}

	}

	public static void main(String[] args) throws IOException {
		TextFileReader reader = new TextFileReader();
		// reader.readText("files/testscript.txt");
		reader.read("files/testscript.txt");
	}

}
