package gui.Navscreen;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Attributes {

	private VBox layout1;
	private Stage window;
	private Scene scene;
	private Text inventoryText;
	private String inv;
	ArrayList<String> inventory = new ArrayList<String>();
	JavaFxTest main;
	double width;

	public Attributes() {
	
		drawWindow();
	}

	public void drawWindow() {
		window = new Stage();
		layout1 = new VBox();
		layout1.setAlignment(Pos.CENTER);
		scene = new Scene(layout1);
		scene.getStylesheets().add("StyleSheet.css");

		addTest("Strength: " + " 1");

		layout1.getChildren().addAll(inventoryText);

		window.setX(1600);
		window.setAlwaysOnTop(true);
		window.setResizable(false);
		window.setScene(scene);
		window.setHeight(700);
		window.setWidth(300);
		window.show();
	}

	public void updatelist() {

	}

	public void addTest(String inv) {
		this.inv = inv;
		inventoryText = new Text();
		inventoryText.setFont(new Font(20));
		inventoryText.setTextAlignment(TextAlignment.CENTER);
		inventoryText.setFill(Color.WHITE);

		inventoryText.setText(inv);
	}



}
