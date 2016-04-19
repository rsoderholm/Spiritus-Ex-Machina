package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class TestFileReader2 {
	private ArrayList<String> list = new ArrayList<>();
	FileReader fileReader = null;
	String line = null;
	int counter = 0;

	public void textReader(String filepath) {
		try {
			fileReader = new FileReader(filepath);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = " ";

			while ((line = reader.readLine()) != null) {
				counter++;
				if (counter == 1 || counter == 2 || counter == 3 || counter == 4) {
					list.add(line);
					System.out.println(line);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		}
	public void someMethod() {
		HashMap<String, String> navigation = controller.getNavigationMap();
		
	}
//	public void textReader2(String filepath) {
//		try {
//			fileReader = new FileReader(filepath);
//			BufferedReader reader = new BufferedReader(fileReader);
//			String line = " ";
//
//			while ((line = reader.readLine()) != null) {
//				counter++;
//				if (counter == 6 || counter == 7 || counter == 8 || counter == 9) {
//					list.add(line);
//					System.out.println(line);
//
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		TestFileReader2 t = new TestFileReader2();
		t.textReader("files/testscript.txt");
//		t.textReader2("files/testscript.txt");
		

	}

}
