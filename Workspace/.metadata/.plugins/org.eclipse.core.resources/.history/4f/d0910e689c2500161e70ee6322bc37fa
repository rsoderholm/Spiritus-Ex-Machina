package gui.Navscreen;

import game.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ItemGUI {

	private Stage window;
	private Button button1;
	private Button button2;
	private Button button3;
	private int inventoryValue;

	private TitledPane tpRunner;
	private GridPane gridRunner;

	private TitledPane tpJudge;
	private GridPane gridJudge;

	private TitledPane taHacker;
	private GridPane gridHacker;
	
	private Controller controller;

	public ItemGUI(Controller controller) {
		this.controller = controller;
		window = new Stage();
		BorderPane root = new BorderPane();
		
		runnerPane();
		judgePane();
		hackerPane();

		Accordion accordion = new Accordion();
		accordion.getPanes().addAll(tpRunner, tpJudge, taHacker);
		root.setCenter(accordion);
		Scene scene = new Scene(root, 780, 450);
		scene.getStylesheets().add("application.css");

		buttonHandler();

		window.setScene(scene);
		window.setResizable(false);
		window.initStyle(StageStyle.UNDECORATED);
		window.show();
	}

	public void buttonHandler() {
		button1.setOnAction(e -> {
			inventoryValue = 1;
			new AttributeGUI(1, controller);	
			window.close();	
		});

		button2.setOnAction(e -> {
			inventoryValue = 2;
			new AttributeGUI(2, controller);
			window.close();	
		});

		button3.setOnAction(e -> {
			inventoryValue = 3;
			new AttributeGUI(3, controller);
			window.close();
		});
	}

	public void runnerPane() {
		tpRunner = new TitledPane();
		gridRunner = new GridPane();
		gridRunner.setVgap(4);
		gridRunner.setPadding(new Insets(5, 5, 5, 5));
		gridRunner.add(new Label("Runners - A specialized taskforce trained in the art of investigation" + "\n"
				+ "to find and contain rouge androids and suspects enhanced with" + "\n"
				+ "cybernetics. They are known for their efficiency and their constraind" + "\n"
				+ "temper. They rearly fire of their guns unless they are sure that their" + "\n"
				+ "target is demed to be inhuman. One way or another." + "\n" + " " + "\n" + "- Increased Social Skills"
				+ "\n" + "- Increased Hacking" + "\n" + "- Decreased Damage"), 1, 0);
		gridRunner.add(button1 = new Button("Continue"), 2, 1);
		tpRunner.setText("Runner");
		tpRunner.setContent(gridRunner);
	}

	public void judgePane() {
		tpJudge = new TitledPane();
		gridJudge = new GridPane();
		gridJudge.setVgap(4);
		gridJudge.setPadding(new Insets(5, 5, 5, 5));
		gridJudge.add(new Label("Judge - The role of  Judge's combines those of judge and police" + "\n"
				+ "officer, thus avoiding long legal wrangles by allowing for criminals" + "\n"
				+ "to be tried and sentenced on the spot.  The Judges themselves are" + "\n"
				+ "not above the law . A violation that would earn a citizen a few" + "\n"
				+ "months in an Cube would get a Judge a twenty-year sentence." + "\n" + "" + "\n" + "- Incrased Damage"
				+ "\n" + "- Increased Health" + "\n" + "- Decreased Social skills"), 1, 0);
		gridJudge.add(button2 = new Button("Continue"), 2, 1);
		tpJudge.setText("Judge");
		tpJudge.setContent(gridJudge);
	}

	public void hackerPane() {
		taHacker = new TitledPane();
		gridHacker = new GridPane();
		gridHacker.setVgap(4);
		gridHacker.setPadding(new Insets(5, 5, 5, 5));
		gridHacker.add(new Label("Hacker - The digital interagation divison. They specialize in getting" + "\n"
				+ "information from suspects as quick ans easy as possible. With the" + "\n"
				+ "to be tried and sentenced on the spot.  The Judges themselves are" + "\n"
				+ "hich-tech devices the get the job done nice and quiet, without" + "\n"
				+ "making to much noice or drawing to much attention to them." + "\n" + "" + "\n" + "- Incrased Hacking"
				+ "\n" + "- Increased Social Skills" + "\n" + "- Decreased Health"), 1, 0);

		gridHacker.add(button3 = new Button("Continue"), 2, 1);

		taHacker.setText("Hacker");
		taHacker.setContent(gridHacker);
	}

	public int inventoryValue() {
		return inventoryValue;
	}

}