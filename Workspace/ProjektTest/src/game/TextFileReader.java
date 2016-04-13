package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TextFileReader {
	Controller controller = new Controller();
	private HashMap<String, String> navigation = new HashMap<String, String>();

	private void storeScript() throws FileNotFoundException {
		String line = " ";
		String i = null;

		try {
			FileReader fr = new FileReader("files/testscript.txt");
			BufferedReader br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				navigation.put(line, i);
			}
			for (String id : navigation.keySet()) {
				System.out.println(navigation.get(id));

			}
			br.close();

		} catch (IOException e) {
			System.out.print("File not found");
		}
	}
}
	// }

//	public static void main(String[] args) throws FileNotFoundException {
//		TextFileReader reader = new TextFileReader();
//		reader.storeScript();
//		// try {
//
//		// FileReader fr = new FileReader("files/testscript.txt");
//		// BufferedReader br = new BufferedReader(fr);
//		//
//		// String str;
//		// while((str = br.readLine()) != null) {
//		//
//		// }
//		// br.close();
//		// } catch (IOException e) {
//		// System.out.print("File not found");
//	}
//}
//// }