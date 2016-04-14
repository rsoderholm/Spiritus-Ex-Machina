package gui.Navscreen;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import game.Controller;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GameGUI {

	private Button buttonattr;
	private VBox layout1;
	private Stage window;
	private Scene scene;

	//	private String dialogText1 = "";
	//	private String dialogText2 = "";
	//	private String dialogText3 = "";
	//	private String dialogText4 = "";

	private Text Evtext;
	private Text statusText;
	private Animation animation;

	private Button buttoninv;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private String eventText;

	private double width;
	private ImageView iv1;
	private Image image;

	private Rectangle2D bounds;
	private Screen screen;
	private double widthScreen;
	private double heightScreen;
	private String altOne;
	private String altTwo;
	private String altThree;
	private String altFour;	
	private Controller controller;

	public GameGUI(Controller controller) {
		this.controller=controller;
		window = new Stage();

		bounds = Screen.getPrimary().getVisualBounds();
		widthScreen = bounds.getWidth();
		heightScreen = bounds.getHeight();

		if (widthScreen < 1600) {
			width = 600;
		}
		else
			width = 1200;

		layout1 = new VBox();
		layout1.setAlignment(Pos.CENTER);
		scene = new Scene(layout1, widthScreen, heightScreen);
		scene.getStylesheets().add("StyleSheet.css");

		addImage();
		addtext();
		addbutton();
		addAttributes();
		addstatus();
		addinventory();

		layout1.getChildren().addAll(iv1, Evtext, button1, button2, button3, button4, statusText, buttoninv,
				buttonattr);

		buttonHandler();


		if (widthScreen < 1600) {
			button1.setStyle("-fx-font: 10 arial");
			button2.setStyle("-fx-font: 10 arial");
			button3.setStyle("-fx-font: 10 arial");
			button4.setStyle("-fx-font: 10 arial");
			buttoninv.setStyle("-fx-font: 10 arial");
			buttonattr.setStyle("-fx-font: 10 arial");
			Evtext.setFont(new Font(10));
			statusText.setFont(new Font(10));
			iv1.setFitHeight(200);
		}
		window.setResizable(false);
		window.setScene(scene);
		window.show();
	}
	public void textanimation() {
		animation = new Transition() {
			{

				setCycleDuration(Duration.millis(2000));
			}

			protected void interpolate(double frac) {
				final int length = eventText.length();
				final int n = Math.round(length * (float) frac);
				Evtext.setText(eventText.substring(0, n));
			}

		};
		animation.play();
	}
	public void addbutton() {
		// Knappar

		button1 = new Button("");
		button1.setMaxWidth(width);

		button2 = new Button("");
		button2.setMaxWidth(width);

		button3 = new Button("");
		button3.setMaxWidth(width);

		button4 = new Button("");
		button4.setMaxWidth(width);
	}

	public void addtext() {

		Evtext = new Text();
		Evtext.setWrappingWidth(width);
		Evtext.setFont(new Font(20));

		Evtext.setTextAlignment(TextAlignment.JUSTIFY);
		//		Evtext.setText(eventText);
		Evtext.setFill(Color.WHITE);

	}

	public void addImage() {
		image = new Image("JWET8.jpg");
		iv1 = new ImageView();
		iv1.setImage(image);
		iv1.setFitWidth(width);

	}


	public void addinventory() {
		buttoninv = new Button("Inventory");
		buttoninv.setMaxHeight(600);
		buttoninv.setMaxWidth(200);
	}

	public void addAttributes() {
		buttonattr = new Button("Attributes");
		buttonattr.setMaxWidth(200);
	}

	public void addstatus() {

		statusText = new Text();
		statusText.setFont(new Font(20));
		statusText.setTextAlignment(TextAlignment.CENTER);
		statusText.setFill(Color.WHITE);
		statusText.setText("Healthpoints: " + controller.getPlayer().getHealth() + "/" + controller.getPlayer().getMaxhealth());
	}

	public void changeHealth(){
		statusText.setText("Healthpoints: " + controller.getPlayer().getHealth() + "/" + controller.getPlayer().getMaxhealth());
	}
	public void init() {
		controller.navigation("init");



	}

	public void setEventText(String txt) {
		this.eventText = txt;
		Evtext.setText(eventText);
		textanimation();
	}
	public void setDialog(String dialog, int n, String navKey) {
		if(dialog!=null)
			switch(n){
			case 1:
				button1.setDisable(false);
				button1.setText(dialog);
				altOne = navKey;
				break;
			case 3:
				button2.setDisable(false);
				button2.setText(dialog);
				altTwo = navKey;
				break;
			case 5:
				button3.setDisable(false);
				button3.setText(dialog);
				altThree = navKey;
				break;
			case 7:
				button4.setDisable(false);
				button4.setText(dialog);
				altFour = navKey;
				break;
			}
	}

	public void disableButtons(){
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button1.setDisable(true);
		button2.setDisable(true);
		button3.setDisable(true);
		button4.setDisable(true);
	}

	public void setStatus( int nr){
		statusText.setText("Healthpoints: " + nr);
		textanimation();
	}
	public void setImage(String img){
		image = new Image(img);
		iv1.setImage(image);
	}
	public void buttonHandler() {

		button1.setOnAction(e -> {
			if(controller.getActiveCombat()==null)
				controller.navigation(altOne);
			else{
				controller.getActiveCombat().performCharacterAction(altOne);
			}
		});

		button2.setOnAction(e -> {
			if(controller.getActiveCombat()==null)
				controller.navigation(altTwo);
			else{
				controller.getActiveCombat().performCharacterAction(altTwo);
			}
		});

		button3.setOnAction(e -> {
			if(controller.getActiveCombat()==null)
				controller.navigation(altThree);
			else{
				controller.getActiveCombat().performCharacterAction(altThree);
			}
		});

		button4.setOnAction(e -> {
			if(controller.getActiveCombat()==null)
				controller.navigation(altFour);
			else{
				controller.getActiveCombat().performCharacterAction(altFour);
			}
		});

		buttonattr.setOnAction(e -> new Attributes());

		buttoninv.setOnAction(e -> new Inventory());
	}
}
