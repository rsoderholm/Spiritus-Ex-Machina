package gui.Navscreen;

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

public class JavaFxTest {

	private VBox layout1;
	private Stage window;
	private Scene scene;

	private String dialogText1;
	private String dialogText2;
	private String dialogText3;
	private String dialogText4;

	private Text text;
	private Text statusText;
	private Animation animation;

	private Button buttoninv;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private String eventText;

	private double width = 1200;
	private double height = Double.MAX_VALUE;
	private ImageView iv1;
	private ImageView iv2;
	private Image image;

	private Rectangle2D bounds;
	private Screen screen;
	private double widthScreen;
	private double heightScreen;

	public JavaFxTest() {

		window = new Stage();
		screen = Screen.getPrimary();
		bounds = screen.getVisualBounds();
		window.setWidth(bounds.getWidth());
		window.setHeight(bounds.getHeight());
		widthScreen = bounds.getWidth();
		heightScreen = bounds.getHeight();

		layout1 = new VBox();
		layout1.setAlignment(Pos.CENTER);
		scene = new Scene(layout1, widthScreen, heightScreen);
		scene.getStylesheets().add("StyleSheet.css");

		addBackgroundImage();
		addImage();
		addtext();
		addbutton();
		status(100);
		inventory();
		layout1.getChildren().addAll(iv1, text, button1, button2, button3, button4, statusText, buttoninv);

		window.setResizable(false);
		window.setScene(scene);

		window.show();
	}

	public void addbutton() {
		// Knappar
		button1 = new Button(dialogText1);
		button1.setOnAction(e -> textanimation());
		button1.setMaxWidth(width);

		button2 = new Button(dialogText2);
		button2.setOnAction(e -> text.setText("tempus convallis nibh, nec pharetra quam congue et"));
		button2.setMaxWidth(width);

		button3 = new Button(dialogText3);
		button3.setOnAction(e -> text.setText("Nulla a tellus dolor."));
		button3.setMaxWidth(width);

		button4 = new Button(dialogText4);
		button4.setOnAction(e -> text.setText("nec elementum risus, finibus elementum tortor"));
		button4.setMaxWidth(width);
	}

	public void addtext() {
		eventText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Vestibulum sed sem eget mauris semper sollicitudin eget ut lacus. "
				+ "Nulla tempus convallis nibh, nec pharetra quam congue et. Nulla a tellus dolor. D"
				+ "onec euismod ornare erat, at finibus lacus lobortis sed. "
				+ "Donec nec elementum risus, finibus elementum tortor. ";

		text = new Text();

		text.setWrappingWidth(1200);
		text.setFont(new Font(20));

		text.setTextAlignment(TextAlignment.JUSTIFY);
		text.setText(eventText);
		text.setFill(Color.WHITE);

		textanimation();
	}

	public void addImage() {
		image = new Image("1200x300.png");
		iv1 = new ImageView();
		iv1.setImage(image);
		iv1.setFitWidth(1200);

	}

	public void addBackgroundImage() {

	}

	public void textanimation() {
		animation = new Transition() {
			{

				setCycleDuration(Duration.millis(2000));
			}

			protected void interpolate(double frac) {
				final int length = eventText.length();
				final int n = Math.round(length * (float) frac);
				text.setText(eventText.substring(0, n));
			}

		};
		animation.play();
	}

	public void setDialog(String dialog, int n) {
		if (n == 1) {
			button1.setText(dialogText1);
		}
		if (n == 2) {
			button2.setText(dialogText2);
		}
		if (n == 3) {
			button3.setText(dialogText3);
		}
		if (n == 4) {
			button4.setText(dialogText4);

		}
	}

	public void inventory() {
		buttoninv = new Button("Inventory");
		buttoninv.setOnAction(e -> new Inventory());
		buttoninv.setMaxWidth(200);
	}

	public void status(int Nhp) {
		String hp = "Healthpoints: ";
		int nhp = Nhp;
		statusText = new Text();
		statusText.setFont(new Font(20));
		statusText.setTextAlignment(TextAlignment.CENTER);
		statusText.setFill(Color.WHITE);
		statusText.setText(hp + nhp);
	}
}
