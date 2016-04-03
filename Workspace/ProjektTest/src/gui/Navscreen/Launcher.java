
package gui.Navscreen;

import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.media.*;

public class Launcher extends Application {
	Stage window;
	Scene scene;
	ImageView iv1;
	Image image;
	private final String PATH = "files/Tales of the Future.mp3";
	File f;
	Media media;
	MediaPlayer mplayer;

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		BorderPane pane = new BorderPane();

		image = new Image("Machina.png");
		iv1 = new ImageView();
		iv1.setImage(image);
		pane.setCenter(iv1);

		scene = new Scene(pane);
		scene.getStylesheets().add("StyleSheet.css");
		window.setScene(scene);
		playMedia();
		window.setFullScreen(true);
		window.show();

		window.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			new JavaFxTest();
			window.close();
		});
	}

	private void playMedia() {

		f = new File(PATH);
		media = new Media(f.toURI().toString());
		mplayer = new MediaPlayer(media);
		mplayer.setAutoPlay(true);
	}
}
