package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("files/testscript.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str + "\n");
			}
			br.close();
		} catch (IOException e) {
			System.out.print("File not found");
		}
 	}
}