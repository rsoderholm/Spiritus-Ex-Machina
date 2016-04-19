package game;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class TextFileReader {

	private ArrayList<String> list = new ArrayList<>();

	public void textReader(String filepath) {
		try {
			LineNumberReader lr = new LineNumberReader(new FileReader(filepath));
			String line = " ";

			while ((line = lr.readLine()) != null) {
				list.add(line);
				System.out.println(line);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TextFileReader t = new TextFileReader();
		t.textReader("files/testscript.txt");

	}

}
