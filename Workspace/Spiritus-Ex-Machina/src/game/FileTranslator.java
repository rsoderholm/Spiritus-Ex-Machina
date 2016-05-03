package game;

import java.io.IOException;

public class FileTranslator {
	private Controller controller;
	private TextFileReader fileReader;
	private String[] currentChapter;

	/**
	 * Contructor for the translator.
	 * @param controller connects the controller class with this.
	 */
	public FileTranslator(Controller controller){
		this.controller = controller;
		fileReader = new TextFileReader();
	}

	/**
	 * 
	 * @param chapter which chapter to be read.
	 * @return the chapter as a String[]
	 * @throws IOException
	 */
	public String[] readChapter(String chapter) throws IOException{
		currentChapter = fileReader.readChapters("files/"+chapter+".txt");
		return currentChapter;
	}

	/**
	 * Method to fill the navigation hashMap from a file
	 * @param nav the name of the specific file.
	 */
	public void addToNav(String nav){
		String[] navigation = null;
		try {
			navigation = fileReader.read("files/"+nav+".txt");
		} catch (Exception e) {}
		if(navigation[0]!="chapter"){
			for (int i = 2; i < navigation.length; i+=2) {
				String[] secondSplit = navigation[i].split("¤");
				if(navigation[i]!=null){
					switch(secondSplit[0]){
					case "normal":
						navigation[i]=secondSplit[1];
						String[] nextNavi = navigation.clone();
						controller.addNavigation(nav, nextNavi);
						break;
					case "combat":
						controller.addCombat(nav,secondSplit[1]);
						break;
//					case "ability":
//						controller.getNavigation().put(navigation[i], () -> 
//						AbilityCheck(
//								secondSplit[1],
//								secondSplit[2],
//								secondSplit[3],
//								secondSplit[4]));
//						break;
					case "chapter":
						break;
					}
				}
			}		
//			controller.getConversationNavigation().put(nav, navigation);
		}
		else{	
			controller.setCurrentChapter(navigation);
		}

	}			
}

