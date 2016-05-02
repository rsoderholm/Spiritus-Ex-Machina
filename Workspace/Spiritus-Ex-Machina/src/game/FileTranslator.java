package game;

import java.io.IOException;

public class FileTranslator {
	private Controller controller;
	private TextFileReader fileReader;

	public FileTranslator(Controller controller){
		this.controller = controller;
		fileReader = new TextFileReader();
	}

	public void readChapter(String chapter) throws IOException{
		String[] chapterArray = fileReader.read("chapters/"+chapter+".txt");
		for (int i = 0; i < chapterArray.length; i++) {
			String test = chapterArray[i];
			addToNav(test);
		}
	}
	public void addToNav(String nav){
		String[] navigation = null;
		try {
			navigation = fileReader.read("conversations/"+nav+".txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 2; i < navigation.length; i+=2) {
			String[] secondSplit = navigation[i].split("¤");
			if(navigation[i]!=null){
				switch(secondSplit[0]){
				case "normal":
					String navi=secondSplit[1];
					navigation[i]=secondSplit[1];
					controller.getConversationNavigation().put(nav, navigation);
					controller.getNavigation().put(nav, () -> {
						controller.setupDialog(controller.getConversationNavigation().get(nav));});
				}
			}
		}
		//		controller.getNavigation().put(nav, () -> {
		//			controller.setupDialog(controller.getConversationNavigation().get(nav));});
	}
}