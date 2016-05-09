package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage window;
	private Button button1;
	private Button button2;
	private Button button3;
	private int inventoryValue;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) {
		
		window = primaryStage;
		BorderPane root = new BorderPane();

		TitledPane t1 = new TitledPane();
		GridPane grid = new GridPane();
		grid.setVgap(4);
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.add(new Label("Runners - A specialized taskforce trained in the art of investigation" + "\n"
				+ "to find and contain rouge androids and suspects enhanced with" + "\n"
				+ "cybernetics. They are known for their efficiency and their constraind" + "\n"
				+ "temper. They rearly fire of their guns unless they are sure that their" + "\n"
				+ "target is demed to be inhuman. One way or another." + "\n" + " " + "\n" + "- Increased Social Skills"
				+ "\n" + "- Increased Hacking" + "\n" + "- Decreased Damage"), 1, 0);
		grid.add(button1 = new Button("Continue"), 2, 1);
		t1.setText("Runner");
		t1.setContent(grid);

		TitledPane t2 = new TitledPane();
		GridPane grid1 = new GridPane();
		grid1.setVgap(4);
		grid1.setPadding(new Insets(5, 5, 5, 5));
		grid1.add(new Label("Judge - The role of  Judge's combines those of judge and police" + "\n"
				+ "officer, thus avoiding long legal wrangles by allowing for criminals" + "\n"
				+ "to be tried and sentenced on the spot.  The Judges themselves are" + "\n"
				+ "not above the law . A violation that would earn a citizen a few" + "\n"
				+ "months in an Cube would get a Judge a twenty-year sentence." + "\n" + "" + "\n" + "- Incrased Damage"
				+ "\n" + "- Increased Health" + "\n" + "- Decreased Social skills"), 1, 0);
		grid1.add(button2 = new Button("Continue"), 2, 1);
		t2.setText("Judge");
		t2.setContent(grid1);

		TitledPane t3 = new TitledPane();
		GridPane grid2 = new GridPane();
		grid2.setVgap(4);
		grid2.setPadding(new Insets(5, 5, 5, 5));
		grid2.add(new Label("Hacker - The digital interagation divison. They specialize in getting" + "\n"
				+ "information from suspects as quick ans easy as possible. With the" + "\n"
				+ "to be tried and sentenced on the spot.  The Judges themselves are" + "\n"
				+ "hich-tech devices the get the job done nice and quiet, without" + "\n"
				+ "making to much noice or drawing to much attention to them." + "\n" + "" + "\n" + "- Incrased Hacking"
				+ "\n" + "- Increased Social Skills" + "\n" + "- Decreased Health"), 1, 0);

		grid2.add(button3 = new Button("Continue"), 2, 1);

		t3.setText("Hacker");
		t3.setContent(grid2);

		Accordion accordion = new Accordion();
		accordion.getPanes().addAll(t1, t2, t3);
		root.setCenter(accordion);
		Scene scene = new Scene(root, 780, 450);
		scene.getStylesheets().add("application.css");

		buttonHandler();

		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}

	public void buttonHandler() {
		button1.setOnAction(e -> {
			inventoryValue = 1;
			window.close();
			//new HASSANSKLASS();
		});

		button2.setOnAction(e -> {
			inventoryValue = 2;
			window.close();
			//new HASSANSKLASS();
		});

		button3.setOnAction(e -> {
			inventoryValue = 3;
			//new HASSANSKLASS();
		});
	}

	public int inventoryValue() {
		return inventoryValue;
	}
}