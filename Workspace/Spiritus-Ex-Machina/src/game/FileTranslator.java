package game;

public class FileTranslator {
	private Controller controller;
	private TextFileReader fileReader;
	
	public FileTranslator(Controller controller){
		this.controller = controller;
		fileReader = new TextFileReader();
	}
}
