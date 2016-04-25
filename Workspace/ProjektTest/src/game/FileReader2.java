package game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader2 {
	private ArrayList<String> list = new ArrayList<>();
	String line = null;

	public void read(String filepath) throws IOException {
		Scanner scanner = new Scanner(new File(filepath));

		try {
			while (scanner.hasNext()) {
				String[] tokens = scanner.nextLine().split("¤");
				String last = tokens[tokens.length - 1];
				System.out.println(last);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	// private ArrayList<String> list = new ArrayList<>();
	// HashMap<String, String> map = new HashMap<>();
	// String line = null;
	// char stop = '¤';
	//
	// public void readText(String filepath) {
	// try {
	// Scanner textReader = new Scanner(new File(filepath));
	//
	// while (textReader.hasNextLine()) {
	// String line = textReader.nextLine();
	// list.add(line);
	// map.put("Choice1", line);
	//
	// System.out.println(map.get("Choice1"));
	// }
	// textReader.close();
	//
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// }

	public static void main(String[] args) throws IOException {
		FileReader2 reader = new FileReader2();
		// reader.readText("files/testscript.txt");
		reader.read("files/testscript.txt");
	}

}
