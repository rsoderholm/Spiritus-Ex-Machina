package game;

import java.io.IOException;

public class FileTranslator {
	private Controller controller;
	private TextFileReader fileReader;
	private String[] currentChapter;

	public FileTranslator(Controller controller){
		this.controller = controller;
		fileReader = new TextFileReader();
	}

	public String[] readChapter(String chapter) throws IOException{
		currentChapter = fileReader.readChapters("files/"+chapter+".txt");
		return currentChapter;
	}
	public void addToNav(String nav){
		String[] navigation = null;
		try {
			navigation = fileReader.read("files/"+nav+".txt");
		} catch (Exception e) {}
		if(navigation[0]!="chapter"){
			for (int i = 2; i < navigation.length; i+=2) {
				String[] secondSplit = navigation[i].split("¤");
				if(navigation[i]!=null)
					switch(secondSplit[0]){
					case "normal":
						navigation[i]=secondSplit[1];
						controller.getConversationNavigation().put(nav, navigation);
						controller.getNavigation().put(nav, () -> {
							controller.setupDialog(controller.getConversationNavigation().get(nav));});
					}
			}
		}
		else{	
			controller.setCurrentChapter(navigation);
		}
	}
}

