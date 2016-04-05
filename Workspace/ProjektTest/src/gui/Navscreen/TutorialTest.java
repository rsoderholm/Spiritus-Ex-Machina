package gui.Navscreen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class TutorialTest {

	static JavaFxTest main;

	public TutorialTest() {
		readScript("files/Tut.txt");
	}

	public static void readScript(String filename) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
			String[] parts;
			String lines = "";

			String str = br.readLine();

			while (str != null) {
				parts = str.split("¤");

				str = br.readLine();

				lines = parts[0];
				
			}
			br.close();

		} catch (IOException e) {
			System.out.println("Read: " + e);
		}

	}

	public static void main(String[] args) {
		new TutorialTest();
	}

}
