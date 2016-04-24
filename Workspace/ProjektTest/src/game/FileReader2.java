package game;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.event.ListSelectionEvent;

public class FileReader2 {
	private ArrayList<String> list = new ArrayList<>();
	HashMap<String, String> map = new HashMap<>();
	String line = null;
	char stop = '¤';

	public void readText(String filepath) {
		try {
			Scanner textReader = new Scanner(new File(filepath));

			while (textReader.hasNextLine()) {
				String line = textReader.nextLine();
				list.add(line);
				map.put("Choice1", line);

				System.out.println(map.get("Choice1"));
			}
			textReader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FileReader2 reader = new FileReader2();
		reader.readText("files/testscript.txt");
	}

}
