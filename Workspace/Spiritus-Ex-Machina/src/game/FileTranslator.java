/*
 * FileTranslator
 * V2.0
 * Date: 20160510
 * Author: Björn Svensson
 */
package game;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * Class that handles translations between controller and TextFileReader.
 */
public class FileTranslator {
	private Controller controller;
	private TextFileReader fileReader;
	// private String[] currentChapter;

	/**
	 * Contructor for the translator.
	 * 
	 * @param controller
	 *            connects the controller class with this.
	 */
	public FileTranslator(Controller controller) {
		this.controller = controller;
		fileReader = new TextFileReader();
	}

	/**
	 * Method to load a new game
	 * 
	 * @return a String[] with all necessary information
	 */
	public String[] loadGame() {
		return fileReader.loadFromFile();

	}

	/**
	 * 
	 * @param chapter
	 *            which chapter to be read.
	 * @return the chapter as a String[]
	 * @throws IOException
	 */
	public String[] readChapter(String chapter) throws IOException {
		return fileReader.readChapters("files/" + chapter + "/" + chapter + ".txt");
	}

	/**
	 * Method to fill the navigation hashMap from a file
	 * 
	 * @param nav
	 *            the name of the specific file.
	 */
	public void addToNav(String nav, String chapter) {
		String[] navigation = null;
		try {
			navigation = new TextFileReader().read("files/" + chapter + "/" + nav + ".txt");
		} catch (Exception e) {
		}
		char where = Character.toLowerCase(nav.charAt(nav.length() - 1));
		switch (where) {
		case 'c':
			controller.addConversations(nav, navigation);
			controller.addCombat(nav);
			break;
		case 'a':
			controller.addConversations(nav, navigation);
			controller.addAbilityCheck(nav);
			break;
		case 'n':
			controller.addConversations(nav, navigation);
			controller.addNavigation(nav);
			break;
		default:
			controller.addNewChapter(nav);
			break;
		}

	}

	/**
	 * Method that prepares the files for saving.
	 * 
	 * @param itemChoice
	 *            the chosen item set
	 * @param stats
	 *            the stats on the player
	 * @param health
	 *            the current health of the player
	 * @param medGel
	 *            the amount of damage-removal items
	 * @param currentChapter
	 *            the current chapter the player is on
	 * @param currentConversation
	 *            the current conversation the player is on
	 * @throws FileNotFoundException
	 */
	public void save(int itemChoice, String stats, int health, int medGel, String currentChapter,
			String currentConversation) throws FileNotFoundException {
		fileReader.saveToFile(itemChoice, stats, health, medGel, currentChapter, currentConversation);
	}
}
