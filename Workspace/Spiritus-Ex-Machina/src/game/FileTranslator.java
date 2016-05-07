package game;

import java.io.IOException;

public class FileTranslator {
	private Controller controller;
	private TextFileReader fileReader;
	//	private String[] currentChapter;

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
	 * 
	 * @param chapter
	 *            which chapter to be read.
	 * @return the chapter as a String[]
	 * @throws IOException
	 */
	public String[] readChapter(String chapter) throws IOException {
		return fileReader.readChapters("files/" + chapter + ".txt");
		//		return currentChapter;
	}

	/**
	 * Method to fill the navigation hashMap from a file
	 * 
	 * @param nav
	 *            the name of the specific file.
	 */
	public void addToNav(String nav) {
		String[] navigation = null;
		try {
			navigation = fileReader.read("files/" + nav + ".txt");
		} catch (Exception e) {
		}
		char where = Character.toLowerCase(nav.charAt(nav.length()-1));
		switch (where) {
		case 'c':
			controller.addCombat(nav, navigation[0]);
			break;
		case 'a':
			controller.addAbilityCheck(nav, navigation[0], navigation[1], navigation[2], navigation[3]);
			break;
		case 'n':
			controller.addConversations(nav, navigation);
			controller.addNavigation(nav);
			break;
		default:
			System.out.println("something went wrong!");
			break;
		}

	}
}
