/*
 * Launcher
 * V1.0
 * Date: 20160430 
 * Author: Ludwig Ninn 
 */
package gui.Navscreen;

import java.io.*;

import game.Controller;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.media.*;

/**
 * 
 * Class Launcher initiates the game. Holds the main method.
 *
 */
public class Launcher extends Application {
	private Stage window;
	private Scene scene;
	private ImageView iv1;
	private Image image;
	private File f;
	private Media media;
	private MediaPlayer mplayer;
	private VBox layout1;
	private Rectangle2D bounds;
	private Screen screen;
	private double widthScreen;
	private double heightScreen;

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {

		window = new Stage();
		screen = Screen.getPrimary();
		bounds = screen.getVisualBounds();
		window.setWidth(bounds.getWidth());
		window.setHeight(bounds.getHeight());
		widthScreen = bounds.getWidth();
		heightScreen = bounds.getHeight();

		window = primaryStage;
		layout1 = new VBox();

		addBackground();
		playMedia();
		layout1.getChildren().addAll(iv1);
		scene = new Scene(layout1);

		window.setScene(scene);

		window.setFullScreen(true);
		window.show();
		window.sizeToScene();
		window.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			window.close();
			new Controller();
		});

	}

	/**
	 * PlayMedia start a soundtrack on a seprate Thread.
	 */
	public void playMedia() {

		f = new File("soundtrack/Main Theme.mp3");
		media = new Media(f.toURI().toString());
		mplayer = new MediaPlayer(media);
		mplayer.setAutoPlay(true);
	}

	/**
	 * AddBackground starting backround.
	 */
	public void addBackground() {
		image = new Image("Machina.png");
		iv1 = new ImageView();
		iv1.setImage(image);
		iv1.setFitWidth(widthScreen);

	}

}
