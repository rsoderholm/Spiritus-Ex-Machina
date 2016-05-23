package game;

import java.io.FileNotFoundException;
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

	public String[] loadGame(){
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
			navigation = new TextFileReader().read("files/" + nav + ".txt");
		} catch (Exception e) {
		}
		char where = Character.toLowerCase(nav.charAt(nav.length()-1));
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
	public void save(int itemChoice, String stats,int health,int medGel, String currentChapter, String currentConversation) throws FileNotFoundException{
		fileReader.saveToFile(itemChoice,stats,health,medGel, currentChapter, currentConversation);
	}
}
